/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Location;
import lapr.project.model.Path;
import lapr.project.model.User;

/**
 * @author Jorge Pessoa
 */
public class Utils {

    private Utils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Calcular distancia entre coordenadas
     *
     * @return distancia entre coordenadas
     */
    public static double distance(double lat1, double lat2, double long1, double long2) {
        double radius = 6371e3;
        double a = Math.sin(Math.toRadians(lat2 - lat1) / 2) * Math.sin(Math.toRadians(lat2 - lat1) / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.sin(Math.toRadians(long2 - long1) / 2) * Math.sin(Math.toRadians(long2 - long1) / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = radius * c;
        return d / 1000;
    }

    public static double distanceElevation(double lat1, double long1, double elev1,
            double lat2, double long2, double elev2) {
        double d = distance(lat1, lat2, long1, long2);
        d = d * 1000;
        d = Math.pow(d, 2) + Math.pow((elev1 - elev2), 2);
        return Math.sqrt(d);
    }

    public static double calculateWind(double windDirection, double windSpeed, double latitudeA, double longitudeA, double latitudeB, double longitudeB) {
        double rLatitudeA = Math.toRadians(latitudeA);
        double rLatitudeB = Math.toRadians(latitudeB);
        double vLongitude = Math.toRadians(longitudeB - longitudeA);
        double x = Math.cos(rLatitudeA) * Math.sin(rLatitudeB) - Math.sin(rLatitudeA) * Math.cos(rLatitudeB) * Math.cos(vLongitude);
        double y = Math.sin(vLongitude) * Math.cos(rLatitudeB);
        double o = Math.atan2(y, x);
        double bearing = (Math.toDegrees(o) + 360) % 360;
        return Math.cos(Math.abs(bearing - windDirection)) * windSpeed;
    }
    /**
     * Criar array de inteiros em função da quantidade de pois de passagem
     * obrigatoria
     *
     * @param size quantidade de pois de passagem obrigatoria
     * @return array de inteiros
     */
    public static int[] createArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    /**
     * Obter possiveis permutacoes entre o array de inteiros
     *
     * @param arr array de inteiros
     * @return lista com possiveis permutacoes entre os do array
     */
    public static List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        permuteHelper(list, new ArrayList<>(), arr);
        return list;
    }

    /**
     * Obter permutacoes possiveis entre os valores
     *
     * @param list lista a guardar as permutacoes possiveis
     * @param resultList lista com permutacao possivel
     * @param arr valores para a permutacao
     */
    private static void permuteHelper(List<List<Integer>> list, List<Integer> resultList, int[] arr) {

        if (resultList.size() == arr.length) {
            list.add(new ArrayList<>(resultList));
        } else {
            for (int i = 0; i < arr.length; i++) {

                if (resultList.contains(arr[i])) {
                    continue;
                }
                resultList.add(arr[i]);
                permuteHelper(list, resultList, arr);
                resultList.remove(resultList.size() - 1);
            }
        }
    }

    public static double calculateEnergy(Location firstLocation, Location secondLocation, Path path, User user) {

        final double g = 9.8;
        final double avgSpeedB = 8.0;
        final double frontalArea = 0.5;
        final double airDensity = 1.226;
        final double weightVehicle = 25.0;
        final double dragCoefficient = 0.5;
        double avgSpeed = 0;
        double weight = 75;
        if(user != null){
            weight = user.getWeight() + weightVehicle;
            avgSpeed = user.getAverageSpeed();
        }
        if(avgSpeed <= 0){
            avgSpeed = avgSpeedB;
        }
        double distance = Utils.distance(firstLocation.getLatitude(), secondLocation.getLatitude(),
                firstLocation.getLongitude(), secondLocation.getLongitude());
        distance = distance * 1000;
        int heightDif = secondLocation.getElevation() - firstLocation.getElevation();
        heightDif = Math.abs(heightDif);
        if (distance <= 0) {
            return 0.0;
        }
        double wind = 0.0;
        double kcf = 0.5;

        if (path != null) {
            wind = Utils.calculateWind(path.getWindDirection(), path.getWindSpeed(), firstLocation.getLatitude(), firstLocation.getLongitude(), secondLocation.getLatitude(), secondLocation.getLongitude());
            kcf = path.getKineticCoefficient();
        }
        
        double direction;
        if(wind > 0){
            direction = -1;
        }else{
            direction = 1;
        }
        
        double speed;
        if(Math.abs(wind) >= 1.5){
            speed = (avgSpeed * Math.pow(wind, 2));
        }else{
            speed = Math.pow(avgSpeed, 3);
        }
        
        double windResistance = direction * 0.5 * airDensity * speed * dragCoefficient * frontalArea;
        double rollingResistance = avgSpeed * weight * g * kcf;
        double gravityForces = avgSpeed * weight * g * (heightDif / distance);
        double totalPower = (windResistance + rollingResistance + gravityForces);
        double avgTime = Utils.distanceElevation(firstLocation.getLatitude(), firstLocation.getLongitude(),
                firstLocation.getElevation(), secondLocation.getLatitude(),
                secondLocation.getLongitude(), secondLocation.getElevation()) / avgSpeed;
        return totalPower * (avgTime / 3600);
    }
}
