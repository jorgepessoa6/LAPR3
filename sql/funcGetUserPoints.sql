create or replace FUNCTION FUNCGETUSERPOINTS(userEmail Clients.email%TYPE) RETURN INTEGER AS 
    
    userPoints Clients.points%TYPE;
    numUser NUMBER;
    user_inexistente EXCEPTION;

BEGIN
    -- Verifica se o utilizador existe na base de dados
    SELECT
        COUNT(email) INTO numUser
    FROM
        Clients
    WHERE
        email = userEmail;
        
    
    IF numUser <= 0 THEN RAISE user_inexistente; END IF;
    
    -- Busca por os pontos do user passado acima, por parâmetro
    
    SELECT 
        points INTO userPoints
    FROM
        Clients
    WHERE
        email = userEmail;
        
    RETURN (userPoints);
  
    EXCEPTION WHEN user_inexistente THEN return null;
END FUNCGETUSERPOINTS;