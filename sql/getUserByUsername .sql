CREATE OR REPLACE FUNCTION getUserByUsername ( 
        p_username clients.username%TYPE)
        
        return SYS_REFCURSOR
AS
    my_cursor SYS_REFCURSOR;
BEGIN
    OPEN my_cursor FOR SELECT * FROM clients WHERE username = p_username;
    RETURN MY_CURSOR;
END;