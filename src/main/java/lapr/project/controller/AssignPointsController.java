/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Date;
import lapr.project.data.ParkAPI;
import lapr.project.data.TripAPI;
import lapr.project.data.UserAPI;

/**
 *
 * @author Francisco Ferreira
 */
public class AssignPointsController {
    
    /**
     * Default constructor
     */
    public AssignPointsController(){
        
    }
    
    
    /**
     * Calcula a diferença de elevações entre dois parques
     * @param elOne elevação do parque um
     * @param elTwo elevação do parque dois
     * @return a diferença de elevações entre dois parques
     */
    public Integer calculateElevationDifference (Integer elOne, Integer elTwo){
        
        // Garante que a a elOne é a menor elevação
        if (elOne > elTwo) {
            Integer temp = elOne;
            elOne = elTwo;
            elTwo = temp;
        }
        
        return (elTwo - elOne);
    }
    
    /**
     * Calcula o tempo de viagem, em minutos 
     * @param sDate data de ínicio da viagem
     * @param eDate data de fim da viagem
     * @return tempo de viagem, em minutos
     */
    public double calculateTripTime(Date sDate, Date eDate) {
        
        String str_s = new SimpleDateFormat("HH:mm:ss").format(sDate);
        String str_e = new SimpleDateFormat("HH:mm:ss").format(eDate);
        
        LocalTime t1 = LocalTime.parse(str_s);
        LocalTime t2 = LocalTime.parse(str_e);
        Duration diff = Duration.between(t2, t1);
        double diffMin = diff.toMinutes();
        
        if (diffMin < 0){
            return diffMin * -1;
        }
        
        return diffMin;
    }
    
    
    
    
}
