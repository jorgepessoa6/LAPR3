/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.ChargeScooter;

/**
 *
 * @author Diogo Soares
 */
public class ChargeScooterController {
    
    private ChargeScooter chargeScooter;

    public ChargeScooterController() {
        this.chargeScooter = new ChargeScooter();
    }
    
    
    public int chargeScooter(int tempo, int battery, int batteryMax,int numberScooters){
        return chargeScooter.chargeScooter( tempo, battery, batteryMax, numberScooters);
    }
   
}