create or replace FUNCTION FUNCGETESCOOTERSTYPE(id_vehicle Vehicles.vehicle_desc%TYPE) RETURN VARCHAR 
IS 
    escooter_type Escooter.scooter_type%TYPE ;
    numVehicle NUMBER;
    veiculo_inexistente EXCEPTION;    

BEGIN
    --Verifica se o veículo (escooter) existe na base de dados
    SELECT 
        COUNT(vehicle_desc) INTO numVehicle
    FROM
        Vehicles
    WHERE 
        vehicle_desc = id_vehicle;
        
    IF numVehicle = 0 THEN RAISE veiculo_inexistente; END IF; 
    
    -- Busca pelo tipo de escooter do veículo passado por parâmetro
    SELECT
        e.scooter_type INTO escooter_type
    FROM
       Escooter e INNER JOIN  Vehicles v ON e.vehicle_desc = v.vehicle_desc
    WHERE
        v.vehicle_desc = id_vehicle;
        
    RETURN (escooter_type);
    
    EXCEPTION WHEN veiculo_inexistente THEN return null;
 
END FUNCGETESCOOTERSTYPE;