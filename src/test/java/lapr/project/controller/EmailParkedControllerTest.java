/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author rickropes
 */
public class EmailParkedControllerTest {

    public EmailParkedControllerTest() {
    }

    /**
     * Test of emailStatusBody method, of class EmailParkedController.
     */
    @Test
    public void testEmailStatusBody() {
        System.out.println("emailStatusBody");
        int request = 0;
        boolean correct = false;
        Date time = new Date();
        System.out.println(time);
        EmailParkedController instance = new EmailParkedController();
        assertEquals(instance.emailStatusBody(request, correct, time), "THE VEHICLE WASN'T PARKED CORRECTLY\nThe vehicle was used for 0:0");
        
        Date time2 = new Date(100000000);
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(time2);
        Date actual = new Date();
        Calendar actualc = GregorianCalendar.getInstance();
        actualc.setTime(actual);

        int difHours = Math.abs(calendar.get(Calendar.HOUR_OF_DAY)-actualc.get(Calendar.HOUR_OF_DAY));
        int difMinutes = Math.abs(calendar.get(Calendar.MINUTE)-actualc.get(Calendar.MINUTE));
        
        assertEquals(instance.emailStatusBody(request, correct, time2), "THE VEHICLE WASN'T PARKED CORRECTLY\nThe vehicle was used for "+difHours+":"+difMinutes);

    }

}
