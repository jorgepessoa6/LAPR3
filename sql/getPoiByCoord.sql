CREATE OR REPLACE FUNCTION getPoiByCoord( 
        p_latitude pois.latitude%TYPE,
        p_longitude pois.longitude%TYPE)
        
        return SYS_REFCURSOR
AS
    my_cursor SYS_REFCURSOR;
BEGIN
    OPEN my_cursor FOR SELECT * FROM pois WHERE latitude = p_latitude AND longitude = p_longitude;
    RETURN MY_CURSOR;
END;