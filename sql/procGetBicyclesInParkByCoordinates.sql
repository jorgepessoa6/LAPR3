CREATE OR REPLACE PROCEDURE procgetbicyclesinparkbycoordinates (
    latitude    parks.latitude%TYPE,
    longitude   parks.longitude%TYPE,
    retorno     OUT SYS_REFCURSOR
) AS
BEGIN
    OPEN retorno FOR SELECT
                         bicycle.vehicle_desc
                     FROM
                         bicycle
                         INNER JOIN vehicles ON vehicles.vehicle_desc = bicycle.vehicle_desc
                                                AND vehicles.estado = '1'
                         INNER JOIN vehicle_parks ON vehicle_parks.vehicle_desc = vehicles.vehicle_desc
                         INNER JOIN parks ON parks.park_id = vehicle_parks.park_id
                                             AND parks.latitude = latitude
                                             AND parks.longitude = longitude;

END;