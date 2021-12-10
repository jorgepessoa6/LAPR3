CREATE OR REPLACE FUNCTION getUserByEmail ( 
        p_email clients.email%TYPE)
        
        return SYS_REFCURSOR
AS
    my_cursor SYS_REFCURSOR;
BEGIN
    OPEN my_cursor FOR SELECT * FROM clients WHERE email = p_email;
    RETURN MY_CURSOR;
END;