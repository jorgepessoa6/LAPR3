create or replace PROCEDURE procUpdateVehicle (
    vehicle_id vehicles.vehicle_desc%TYPE,
    new_estado vehicles.estado%TYPE,
    new_park_id vehicle_parks.park_id%TYPE
    )AS 
BEGIN  

  UPDATE vehicles SET estado=new_estado
  WHERE 
    vehicle_desc=vehicle_id;

  UPDATE vehicle_parks SET park_id=new_park_id
  WHERE 
    vehicle_desc=vehicle_id;

END procUpdateVehicle;