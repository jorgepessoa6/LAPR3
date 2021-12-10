package lapr.project.ui;

import lapr.project.data.DataHandler;
import lapr.project.model.CalculatorExample;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr.project.assessment.Facade;
import lapr.project.assessment.Serviceable;
import lapr.project.controller.ChargeScooterController;
import lapr.project.controller.NearestParksController;
import lapr.project.data.Bootable;
import lapr.project.data.EmailParkedAPI;
import lapr.project.data.FileOutput;
import lapr.project.data.FileReader;
import lapr.project.data.ParkAPI;
import lapr.project.data.PointOfInterestAPI;
import lapr.project.data.VehicleAPI;
import lapr.project.model.Park;
import lapr.project.model.Scooter;

/**
 * @author Nuno Bettencourt <nmb@isep.ipp.pt> on 24/05/16.
 */
class Main {

    /**
     * Logger class.
     */
    private static final Logger LOGGER = Logger.getLogger("MainLog");

    /**
     * Private constructor to hide implicit public one.
     */
    private Main() {

    }

    /**
     * Application main method.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SQLException {
        try {
            Properties properties =
                    new Properties(System.getProperties());
            InputStream input = new FileInputStream("target/classes/application.properties");
            properties.load(input);
            input.close();
            System.setProperties(properties);

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Bootable b = new Bootable();
        b.createTables("sql/createTables.sql");
        
        addPOIs("pois.csv");
        
        PointOfInterestAPI poiapi = new PointOfInterestAPI();
        System.out.println(poiapi.getAllPois());

        //Bootable b = new Bootable();
        //b.createTables("sql/createTables.sql");
        
        /*EmailParkedAPI ep = new EmailParkedAPI();
        System.out.println("SEND MAIL");
        ep.emailStatus(0, "test nº 1", "ricardoregolopes@gmail.com");*/
        /*CalculatorExample calculatorExample = new CalculatorExample();
        int value = calculatorExample.sum(3, 5);

        if (LOGGER.isLoggable(Level.INFO))
            LOGGER.log(Level.INFO, String.valueOf(value));

        //load database properties

        try {
            Properties properties =
                    new Properties(System.getProperties());
            InputStream input = new FileInputStream("target/classes/application.properties");
            properties.load(input);
            input.close();
            System.setProperties(properties);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //Initial Database Setup
        DataHandler dh = new DataHandler();
        dh.scriptRunner("target/test-classes/demo_jdbc.sql");
    /*
        System.out.println("\nVerificar se existe Sailor 100...");
        try {
            Sailor.getSailor(100);
            System.out.println("Nunca deve aparecer esta mensagem");
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("\nAdicionar Sailor ...");


        long sailorID = 100;
        String sailorName = "Popeye";
        long sailorRating = 11;
        int sailorAge = 85;

        Sailor sailor = new Sailor(sailorID, sailorName);
        sailor.setAge(sailorAge);
        sailor.setRating(sailorRating);
        sailor.save();

        System.out.println("\t... Sailor Adicionado.");

        System.out.println("\nVerificar se existe Sailor 100...");
        try {
            sailor = Sailor.getSailor(100);
            System.out.println("\nSailor 100 existe...: " + sailor.getName());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
            */
    }
    
    public static int addPOIs(String inputFile
    ) {
        ArrayList<String> info = FileReader.readFile(inputFile);
        List<String[]> place = FileReader.getPois(info);

        int num = 0;

        PointOfInterestAPI poiAPI = new PointOfInterestAPI();

        boolean check = poiAPI.addPoi(place);
        if (check) {
            num = place.size();
        }

        return num;
    }
    
}