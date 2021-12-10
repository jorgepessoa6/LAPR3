CREATE OR REPLACE PROCEDURE PROCADDFIFTEENPOINTS (userEmail Clients.email%Type) AS 

    initialPoints Clients.points%TYPE;
    numClient NUMBER;
    client_inexistente EXCEPTION;

BEGIN
  
  
  -- Verifica se o cliente passado por parâmetro existe na base de dados
    SELECT 
        COUNT(email) INTO numClient
    FROM
        Clients
    WHERE
        upper(email) = upper(userEmail);
    
    
    IF numClient <= 0 THEN RAISE client_inexistente; END IF;
    
    
    -- Busca pelos pontos já presentes no atributo dos pontos do cliente passado por parâmetro
    SELECT   
        points INTO initialPoints 
    FROM
        Clients
    WHERE 
        upper(email) LIKE upper(userEmail);
        
    UPDATE Clients SET points = initialPoints + 15;
    
    EXCEPTION WHEN client_inexistente THEN dbms_output.put_line('Cliente inserido inexistente');
        
END PROCADDFIFTEENPOINTS;