CREATE OR REPLACE FUNCTION getAllScooters
        return SYS_REFCURSOR
AS
    my_cursor SYS_REFCURSOR;
BEGIN
    OPEN my_cursor FOR SELECT vehicle_desc FROM escooters;
    RETURN MY_CURSOR;
END;