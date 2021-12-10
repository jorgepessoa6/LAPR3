/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.data.VehicleAPI;
import lapr.project.model.ReportVehiclesNonBatteryToTravel;
import lapr.project.model.Scooter;

/**
 *
 * @author Diogo Soares
 */
public class ReportVehiclesNonBatteryToTravelController {
    
    private ReportVehiclesNonBatteryToTravel rvnbtt;
    private VehicleAPI vehicleAPI;

    public ReportVehiclesNonBatteryToTravelController () {
        this.rvnbtt = new ReportVehiclesNonBatteryToTravel();
    }

    public ReportVehiclesNonBatteryToTravelController(VehicleAPI vehicleAPI) {
        this.rvnbtt = new ReportVehiclesNonBatteryToTravel();
        this.vehicleAPI=vehicleAPI;
    }
    
    public List<Scooter> ReportVehiclesNonBatteryToTravel(List<Scooter> list,int km) {
        List<Scooter> nonBattery= new ArrayList<Scooter>();
               for(Scooter s: list){
                   if(rvnbtt.ReportVehiclesNonBatteryToTravel(s, km)){
                       nonBattery.add(s);
                   }
               }
        return nonBattery;
    }
    
    public List<Scooter> ReportVehiclesBatteryToTravel(List<Scooter> list,int km) {
       List<Scooter> scooters=new ArrayList<>();
       for(Scooter s: list){
           if(rvnbtt.ReportVehiclesBatteryToTravel(s, km)){
                       scooters.add(s);
                   }
           
       }
             
    return list;}
    
    
}
