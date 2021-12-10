CREATE OR REPLACE FUNCTION GETENDDATE (trip_cod Trips.cod_trip%TYPE) RETURN DATE IS 
    
    endDate Trips.end_date%TYPE;
    numTrip NUMBER;
    trip_inexistente EXCEPTION;

BEGIN
    -- Verifica se a viagem existe na base de dados
    SELECT
        COUNT(cod_trip) INTO numTrip
    FROM
        Trips
    WHERE
        cod_trip = trip_cod;
        
    
    IF numtrip <= 0 THEN RAISE trip_inexistente; END IF;
    
    -- Busca por a data de fim da viagem
    
    SELECT 
        end_date INTO endDate
    FROM
        Trips
    WHERE
        cod_trip = trip_cod;
        
    RETURN (endDate);
  
    EXCEPTION WHEN trip_inexistente THEN return null;
    
END GETENDDATE;