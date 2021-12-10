create or replace PROCEDURE PROCGETDESCVEHICLESBYPARK (id_park parks.park_id%TYPE, RETORNO OUT SYS_REFCURSOR)  AS 
BEGIN

    OPEN RETORNO FOR
    SELECT v.vehicle_desc 
    FROM Vehicles v, Vehicle_Parks vp, Parks p
    WHERE v.vehicle_desc = vp.vehicle_desc AND vp.park_id = p.park_id AND p.park_id = id_park;
    
END PROCGETDESCVEHICLESBYPARK;