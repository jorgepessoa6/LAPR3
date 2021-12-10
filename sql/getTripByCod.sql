create or replace FUNCTION getTripByCod ( 
        p_cod trips.email%TYPE)
        
        return SYS_REFCURSOR
AS
    my_cursor SYS_REFCURSOR;
BEGIN
    OPEN my_cursor FOR SELECT * FROM Trips WHERE  cod_trip = p_cod;
    RETURN MY_CURSOR;
END;