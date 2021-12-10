CREATE OR REPLACE PROCEDURE procgetinvoice (
    retorno    OUT SYS_REFCURSOR,
    mes        varchar,
    username   clients.username%TYPE
) AS
    cont_bikes      INTEGER;
    cont_scooters   INTEGER;
BEGIN
    SELECT
        COUNT(*)
    INTO cont_bikes
    FROM
        bicycle
        INNER JOIN vehicles ON vehicles.vehicle_desc = bicycle.vehicle_desc
        INNER JOIN trips ON trips.vehicle_desc = vehicles.vehicle_desc
                            AND EXTRACT(MONTH FROM trips.start_date) = mes
                            AND EXTRACT(MONTH FROM trips.end_date) = mes
        INNER JOIN clients ON clients.email = trips.email
                              AND clients.username = username;

    SELECT
        COUNT(*)
    INTO cont_scooters
    FROM
        escooter
        INNER JOIN vehicles ON vehicles.vehicle_desc = escooter.vehicle_desc
        INNER JOIN trips ON trips.vehicle_desc = vehicles.vehicle_desc
                            AND EXTRACT(MONTH FROM trips.start_date) = mes
                            AND EXTRACT(MONTH FROM trips.end_date) = mes
        INNER JOIN clients ON clients.email = trips.email
                              AND clients.username = username;

    IF cont_bikes > 0 THEN
        OPEN retorno FOR SELECT
                             bicycle.vehicle_desc,
                             trips.start_date,
                             trips.end_date,
                             parks.latitude,
                             parks.longitude,
                             trips.latitude_end,
                             trips.longitude_end
                         FROM
                             bicycle
                             INNER JOIN vehicles ON vehicles.vehicle_desc = bicycle.vehicle_desc
                             INNER JOIN vehicle_parks ON vehicle_parks.vehicle_desc = vehicles.vehicle_desc
                             INNER JOIN parks ON parks.park_id = vehicle_parks.park_id
                             INNER JOIN trips ON trips.vehicle_desc = vehicles.vehicle_desc
                                                 AND EXTRACT(MONTH FROM trips.start_date) = mes
                                                 AND EXTRACT(MONTH FROM trips.end_date) = mes
                             INNER JOIN clients ON clients.email = trips.email
                                                   AND clients.username = username;

    END IF;

    IF cont_scooters > 0 THEN
        OPEN retorno FOR SELECT
                             escooter.vehicle_desc,
                             trips.start_date,
                             trips.end_date,
                             parks.latitude,
                             parks.longitude,
                             trips.latitude_end,
                             trips.longitude_end
                         FROM
                             escooter
                             INNER JOIN vehicles ON vehicles.vehicle_desc = escooter.vehicle_desc
                             INNER JOIN vehicle_parks ON vehicle_parks.vehicle_desc = vehicles.vehicle_desc
                             INNER JOIN parks ON parks.park_id = vehicle_parks.park_id
                             INNER JOIN trips ON trips.vehicle_desc = vehicles.vehicle_desc
                                                 AND EXTRACT(MONTH FROM trips.start_date) = mes
                                                 AND EXTRACT(MONTH FROM trips.end_date) = mes
                             INNER JOIN clients ON clients.email = trips.email
                                                   AND clients.username = username;

    END IF;

END;