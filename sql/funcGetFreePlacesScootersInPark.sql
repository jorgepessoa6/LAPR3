CREATE OR REPLACE FUNCTION funcgetfreeplacesscootersinpark (
    idpark     parks.park_id%TYPE,
    username   clients.username%TYPE
) RETURN INTEGER AS
    cont INTEGER;
BEGIN
    SELECT
        max_scooters - (
            SELECT
                COUNT(*)
            FROM
                escooter
                INNER JOIN vehicles ON vehicles.vehicle_desc = escooter.vehicle_desc
                                       AND vehicles.estado = '1'
                INNER JOIN vehicle_parks ON vehicle_parks.vehicle_desc = vehicles.vehicle_desc
                INNER JOIN parks ON parks.park_id = vehicle_parks.park_id
                                    AND parks.park_id = idpark
                INNER JOIN trips ON trips.vehicle_desc = vehicles.vehicle_desc
                INNER JOIN clients ON clients.email = trips.email
                                      AND clients.username = username
        )
    INTO cont
    FROM
        parks_info
        INNER JOIN parks ON parks.latitude = parks_info.latitude
                            AND parks.park_id = idpark;

    RETURN cont;
END funcgetfreeplacesscootersinpark;