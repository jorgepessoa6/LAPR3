create or replace PROCEDURE PROCGETTRIPSBYUSER (uName Clients.username%TYPE, RETORNO OUT SYS_REFCURSOR)  AS 
BEGIN

    OPEN RETORNO FOR
    SELECT t.cod_trip 
    FROM Trips t, Clients c
    WHERE c.email = t.email AND c.username = uName;
    
END PROCGETTRIPSBYUSER;