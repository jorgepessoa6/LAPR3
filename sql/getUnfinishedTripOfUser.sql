create or replace FUNCTION getUnfinishedTripOfUser ( 
        p_email trips.email%TYPE)
        
        return SYS_REFCURSOR
AS
    my_cursor SYS_REFCURSOR;
BEGIN
    OPEN my_cursor FOR SELECT * FROM Trips WHERE end_date is null AND email = p_email;
    RETURN MY_CURSOR;
END;