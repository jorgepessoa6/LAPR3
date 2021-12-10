create or replace PROCEDURE procAddBicycle(
        p_estado vehicles.ESTADO%TYPE,
        p_park_id vehicle_parks.park_id%TYPE,
        p_vehicle_desc bicycle.vehicle_desc%TYPE,
        p_weight bicycle.weight%TYPE,
        p_wheel_size bicycle.wheel_size%TYPE,
        p_aerodynamic_cf bicycle.aerodynamic_cf%TYPE,
        p_frontal_area bicycle.frontal_area%TYPE)
        
AS
BEGIN

    INSERT INTO vehicles(vehicle_desc, estado)
    VALUES(p_vehicle_desc,p_estado);
    
    INSERT INTO bicycle(vehicle_desc,weight,aerodynamic_cf,frontal_area,wheel_size)
    VALUES(p_vehicle_desc,p_weight,p_aerodynamic_cf,p_frontal_area,p_wheel_size);

    INSERT INTO vehicle_parks(vehicle_desc, park_id)
    VALUES(p_vehicle_desc,p_park_id);

    commit;
END;