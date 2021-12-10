CREATE OR REPLACE FUNCTION getBicyclePark ( 
        p_desc BICYCLE.VEHICLE_DESC%TYPE)
        
        return SYS_REFCURSOR
AS
    my_cursor SYS_REFCURSOR;
BEGIN
    OPEN my_cursor FOR SELECT * FROM VEHICLE_PARKS WHERE p_desc = VEHICLE_DESC;
    RETURN MY_CURSOR;
END;