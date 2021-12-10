create or replace PROCEDURE procAddScooter(
        p_estado vehicles.ESTADO%TYPE,
        p_park_id vehicle_parks.park_id%TYPE,
        p_vehicle_desc escooter.vehicle_desc%TYPE,
        p_weight escooter.weight%TYPE,
        p_scooter_type escooter.scooter_type%TYPE,
        p_aerodynamic_cf escooter.aerodynamic_cf%TYPE,
        p_frontal_area escooter.frontal_area%TYPE,
        p_battery_max escooter.battery_max%TYPE,
        p_battery_actual escooter.battery_actual%TYPE,
        p_motor         escooter.motor%TYPE)
        
AS
BEGIN

    INSERT INTO vehicles(vehicle_desc,estado)
    VALUES(p_vehicle_desc,p_estado);
    
    INSERT INTO escooter(vehicle_desc,weight,scooter_type,aerodynamic_cf,frontal_area,battery_max,battery_actual,motor)
    VALUES(p_vehicle_desc,p_weight,p_scooter_type,p_aerodynamic_cf,p_frontal_area,p_battery_max,p_battery_actual,p_motor );

    INSERT INTO vehicle_parks(vehicle_desc, park_id)
    VALUES(p_vehicle_desc,p_park_id);
    commit;
END;