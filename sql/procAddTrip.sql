create or replace PROCEDURE procAddTrip ( 
        p_email trips.email%TYPE,
        p_vehicle_desc trips.vehicle_desc%TYPE,
        p_park_id_start trips.park_id_start%TYPE)
        
AS
BEGIN
    INSERT INTO Trips(email, vehicle_desc, park_id_start, start_date, latitude_end, longitude_end)
    VALUES(p_email, p_vehicle_desc, p_park_id_start, CURRENT_TIMESTAMP, 0, 0);
    commit;
END;