CREATE OR REPLACE PROCEDURE procremovepoi( 
        p_latitude pois.latitude%TYPE,
        p_longitude pois.longitude%TYPE)
AS
BEGIN
    DELETE FROM POIS WHERE latitude = p_latitude AND longitude = p_longitude;
END;