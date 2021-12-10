create or replace FUNCTION FUNCGETPARKIDEND(latitudeEnd Trips.latitude_end%TYPE, longitudeEnd Trips.longitude_end%TYPE) RETURN VARCHAR2 AS 
    
    idEnd Trips.park_id_start%TYPE;
    numTrip NUMBER;
    trip_inexistente EXCEPTION;

BEGIN
    -- Verifica se a viagem existe na base de dados
    SELECT
        COUNT(cod_trip) INTO numTrip
    FROM
        Trips
    WHERE
        latitude_end = latitudeEnd AND longitude_end = longitudeEnd; 
        
    
    IF numtrip <= 0 THEN RAISE trip_inexistente; END IF;
    
    -- Busca por a data de início da viagem
    
    SELECT 
        park_id INTO idEnd
    FROM
        Parks
    WHERE
        latitude = latitudeEnd AND longitude = longitudeEnd;
        
    RETURN (idEnd);
  
    EXCEPTION WHEN trip_inexistente THEN return null;
END FUNCGETPARKIDEND;