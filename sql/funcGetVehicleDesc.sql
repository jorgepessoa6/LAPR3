create or replace FUNCTION FUNCGETVEHICLEDESC(trip_cod Trips.cod_trip%TYPE) RETURN VARCHAR2 AS 
    
    vehicleDesc Trips.vehicle_desc%TYPE;
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
        vehicle_desc INTO vehicleDesc
    FROM
        Trips
    WHERE
        cod_trip = trip_cod;

    RETURN (vehicleDesc);

    EXCEPTION WHEN trip_inexistente THEN return null;
END FUNCGETVEHICLEDESC;