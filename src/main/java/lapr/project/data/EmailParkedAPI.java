package lapr.project.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lapr.project.controller.EmailParkedController;
import lapr.project.model.Trip;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;

public class EmailParkedAPI {

    String sender = "lapr3grupo4@gmail.com";
    String password = "lapr32000";

    public boolean sendEmailStatus(int request, boolean correct) {
        TripAPI tapi = new TripAPI();
        EmailParkedController epc = new EmailParkedController();

        Trip trip = tapi.getTripByCod(request);

        String email = trip.getEmail();
        try {
            String d1 = trip.getTimestampStart();
            Date d = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(d1);
            String msg = epc.emailStatusBody(request, correct, d);

            HtmlEmail htmlEmail = new HtmlEmail();
            htmlEmail.setSubject(String.format("REQUEST %d - PARKING STATUS", request));
            htmlEmail.setHtmlMsg(msg);
            htmlEmail.addTo(email);
            htmlEmail.setFrom(sender);
            htmlEmail.setHostName("smtp.googlemail.com");
            htmlEmail.setSmtpPort(465);
            htmlEmail.setStartTLSEnabled(true);
            htmlEmail.setSSLOnConnect(true);
            htmlEmail.setAuthenticator(new DefaultAuthenticator(sender, password));
            htmlEmail.send();
            System.out.println("Email sent sucessfully");
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return false;
    }
}
