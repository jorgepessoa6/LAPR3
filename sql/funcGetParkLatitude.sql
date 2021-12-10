create or replace FUNCTION FUNCGETPARKLATITUDE(idPark Parks.park_id%TYPE) RETURN FLOAT AS 
    
    parkLatitude Parks_Info.latitude%TYPE;
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
        p.latitude INTO parkLatitude
    FROM
        Parks p
    WHERE
        p.park_id = idPark;
    
    RETURN (parkLatitude);
    
    EXCEPTION WHEN parque_inexistente THEN return null;
    
END FUNCGETPARKLATITUDE;