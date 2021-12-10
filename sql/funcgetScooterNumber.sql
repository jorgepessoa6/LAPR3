create or replace FUNCTION funcgetScooterNumber(
    cod vehicle_parks.vehicle_desc%TYPE
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
        vehicles
    WHERE 
        vehicle_desc = cod;
        
    IF numVehicle = 0 THEN RAISE veiculo_inexistente; END IF; 
    
    SELECT
       p.max_scooters 
    INTO dummy
    FROM
        parks_info p
        INNER JOIN parks pa ON pa.latitude=p.latitude AND pa.longitude=p.longitude
        INNER JOIN vehicle_parks vp ON vp.vehicle_desc=cod; 
        
    RETURN (dummy);
    
    EXCEPTION WHEN veiculo_inexistente THEN return -1;

END funcgetScooterNumber;