/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

/**
 *
 * @author Diogo Soares
 */
public class ReportVehiclesNonBatteryToTravel {

    public ReportVehiclesNonBatteryToTravel() {
    }
    

    public boolean ReportVehiclesNonBatteryToTravel(Scooter s,int km) {
        double bateria= (s.getActualBattery()/(100))*s.getMaxBattery();
        double autonomia=(25*(bateria/s.getMotor()))*0.7;
        if(autonomia<km) return true;
        else return false;
    }
    
    public boolean ReportVehiclesBatteryToTravel(Scooter s,int km) {
        double bateria= (s.getActualBattery()/(100))*s.getMaxBattery();
        double autonomia=(25*(bateria/s.getMotor()))*0.7;
        if(autonomia>(1.1*km)) return true;
        else return false;
    }
    
   
    
    
}
