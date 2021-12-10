/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.data;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Gabriel Vieira
 */
public class ReportVehiclesAPI extends DataHandler {

    public ReportVehiclesAPI() {
    }

    public ReportVehiclesAPI(String jdbcUrl, String username, String password) {
        super(jdbcUrl, username, password);
    }

    /**
     * Return list of vehicles that are unlocked at a given moment and by whom
     *
     * @return list of vehicles that are unlocked at a given moment and by whom
     */
    public List<String> getReportVehicles() {
        List<String> list = new ArrayList<>();
        try {
            CallableStatement resultado = getConnection().prepareCall("{call procgetreportvehicles(?)}");
            resultado.registerOutParameter(1, OracleTypes.CURSOR);
            resultado.executeQuery();
            ResultSet resultado1 = (ResultSet) resultado.getObject(1);
            while (resultado1.next()) {
                list.add(resultado1.getString("username"));
                list.add(resultado1.getString("vehicle_desc"));
            }
            resultado1.close();
            resultado.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Write report with the vehicles that are unlocked and by whom
     *
     * @param outputFileName name of output file
     */
    public void writeReport(String outputFileName) {
        List<String> list = getReportVehicles();
        FileWriter fileWriter = null;
        try {
            String FILE_HEADER = "username;vehicle_desc";
            String COMMA_DELIMITER = ";";
            String NEW_LINE_SEPARATOR = "\n";
            fileWriter = new FileWriter(outputFileName);
            fileWriter.append(FILE_HEADER.toString());
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (int i = 0; i < list.size(); i = i + 2) {
                fileWriter.append(list.get(i));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(list.get(i + 1));
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

}
