create or replace FUNCTION FUNCGETLATITUDEEND(id_trip Trips.cod_trip%TYPE) RETURN FLOAT IS 

    latitudeEnd Trips.latitude_end%TYPE;
    numTrip NUMBER;
    trip_inexistente EXCEPTION;

BEGIN
    
    -- Verifica se a viagem existe na base de dados
    SELECT
        COUNT(cod_trip) INTO numTrip
    FROM
        Trips
    WHERE
        cod_trip = id_trip;
        
        
     IF numTrip <= 0 THEN RAISE trip_inexistente; END IF;
     
     -- Busca por a latitude do parque final da viagem passada por parâmetro
     SELECT 
        latitude_end INTO latitudeEnd
     FROM
        Trips
     WHERE
        cod_trip = id_trip;
        
     RETURN (latitudeEnd);   
        
     EXCEPTION WHEN trip_inexistente THEN return null;   
        
  
END FUNCGETLATITUDEEND;