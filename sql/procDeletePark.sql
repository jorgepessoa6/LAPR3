CREATE OR REPLACE PROCEDURE procdeletepark (
    idpark parks.park_id%TYPE
) AS

    lat   parks.latitude%TYPE;
    lon   parks.longitude%TYPE;
    cod   invoices.cod_trip%TYPE;
BEGIN
    SELECT
        latitude
    INTO lat
    FROM
        parks
    WHERE
        parks.park_id = idpark;

    SELECT
        longitude
    INTO lon
    FROM
        parks
    WHERE
        parks.park_id = idpark;

    SELECT
        cod_trip
    INTO cod
    FROM
        trips
    WHERE
        trips.park_id_start = idpark;

    DELETE FROM trip_paths
    WHERE
        trip_paths.cod_trip = cod;

    DELETE FROM invoices
    WHERE
        invoices.cod_trip = cod;

    DELETE FROM trips
    WHERE
        trips.park_id_start = idpark;

    DELETE FROM vehicle_parks
    WHERE
        vehicle_parks.park_id = idpark;

    DELETE FROM parks
    WHERE
        parks.park_id = idpark;

    DELETE FROM parks_info
    WHERE
        parks_info.latitude = lat
        AND parks_info.longitude = lon;

END;