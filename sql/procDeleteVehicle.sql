CREATE OR REPLACE PROCEDURE procdeletevehicle (
    vehicle_desc vehicles.vehicle_desc%TYPE
) AS
BEGIN
    UPDATE vehicles
    SET
        estado = '0'
    WHERE
        vehicles.vehicle_desc = vehicle_desc;

END;