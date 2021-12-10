create or replace PROCEDURE procRemovePath ( 
        p_latitudeA paths.latitude_A%TYPE,
        p_longitudeA paths.longitude_A%TYPE,
        p_latitudeB paths.latitude_B%TYPE,
        p_longitudeB paths.longitude_B%TYPE)
        
AS
BEGIN
    DELETE FROM PATHS WHERE latitude_A = p_latitudeA AND longitude_A = p_longitudeA
    AND latitude_B = p_latitudeB AND longitude_B = p_longitudeB;
    commit;
END procRemovePath;