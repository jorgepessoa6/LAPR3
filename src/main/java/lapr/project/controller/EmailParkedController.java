/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import lapr.project.data.EmailParkedAPI;

/**
 *
 * @author rickropes
 */
public class EmailParkedController {

    public String emailStatusBody(int request, boolean correct, Date time) {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(time);

        Calendar actualc = GregorianCalendar.getInstance();

        int difHours = Math.abs(calendar.get(Calendar.HOUR_OF_DAY)-actualc.get(Calendar.HOUR_OF_DAY));
        int difMinutes = Math.abs(calendar.get(Calendar.MINUTE)-actualc.get(Calendar.MINUTE));
        
        String message = "The vehicle was parked correctly";
        if (!correct) message = "THE VEHICLE WASN'T PARKED CORRECTLY";
        message += "\nThe vehicle was used for " + difHours + ":" + difMinutes;

        return message;
        
    }
}
