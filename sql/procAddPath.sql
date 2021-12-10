create or replace PROCEDURE procAddPath ( 
        p_latitudeA paths.latitude_A%TYPE,
        p_longitudeA paths.longitude_A%TYPE,
        p_latitudeB paths.latitude_B%TYPE,
        p_longitudeB paths.longitude_B%TYPE,
        p_kinetic_cf paths.kinetic_cf%TYPE,
        p_wind_spd paths.wind_spd%TYPE,
        p_wind_dir paths.wind_dir%TYPE)
        
AS
BEGIN
    INSERT INTO paths(latitude_A,longitude_A,latitude_B,longitude_B,kinetic_cf,wind_spd,wind_dir)
    VALUES(p_latitudeA,p_longitudeA,p_latitudeB,p_longitudeB,p_kinetic_cf,p_wind_spd,p_wind_dir);
    commit;
END;