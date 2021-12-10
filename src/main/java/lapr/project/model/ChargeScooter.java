/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import lapr.project.data.ParkAPI;
import lapr.project.data.VehicleAPI;

/**
 *
 * @author Diogo Soares
 */
public class ChargeScooter {


    public ChargeScooter() {
    }
    
    
    
    public int chargeScooter(int tempo, int battery, int batteryMax,int numberScooters){
       
        
        if( battery<batteryMax && battery>=0 && batteryMax>=0 && tempo>0 && numberScooters>0){ 
            int carga=(3520/numberScooters);
        
        if (carga>3000) carga=3000;
            battery=((battery/100)*batteryMax)+(carga*tempo);
            if(battery<=batteryMax){
                return (int)((((double)battery/batteryMax))*100);
            }else{
                return 100;
            }
        
        }
    
    return -1;}
    
}
