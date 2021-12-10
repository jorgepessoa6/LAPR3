create or replace FUNCTION GETPARKELEVATION(idPark Parks.park_id%TYPE) RETURN INTEGER IS 
    
    elevationPark Parks_Info.elevation%TYPE;
    numPark NUMBER;
    parque_inexistente EXCEPTION;
    
BEGIN
    -- Verifica se o parque existe na base de dados
    SELECT
        COUNT (park_id) INTO numPark
    FROM
        Parks
    WHERE
        park_id = idPark;
        
    IF numPark <= 0 THEN RAISE parque_inexistente; END IF;
    
    -- Busca pela elevação do parque passado por parâmetro
    SELECT  
        pi.elevation INTO elevationPark
    FROM
        Parks_Info pi INNER JOIN Parks p ON pi.latitude = p.latitude AND pi.longitude = p.longitude
    WHERE
        p.park_id = idPark;
    
    RETURN (elevationPark);

    EXCEPTION WHEN parque_inexistente THEN return null;
      
END GETPARKELEVATION;