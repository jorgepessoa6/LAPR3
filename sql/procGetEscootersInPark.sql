CREATE OR REPLACE PROCEDURE procgetescootersinpark (
    idpark    parks.park_id%TYPE,
    retorno   OUT SYS_REFCURSOR
) AS
BEGIN
    OPEN retorno FOR SELECT
                         escooter.vehicle_desc
                     FROM
                         escooter
                         INNER JOIN vehicles ON vehicles.vehicle_desc = escooter.vehicle_desc
                                                AND vehicles.estado = '1'
                         INNER JOIN vehicle_parks ON vehicle_parks.vehicle_desc = vehicles.vehicle_desc
                         INNER JOIN parks ON parks.park_id = vehicle_parks.park_id
                                             AND parks.park_id = idpark;

END;