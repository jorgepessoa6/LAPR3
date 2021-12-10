CREATE OR REPLACE PROCEDURE procgettime (
    retorno    OUT SYS_REFCURSOR,
    username   clients.username%TYPE,
    mes        VARCHAR
) AS
BEGIN
    OPEN retorno FOR SELECT
                         end_date - start_date
                     FROM
                         trips
                         INNER JOIN clients ON clients.email = trips.email
                                               AND clients.username = username
                                               AND EXTRACT(MONTH FROM trips.start_date) = mes
                                               AND EXTRACT(MONTH FROM trips.end_date) = mes;

END;