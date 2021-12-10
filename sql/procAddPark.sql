CREATE OR REPLACE PROCEDURE procAddPark(
        p_park_id parks.park_id%TYPE,
        p_latitude parks.latitude%TYPE,
        p_longitude parks.longitude%TYPE,
        p_elevation parks_info.elevation%TYPE,
        p_description parks_info.park_desc%TYPE,
        p_maxBicycles parks_info.max_bicycles%TYPE,
        p_maxScooters parks_info.max_scooters%TYPE,
        p_voltage parks_info.input_voltage%TYPE,
        p_current parks_info.input_current%TYPE)
        
AS
BEGIN
    INSERT INTO parks_info(latitude,longitude,elevation,park_desc,max_bicycles,max_scooters,input_voltage,input_current)
    VALUES(p_latitude,p_longitude,p_elevation,p_description,p_maxBicycles,p_maxScooters,p_voltage,p_current);
    
    INSERT INTO parks(park_id,latitude,longitude)
    VALUES(p_park_id,p_latitude,p_longitude);
    commit;
END;