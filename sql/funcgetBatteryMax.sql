create or replace FUNCTION funcgetBatteryMax (
    cod escooter.vehicle_desc%TYPE
)RETURN INTEGER
AS
    dummy INTEGER;
    numVehicle INTEGER;
    veiculo_inexistente EXCEPTION;
BEGIN
    
    --Verifica se o veículo existe na base de dados
    SELECT 
        COUNT(vehicle_desc) INTO numVehicle
    FROM
        Vehicles
    WHERE 
        vehicle_desc = cod;
        
    IF numVehicle = 0 THEN RAISE veiculo_inexistente; END IF; 
    
    SELECT
        e.battery_max
    INTO dummy
    FROM
        escooter e 
        WHERE e.vehicle_desc=cod;
    
    RETURN (dummy);
    
    EXCEPTION WHEN veiculo_inexistente THEN return null;

END funcgetBatteryMax;