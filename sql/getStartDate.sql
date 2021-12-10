CREATE OR REPLACE FUNCTION GETSTARTDATE(trip_cod Trips.cod_trip%TYPE) RETURN DATE IS 
    
    startDate Trips.start_date%TYPE;
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
    
    -- Busca por a data de início da viagem
    
    SELECT 
        start_date INTO startDate
    FROM
        Trips
    WHERE
        cod_trip = trip_cod;
        
    RETURN (startDate);
  
    EXCEPTION WHEN trip_inexistente THEN return null;
    
END GETSTARTDATE;