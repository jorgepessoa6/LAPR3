CREATE OR REPLACE FUNCTION getParkByCoord( 
        p_latitude parks.latitude%TYPE,
        p_longitude parks.longitude%TYPE)
        
        return SYS_REFCURSOR
AS
    my_cursor SYS_REFCURSOR;
BEGIN
    OPEN my_cursor FOR SELECT * FROM parks WHERE latitude = p_latitude AND longitude = p_longitude;
    RETURN MY_CURSOR;
END;