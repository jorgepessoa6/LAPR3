CREATE OR REPLACE FUNCTION funcgetvalue (
    username   clients.username%TYPE,
    mes        INTEGER
) RETURN FLOAT AS
    pontos   clients.points%TYPE;
    valor    invoices.value%TYPE;
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

    WHILE valor >= 0 AND pontos >= 10 LOOP
        valor := valor - 1;
        pontos := pontos - 10;
    END LOOP;

    RETURN valor;
END funcgetvalue;