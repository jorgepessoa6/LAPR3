create or replace PROCEDURE PROCUPDATEPARK (
    new_elevation Parks_info.elevation%TYPE,
    new_park_desc Parks_info.park_desc%TYPE,
    new_max_bicycles Parks_info.max_bicycles%TYPE,
    new_max_scooters Parks_info.max_scooters%TYPE,
    new_input_voltage Parks_info.input_voltage%TYPE,
    new_input_current Parks_info.input_current%TYPE,
    new_latitude Parks_info.latitude%TYPE,
    new_longitude Parks_info.longitude%TYPE
)AS 
BEGIN
  UPDATE Parks_Info SET elevation = new_elevation, 
  park_desc = new_park_desc, 
  max_bicycles = new_max_bicycles,
  max_scooters = new_max_scooters, 
  input_voltage = new_input_voltage, 
  input_current = new_input_current 
  WHERE 
    latitude = new_latitude AND longitude = new_longitude;
  
END PROCUPDATEPARK;