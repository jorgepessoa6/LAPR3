/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import lapr.project.model.Location;
import lapr.project.model.Park;
import lapr.project.model.RouteEnergy;
import lapr.project.model.Scooter;
import lapr.project.utils.Utils;

public class FileOutput {

    public static void saveNearestPark(double userLatitudeInDegrees, double userLongitudeInDegrees, String outputFileName, List<Park> parks) {
        try (PrintWriter pwriter = new PrintWriter(new File(outputFileName))) {
            StringBuilder sb = new StringBuilder();
            sb.append("latitude");
            sb.append(';');
            sb.append("longitude");
            sb.append(';');
            sb.append("distance in meters");
            sb.append('\n');

            pwriter.write(sb.toString());

            for (Park park : parks) {
                sb = new StringBuilder();
                sb.append(park.getLatitude());
                sb.append(';');
                sb.append(park.getLongitude());
                sb.append(';');
                double dist = Utils.distance(userLatitudeInDegrees, park.getLatitude(), userLongitudeInDegrees, park.getLongitude());
                dist = dist * 1000;
                int distM = (int) Math.round(dist);
                sb.append(distM);
                sb.append('\n');

                pwriter.write(sb.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void saveVehiclesDescription(String outputFileName, List<String> list) {
        FileWriter fileWriter = null;
        try {
            String FILE_HEADER = "vehicle_desc";
            String NEW_LINE_SEPARATOR = "\n";
            fileWriter = new FileWriter(outputFileName);
            fileWriter.append(FILE_HEADER.toString());
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (String b : list) {
                fileWriter.append(b);
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }

    public static double saveEnergyPath(int elevationDif, RouteEnergy routeEnergy, int k, String outputFileName) {
        double dist = 0;

        Location location = routeEnergy.getRoute().get(0);
        Location location2;
        for (int i = 1; i < routeEnergy.getRoute().size(); i++) {
            location2 = routeEnergy.getRoute().get(i);
            dist += Utils.distance(location.getLatitude(), location2.getLatitude(), location.getLongitude(), location2.getLongitude());
            location = location2;
        }
        try (PrintWriter pwriter = new PrintWriter(new File(outputFileName))) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("Path %03d", k));
            sb.append('\n');
            sb.append(String.format("total_distance: %.0f", dist*1000));
            sb.append('\n');
            sb.append(String.format("total_energy: %.2f", routeEnergy.getEnergy()));
            sb.append('\n');
            sb.append("elevation: ");
            sb.append(elevationDif);
            sb.append('\n');
            for (Location loc : routeEnergy.getRoute()) {
                sb.append(loc.getLatitude()).append(";").append(loc.getLongitude());
                sb.append('\n');
            }

            pwriter.write(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return dist;
    }

    public static double saveShortestPath(int elevationDif, List<List<Location>> routes, String outputFileName) {
        double dist = 0;
        int j = 1;

        for (int i = 0; i < routes.get(0).size(); i++) {
            dist += Utils.distance(routes.get(0).get(i).getLatitude(), routes.get(0).get(i + 1).getLatitude(), routes.get(0).get(i).getLongitude(), routes.get(0).get(i + 1).getLongitude());
        }

        try (PrintWriter pwriter = new PrintWriter(new File(outputFileName))) {
            for (List<Location> l : routes) {
                double energy = 0;
                StringBuilder sb = new StringBuilder();
                sb.append(String.format("Path %03d", j));
                sb.append('\n');
                sb.append(String.format("total_distance: %.0f", dist));
                sb.append('\n');
                sb.append("elevation: ");
                sb.append(elevationDif);
                sb.append('\n');
                for (Location loc : l) {
                    sb.append(loc.getLatitude()).append(";").append(loc.getLongitude());
                    sb.append('\n');
                }
                pwriter.write(sb.toString());
                j++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return dist;
    }

    public static void shortestRouteBetweenTwoParks(List<LinkedList<Location>> res, String outputFileName) {
        try (PrintWriter pwriter = new PrintWriter(new File(outputFileName))) {
            StringBuilder sb = new StringBuilder();
            sb.append("latitude");
            sb.append(';');
            sb.append("longitude");
            sb.append(';');
            sb.append("elevacao");
            sb.append('\n');

            pwriter.write(sb.toString());

            sb = new StringBuilder();
            for (LinkedList<Location> ll : res) {
                for (Location l : ll) {
                    sb.append(l.getLatitude());
                    sb.append(';');
                    sb.append(l.getLongitude());
                    sb.append(';');
                    sb.append(l.getElevation());
                    sb.append('\n');
                }
                pwriter.write(sb.toString());
                sb.append('\n');
                sb = new StringBuilder();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static void saveSuggestEscooter(List<Scooter> list,String outputFileName){
        try (PrintWriter pwriter = new PrintWriter(new File(outputFileName))) {
            StringBuilder sb = new StringBuilder();
            sb.append("codigo");
            sb.append(';');
            sb.append("descricao");
            sb.append('\n');

            pwriter.write(sb.toString());

            for (Scooter s: list) {
                sb = new StringBuilder();
                sb.append(s.getIdVehicle());
                sb.append(';');
                sb.append(s.getDescription());
                sb.append('\n');
                pwriter.write(sb.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    

}
