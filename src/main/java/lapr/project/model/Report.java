/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lapr.project.data.VehicleAPI;

public class Report {

    public Report() {
    }

    public static List<Double> calculateLoadEstimate(List<String> descsVehicles, int numberScooters) {
        List<Double> loadEstimatesToEscooters = new ArrayList<>();

        int batteryMax = 0;
        int batteryActual = 0;
        double load = 0;

        VehicleAPI vApi = new VehicleAPI();

        for (String desc : descsVehicles) {
            batteryMax = vApi.getBatteryMax(desc);
            batteryActual = vApi.getBattery(desc);
            load = loadEstimate(batteryActual, batteryMax, numberScooters);
            if (load != 0) {
                loadEstimatesToEscooters.add(load);
            } else {
                loadEstimatesToEscooters.add(0.0);
            }

        }

        return loadEstimatesToEscooters;
    }

    public static float loadEstimate(int battery, int batteryMax, int numberScooters) {
        float carga = (3520 / numberScooters);
        float tempo = 0;

        if (carga > 3000) {
            carga = 3000;
        }

        if (battery < batteryMax && battery >= 0 && batteryMax >= 0 && carga > 0 && numberScooters > 0) {
            float difBatt = batteryMax - battery;

            if (difBatt == 0) {
                return 0;
            }
            tempo = difBatt / carga;
        }

        return tempo * 3600;

    }

    /**
     * Cria o relatório de um parque, contendo a informação acerca da carga
     * atual de cada veículo,bem como do tempo de carga estimado até à caraga
     * total
     *
     * @param outputFileName nome do ficheiro do relatório
     * @param loadEstim lista com o valor do tempo estimado até à carga total de
     * cada uma das escooters
     * @param mapCods mapa com a descrição e carga atual de cada escooter
     * @return número de escooters que não estão carregadas totalmente
     */
    public long constructOutputFile(String outputFileName, List<Double> loadEstim, Map<String, Double> mapCods, List<String> eTypes) {

        long numUnloadedScooters = 0;
        numUnloadedScooters = getNumUnloadedScooters(mapCods);
        int i = 0;

        NumberFormat formatarFloat = new DecimalFormat("0.00");
        FileWriter fileWriter = null;
        try {
            String FILE_HEADER = "escooter description;type;actual battery capacity;time to finish charge in seconds";
            String COMMA_DELIMITER = ";";
            String NEW_LINE_SEPARATOR = "\n";
            fileWriter = new FileWriter(outputFileName);
            fileWriter.append(FILE_HEADER.toString());
            fileWriter.append(NEW_LINE_SEPARATOR);

            for (String cod : mapCods.keySet()) {
                fileWriter.append(cod);
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(eTypes.get(i).trim());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(mapCods.get(cod)));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.format("%.2f", loadEstim.get(i)));
                fileWriter.append(NEW_LINE_SEPARATOR);
                i++;
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

        return numUnloadedScooters;
    }

    /**
     * Retorna o número de escooters com carga atual abaixo da totalidade
     *
     * @param map_cods mapa com as descrições e carga das escooters
     * @return número de escooters com carga atual abaixo da totalidade
     */
    public long getNumUnloadedScooters(Map<String, Double> map_cods) {
        long i = 0;
        for (String cod : map_cods.keySet()) {
            if (map_cods.get(cod) != 100.00) {
                i++;
            }
        }

        return i;
    }

//     NÃO APAGAR - EM COMENTÁRIO DEVIDO ÀS METAS DE COVERAGE    
    /**
     * Cria o relatório dos pontos de um utilizador
     *
     * @param outputFileName
     * @param vehicle_desc
     * @param vehicleUnlockTime
     * @param vehicleLockTime
     * @param latitude
     * @param longitude
     * @param elevation
     * @param latitudeEnd
     * @param longitudeEnd
     * @param elevationEnd
     * @param elevationDifference
     * @param points
     * @return número atual de pontos do user
     */
    public int constructPointsReport(String outputFileName, Map<Integer,List<String>> mapInfo) {

        int userPoints = 0;
        //userPoints = getNumUnloadedScooters(map_cods);

        NumberFormat formatarFloat = new DecimalFormat("0.00");
        FileWriter fileWriter = null;
        try {
            String FILE_HEADER = "vehicle description;vehicle unlock time;vehicle lock time;origin park latitude;origin park "
                    + "longitude;origin park elevation;destination park latitude;destination park longitude;destination park"
                    + " elevation;elevation difference;points";
            String COMMA_DELIMITER = ";";
            String NEW_LINE_SEPARATOR = "\n";
            fileWriter = new FileWriter(outputFileName);
            fileWriter.append(FILE_HEADER.toString());
            fileWriter.append(NEW_LINE_SEPARATOR);

            for (Integer cod : mapInfo.keySet()){
                List<String> strL = mapInfo.get(cod);
                for (String info: strL){
                    fileWriter.append(info);
                    fileWriter.append(COMMA_DELIMITER);
                }
                
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

        return userPoints;
    }
}
