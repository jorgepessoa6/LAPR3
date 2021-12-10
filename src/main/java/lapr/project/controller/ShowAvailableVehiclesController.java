/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.data.ParkAPI;
import lapr.project.data.VehicleAPI;
import lapr.project.model.Park;

/**
 *
 * @author Blanco
 */
public class ShowAvailableVehiclesController {

    public ShowAvailableVehiclesController(){
        //EmptyConstructor
    }
    
    public List<Integer> showAvailableVehicles(String parkId){
        ParkAPI p = new ParkAPI();
        VehicleAPI v = new VehicleAPI();
        
        Park park = p.getParkById(parkId);
        
        double lat = park.getLatitude();
        double log = park.getLongitude();
        
        return v.getAvailableVehicles(lat, log);

    }
    
}
