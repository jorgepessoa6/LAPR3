create or replace FUNCTION FUNCGETINVOICEBYTRIPID(idTrip Trips.cod_trip%TYPE) RETURN INTEGER IS 
    
    codigoInvoice Invoices.cod_invoice%TYPE;
    numTrip NUMBER;
    trip_inexistente EXCEPTION;

BEGIN
    
    -- Verifica se a viagem existe na base de dados
    SELECT
        COUNT(cod_trip) INTO numTrip
    FROM
        Trips
    WHERE
        cod_trip = idTrip;
        
        
     IF numTrip <= 0 THEN RAISE trip_inexistente; END IF;
     
     -- Busca por o código da fatura da viagem passada por parâmetro
     SELECT 
        cod_invoice INTO codigoInvoice
     FROM
        Invoices
     WHERE
        cod_trip = idTrip;
        
     RETURN (codigoInvoice);   
        
     EXCEPTION WHEN trip_inexistente THEN return null;  
  
END FUNCGETINVOICEBYTRIPID;