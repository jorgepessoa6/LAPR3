--The application should allow users to request a vehicle unlock at a given park. At any time,
--only one vehicle may be unlocked by a user. Besides, when requesting electric scooters and no
--destination is provided, the system should recommend scooters that have the highest battery
--charge level.
--The application should be able to calculate the amount of electrical energy required to travel
--from one park to another when using scooters. When a destination park is given, this operation
--should be used to recommend a scooter with enough range plus 10%, to get

create or replace FUNCTION funcrequesttrip (
    pEmail      clients.email%TYPE,
    pVehicle    INTEGER,
    pType       escooter.scooter_type%TYPE,
    pIdpark     parks.park_id%TYPE,
    pDest       FLOAT
) RETURN vehicles.cod_vehicle%TYPE
AS
    dCod        vehicles.cod_vehicle%TYPE;
    dType       escooter.scooter_type%TYPE;
    dummy       INTEGER;
    dados_invalidos EXCEPTION;
BEGIN

    --Check dados validos
    IF(pEmail IS NULL OR pVehicle IS NULL OR pType IS NULL OR pIdpark IS NULL) THEN
        RAISE dados_invalidos;
    END IF;

    --Check no vehicle already rented
    SELECT
        COUNT(*)
    INTO dummy
    FROM
        trips t
    WHERE
        t.email = pEmail
        AND END_DATE = NULL;


    --Bicycle
    IF ( pvehicle = 0 ) THEN
        SELECT
            v.cod_vehicle
        INTO dCod
        FROM
            vehicles v
            INNER JOIN vehicle_parks    vp ON vp.vehicle_desc = v.vehicle_desc AND vp.park_id = pIdpark
            INNER JOIN bicycle          bt ON bt.vehicle_desc = v.vehicle_desc AND bt.wheel_size = pType 
        FETCH FIRST 1 ROW ONLY;

        RETURN(dCod);
    END IF;


    --Scooter
    IF ( pvehicle = 1 ) THEN
        SELECT
            v.cod_vehicle
        INTO dCod
        FROM
            vehicles v
            INNER JOIN vehicle_parks    vp ON vp.vehicle_desc = v.vehicle_desc AND vp.park_id = pIdpark 
            INNER JOIN escooter         et ON et.vehicle_desc = v.vehicle_desc AND et.scooter_type = pType 
        WHERE
        (
                pDest = 0 
                OR  CASE
                        WHEN et.scooter_type LIKE 'city' THEN 20*((et.battery_max*ev.battery_actual)/ 250) + 0.1*20*((et.battery_max*et.battery_actual)/ 250)
                        ELSE 20*((et.battery_max*et.battery_actual)/ 600) + 0.1*20*((et.battery_max*ev.battery_actual)/ 600)
                    END >= pDest
            )
        ORDER BY
            CASE
                WHEN pDest = 0 THEN et.battery_max*et.battery_actual END DESC,
            CASE
                WHEN pDest != 0 THEN et.battery_max*et.battery_actual END ASC
        FETCH FIRST 1 ROW ONLY;

        RETURN(dCod);
    END IF;


    EXCEPTION 
        WHEN dados_invalidos THEN
            raise_application_error(-20000, 'Dados Inválidos');
        WHEN no_data_found THEN
            raise_application_error(-20000, 'Nenhum veiculo encontrado');
END funcrequesttrip;