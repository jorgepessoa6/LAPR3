create or replace FUNCTION funcgetParkAtPos (
    pCod trip.cod_request%TYPE
)RETURN INTEGER
AS
    dummy INTEGER;
BEGIN
    SELECT
        COUNT(*)
    INTO dummy
    FROM
        parks p 
        INNER JOIN trips t ON t.cod_request = pCod AND p.latitude = t.latitude_end AND p.longitude = t.longitude_end;
    RETURN dummy;

END funcgetParkAtPos;
