create or replace PROCEDURE procUpdateBatteryScooter (
    scooter_id escooter.vehicle_desc%TYPE,
    battery escooter.battery_actual%TYPE,
    battery_max escooter.battery_max%TYPE
)AS 
BEGIN
    
  
  IF(battery<=battery_max) THEN
     UPDATE escooter SET battery_actual=battery
     WHERE 
     vehicle_desc=scooter_id;
  ELSE
    UPDATE escooter SET battery_actual=battery_max
    WHERE 
    vehicle_desc=scooter_id;
  END IF;
END procUpdateBatteryScooter;