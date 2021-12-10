create or replace PROCEDURE PROCADDUSER (
    u_email Clients.email%TYPE,
    u_visa Clients.visa%TYPE,
    u_username Clients.username%TYPE,
    u_height Clients.height%TYPE,
    u_weight Clients.weight%TYPE,
    u_avg_speed Clients.avg_cycling_spd%TYPE,
    u_gender Clients.gender%TYPE,
    u_pass Clients.pass%TYPE)
    
AS 
BEGIN

 INSERT INTO Clients (email,pass,visa,username,height,weight,gender,avg_cycling_spd) 
 VALUES (u_email,u_pass,u_visa,u_username,u_height,u_weight,u_gender,u_avg_speed);
 
END PROCADDUSER;