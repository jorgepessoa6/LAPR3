CREATE OR REPLACE FUNCTION funcgetpreviouspoints (
    username   clients.username%TYPE,
    mes        INTEGER
) RETURN INTEGER AS
    pontos clients.points%TYPE;
BEGIN
    IF mes = 1 THEN
        SELECT
            points
        INTO pontos
        FROM
            clients
            INNER JOIN trips ON trips.email = clients.email
                                AND clients.username = username
                                AND EXTRACT(MONTH FROM trips.start_date) = 12
                                AND EXTRACT(MONTH FROM trips.end_date) = 12
                                AND EXTRACT(YEAR FROM trips.start_date) = EXTRACT(YEAR FROM trips.start_date) - 1
                                AND EXTRACT(YEAR FROM trips.end_date) = EXTRACT(YEAR FROM trips.end_date) - 1;

    ELSE
        SELECT
            points
        INTO pontos
        FROM
            clients
            INNER JOIN trips ON trips.email = clients.email
                                AND clients.username = username
                                AND EXTRACT(MONTH FROM trips.start_date) = mes - 1
                                AND EXTRACT(MONTH FROM trips.end_date) = mes - 1;

    END IF;

    RETURN pontos;
END funcgetpreviouspoints;