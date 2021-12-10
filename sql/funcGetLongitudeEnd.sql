create or replace FUNCTION FUNCGETLONGITUDEEND(id_trip Trips.cod_trip%TYPE) RETURN FLOAT IS 

    longitudeEnd Trips.longitude_end%TYPE;
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
     
     -- Busca por a longitude do parque final da viagem passada por parâmetro
     SELECT 
        longitude_end INTO longitudeEnd
     FROM
        Trips
     WHERE
        cod_trip = id_trip;
        
     RETURN (longitudeEnd);   
        
     EXCEPTION WHEN trip_inexistente THEN return null;   
        
  
END FUNCGETLONGITUDEEND;