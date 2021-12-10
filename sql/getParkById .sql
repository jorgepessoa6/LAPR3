CREATE OR REPLACE FUNCTION getParkById ( 
        p_park_id parks.park_id%TYPE)
        
        return SYS_REFCURSOR
AS
    my_cursor SYS_REFCURSOR;
BEGIN
    OPEN my_cursor FOR SELECT * FROM parks WHERE park_id = p_park_id;
    RETURN MY_CURSOR;
END;