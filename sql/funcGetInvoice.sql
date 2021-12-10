CREATE OR REPLACE FUNCTION funcgetinvoice (
    username   clients.username%TYPE,
    mes        INTEGER,
    retorno    OUT SYS_REFCURSOR
) RETURN INTEGER AS

    discounted_points   clients.points%TYPE;
    pontos              clients.points%TYPE;
    valor               invoices.value%TYPE;
BEGIN
    SELECT
        points
    INTO pontos
    FROM
        clients
        INNER JOIN trips ON trips.email = clients.email
                            AND clients.username = username
                            AND EXTRACT(MONTH FROM trips.start_date) = mes
                            AND EXTRACT(MONTH FROM trips.end_date) = mes;

    SELECT
        value
    INTO valor
    FROM
        invoices
        INNER JOIN trips ON trips.cod_trip = invoices.cod_trip
        INNER JOIN clients ON clients.email = trips.email
                              AND clients.username = username
                              AND EXTRACT(MONTH FROM trips.start_date) = mes
                              AND EXTRACT(MONTH FROM trips.end_date) = mes;

    discounted_points := 0;
    IF pontos < 10 THEN
        OPEN retorno FOR SELECT
                             points,
                             value
                         FROM
                             invoices
                             INNER JOIN trips ON trips.cod_trip = invoices.cod_trip
                                                 AND EXTRACT(MONTH FROM trips.start_date) = mes
                                                 AND EXTRACT(MONTH FROM trips.end_date) = mes
                             INNER JOIN clients ON clients.email = trips.email
                                                   AND clients.username = username;

    END IF;

    WHILE valor >= 0 AND pontos >= 10 LOOP
        valor := valor - 1;
        pontos := pontos - 10;
        discounted_points := discounted_points + 10;
    END LOOP;

    UPDATE clients
    SET
        clients.points = pontos
    WHERE
        clients.username = username;

    OPEN retorno FOR SELECT
                        clients.points,
                        round(invoices.value, 2)
                    FROM
                        invoices
                        INNER JOIN trips ON trips.cod_trip = invoices.cod_trip
                                            AND EXTRACT(MONTH FROM trips.start_date) = mes
                                            AND EXTRACT(MONTH FROM trips.end_date) = mes
                        INNER JOIN clients ON clients.email = trips.email
                                              AND clients.username = username;

    RETURN discounted_points;
END funcgetinvoice;