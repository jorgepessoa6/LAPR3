CREATE OR REPLACE PROCEDURE procaddpoi (
    latitude    pois.latitude%TYPE,
    longitude   pois.longitude%TYPE,
    elevation   pois.elevation%TYPE,
    descricao   pois.poi_description%TYPE
) AS
BEGIN
    INSERT INTO pois (
        latitude,
        longitude,
        elevation,
        poi_description
    ) VALUES (
        latitude,
        longitude,
        elevation,
        descricao
    );

    COMMIT;
END;