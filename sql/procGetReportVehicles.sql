CREATE OR REPLACE PROCEDURE procgetreportvehicles (
    retorno OUT SYS_REFCURSOR
) AS
BEGIN
    OPEN retorno FOR SELECT
                         clients.username,
                         vehicles.vehicle_desc
                     FROM
                         vehicles
                         INNER JOIN trips ON trips.vehicle_desc = vehicles.vehicle_desc
                                             AND EXISTS (
                             SELECT
                                 start_date
                             FROM
                                 trips
                         )
                         INNER JOIN clients ON clients.email = trips.email
                                               AND clients.email = trips.email;

END;