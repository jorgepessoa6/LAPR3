CREATE OR REPLACE FUNCTION getAllPaths
        return SYS_REFCURSOR
AS
    my_cursor SYS_REFCURSOR;
BEGIN
    OPEN my_cursor FOR SELECT * FROM paths;
    RETURN MY_CURSOR;
END;