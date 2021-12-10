CREATE OR REPLACE FUNCTION getParkInfoByCoord( 
        p_latitude parks_info.latitude%TYPE,
        p_longitude parks_info.longitude%TYPE)
        
        return SYS_REFCURSOR
AS
    my_cursor SYS_REFCURSOR;
BEGIN
    OPEN my_cursor FOR SELECT * FROM parks_info WHERE latitude = p_latitude AND longitude = p_longitude;
    RETURN MY_CURSOR;
END;