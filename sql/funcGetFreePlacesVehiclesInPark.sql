CREATE OR REPLACE FUNCTION funcgetfreeplacesvehiclesinpark (
    username   clients.username%TYPE,
    idpark     parks.park_id%TYPE
) RETURN INTEGER AS
    cont               INTEGER;
    number_escooters   INTEGER;
    number_bicycles    INTEGER;
BEGIN
    SELECT
        COUNT(*)
    INTO number_escooters
    FROM
        escooter
        INNER JOIN vehicles ON vehicles.vehicle_desc = escooter.vehicle_desc
                               AND vehicles.estado = '1'
        INNER JOIN vehicle_parks ON vehicle_parks.vehicle_desc = vehicles.vehicle_desc
        INNER JOIN parks ON parks.park_id = vehicle_parks.park_id
                            AND parks.park_id = idpark
        INNER JOIN trips ON trips.vehicle_desc = vehicles.vehicle_desc
        INNER JOIN clients ON clients.email = trips.email
                              AND clients.username = username;

    SELECT
        COUNT(*)
    INTO number_bicycles
    FROM
        bicycle
        INNER JOIN vehicles ON vehicles.vehicle_desc = bicycle.vehicle_desc
                               AND vehicles.estado = '1'
        INNER JOIN vehicle_parks ON vehicle_parks.vehicle_desc = vehicles.vehicle_desc
        INNER JOIN parks ON parks.park_id = vehicle_parks.park_id
                            AND parks.park_id = idpark
        INNER JOIN trips ON trips.vehicle_desc = vehicles.vehicle_desc
        INNER JOIN clients ON clients.email = trips.email
                              AND clients.username = username;

    IF number_escooters > 0 THEN
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
                                AND parks.park_id = idpark
            INNER JOIN vehicle_parks ON vehicle_parks.park_id = parks.park_id
            INNER JOIN vehicles ON vehicles.vehicle_desc = vehicle_parks.vehicle_desc
            INNER JOIN trips ON trips.vehicle_desc = vehicles.vehicle_desc
            INNER JOIN clients ON clients.email = trips.email
                                  AND clients.username = username;

        RETURN cont;
    END IF;

    IF number_bicycles > 0 THEN
        SELECT
            max_bicycles - (
                SELECT
                    COUNT(*)
                FROM
                    bicycle
                    INNER JOIN vehicles ON vehicles.vehicle_desc = bicycle.vehicle_desc
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
                                AND parks.park_id = idpark
            INNER JOIN vehicle_parks ON vehicle_parks.park_id = parks.park_id
            INNER JOIN vehicles ON vehicles.vehicle_desc = vehicle_parks.vehicle_desc
            INNER JOIN trips ON trips.vehicle_desc = vehicles.vehicle_desc
            INNER JOIN clients ON clients.email = trips.email
                                  AND clients.username = username;

        RETURN cont;
    END IF;

END funcgetfreeplacesvehiclesinpark;