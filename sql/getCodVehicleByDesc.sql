CREATE OR REPLACE FUNCTION getCodVehicleByDesc ( 
        p_desc ESCOOTER.VEHICLE_DESC%TYPE)
        
        return SYS_REFCURSOR
AS
    my_cursor SYS_REFCURSOR;
BEGIN
    OPEN my_cursor FOR SELECT * FROM VEHICLES WHERE p_desc = VEHICLE_DESC;
    RETURN MY_CURSOR;
END;