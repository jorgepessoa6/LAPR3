/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Date;
import lapr.project.data.InvoiceAPI;
import lapr.project.data.TripAPI;

/**
 *
 * @author Francisco Ferreira
 */
public class CalculateTripCost {
    
    
   
    /**
     * Default constructor
     */
    public CalculateTripCost(){
        
    }
    
    
    /**
     * Calcula e atribui o custo de uma viagem realizada pelo cliente
     * @param idVehicle código do veículo utilizado na viagem
     */
    public void calculateTripCostToClient(String idVehicle){
        TripAPI tApi = new TripAPI();
        Integer codTrip = tApi.getTripByDescVehicle(idVehicle);
        
        Date sDate = tApi.getStartDate(codTrip);
        Date eDate = tApi.getEndDate(codTrip);
        
       double costToPay = calculateCost(sDate,eDate);
       
       InvoiceAPI iApi = new InvoiceAPI();
       Integer cod_invoice = iApi.getInvoiceByTripId(codTrip);
       iApi.setInvoiceCost(cod_invoice, costToPay);
       
    }
    
    /**
     * Calcula o custo da viagem
     *
     * @param sDate data de ínicio da viagem
     * @param eDate data de fim da viagem
     * @return custo da viagem
     */
    public double calculateCost(Date sDate, Date eDate) {

        double cost = 0;
        double cost_hour = 1.5;

        String str_s = new SimpleDateFormat("HH:mm:ss").format(sDate);
        String str_e = new SimpleDateFormat("HH:mm:ss").format(eDate);

        LocalTime t1 = LocalTime.parse(str_s);
        LocalTime t2 = LocalTime.parse(str_e);
        Duration diff = Duration.between(t2, t1);
        double diffHours = diff.toHours();

        if (diffHours < 0) {
            diffHours = diffHours * -1;
        }

        cost = cost + (diffHours * cost_hour);

        return cost;
    }
    

}
