/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.data;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Path;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Jorge Pessoa
 */
public class PathAPI extends DataHandler {

    public PathAPI() {
        super();
    }

    public PathAPI(String jdbcUrl, String username, String password) {
        super(jdbcUrl, username, password);
    }

    public void addPath(double latitudeA, double longitudeA, double latitudeB, double longitudeB, double kineticCoefficient, double windDirection, double windSpeed) {
        try {
            openConnection();

            CallableStatement callStmt = getConnection().prepareCall("{ call procAddPath(?,?,?,?,?,?,?) }");

            callStmt.setDouble(1, latitudeA);
            callStmt.setDouble(2, longitudeA);
            callStmt.setDouble(3, latitudeB);
            callStmt.setDouble(4, longitudeB);
            callStmt.setDouble(5, kineticCoefficient);
            callStmt.setDouble(6, windSpeed);
            callStmt.setDouble(7, windDirection);

            callStmt.execute();

            closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean addPath(List<String[]> place) {
        try {
            openConnection();

            getConnection().setAutoCommit(false);

            Statement stmt = getConnection().createStatement();

            for (String[] i : place) {
                System.out.println(i);
                String insert = String.format("INSERT INTO paths(latitude_A,longitude_A,latitude_B,longitude_B,kinetic_cf,wind_dir,wind_spd) "
                        + "VALUES(%s,%s,%s,%s,%s,%s,%s)",
                        i[0], i[1], i[2], i[3], i[4], i[5], i[6]);

                stmt.addBatch(insert);
            }
            stmt.executeBatch();

            closeAll();

            getConnection().setAutoCommit(true);
            return true;
        } catch (SQLException e) {
            try {
                getConnection().rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Queries the database directly and returns a list with all the Paths.
     */
    public List<Path> getAllPaths() {
        CallableStatement callStmt;
        List<Path> listPaths = new ArrayList<>();
        try {
            callStmt = getConnection().prepareCall("{ ? = call getAllPaths }");

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);

            callStmt.execute();

            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            while (rSet.next()) {

                int idPath = rSet.getInt(1);
                double latitudeA = rSet.getDouble(2);
                double longitudeA = rSet.getDouble(3);
                double latitudeB = rSet.getDouble(4);
                double longitudeB = rSet.getDouble(5);
                double kineticCf = rSet.getDouble(6);
                double windDir = rSet.getDouble(7);
                double windSpeed = rSet.getDouble(8);
                listPaths.add(new Path(idPath, latitudeA, longitudeA, latitudeB, longitudeB, kineticCf, windDir, windSpeed));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPaths;
    }

}
