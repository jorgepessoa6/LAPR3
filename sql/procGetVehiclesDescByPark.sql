create or replace PROCEDURE PROCGETVEHICLESDESCBYPARK (id_park parks.park_id%TYPE, RETORNO OUT SYS_REFCURSOR)  AS 
BEGIN

    OPEN RETORNO FOR
    SELECT ev.vehicle_desc 
    FROM Vehicles v, Escooter_Vehicles ev, Vehicle_Parks vp, Parks p
    WHERE ev.cod_vehicle = v.cod_vehicle AND v.cod_vehicle = vp.cod_vehicle AND vp.park_id = p.park_id AND p.park_id = id_park;
    
END PROCGETVEHICLESDESCBYPARK;