create or replace FUNCTION FUNCGETACTUALBATTERY(id_vehicle Vehicles.vehicle_desc%TYPE) RETURN FLOAT 
IS 
    escooter_batery FLOAT;
    numVehicle NUMBER;
    veiculo_inexistente EXCEPTION;    

BEGIN
    --Verifica se o veículo existe na base de dados
    SELECT 
        COUNT(vehicle_desc) INTO numVehicle
    FROM
        Vehicles
    WHERE 
        vehicle_desc = id_vehicle;
        
    IF numVehicle = 0 THEN RAISE veiculo_inexistente; END IF; 
    
    -- Busca pela bateria atual do veículo passado por parâmetro
    SELECT
        e.battery_actual INTO escooter_batery
    FROM
       Escooter e INNER JOIN  Vehicles v ON e.vehicle_desc = v.vehicle_desc
    WHERE
        v.vehicle_desc = id_vehicle;
        
    RETURN (escooter_batery);
    
    EXCEPTION WHEN veiculo_inexistente THEN return null;
 
END FUNCGETACTUALBATTERY;