CREATE OR REPLACE FUNCTION FUNCGETPARKIDSTART(trip_cod Trips.cod_trip%TYPE) RETURN VARCHAR2 AS 
    
    idStart Trips.start_date%TYPE;
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
        park_id_start INTO idStart
    FROM
        Trips
    WHERE
        cod_trip = trip_cod;
        
    RETURN (idStart);
  
    EXCEPTION WHEN trip_inexistente THEN return null;
END FUNCGETPARKIDSTART;