CREATE OR REPLACE FUNCTION getAllPois
        return SYS_REFCURSOR
AS
    my_cursor SYS_REFCURSOR;
BEGIN
    OPEN my_cursor FOR SELECT * FROM pois;
    RETURN MY_CURSOR;
END;