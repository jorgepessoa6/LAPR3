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
import lapr.project.model.Poi;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Gabriel Vieira
 */
public class PointOfInterestAPI extends DataHandler {

    public PointOfInterestAPI() {
        super();
    }

    public PointOfInterestAPI(String jdbcUrl, String username, String password) {
        super(jdbcUrl, username, password);
    }
    
    public void addPointOfInterest(double latitude, double longitude, int elevation, String description) {
        try {
            CallableStatement resultado = getConnection().prepareCall("{call procaddpoi(?,?,?,?)}");
            resultado.setDouble(1, latitude);
            resultado.setDouble(2, longitude);
            resultado.setInt(3, elevation);
            resultado.setString(4, description);
            resultado.executeUpdate();
            resultado.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean addPoi(List<String[]> place) {
        try {
            openConnection();

            getConnection().setAutoCommit(false);

            Statement stmt = getConnection().createStatement();

            for (String[] i : place) {
                String insert = String.format("INSERT INTO pois(latitude,longitude,elevation,poi_description) "
                        + "VALUES(%s,%s,%s,'%s')",
                        i[0], i[1], i[2], i[3]);
                System.out.println(insert);
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

    public Poi getPoiByCoord(double a, double b) {
        CallableStatement callStmt;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getPoiByCoord(?,?) }");

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setDouble(2, a);
            callStmt.setDouble(3, b);

            callStmt.execute();

            ResultSet rSet = (ResultSet) callStmt.getObject(1);
            if (rSet.next()) {
                double latitude = rSet.getDouble(1);
                double longitude = rSet.getDouble(2);
                int elevation = rSet.getInt(3);
                String desc = rSet.getString(4);
                return new Poi(latitude, longitude, elevation, desc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void removePointOfInterest(double latitude, double longitude) {
        try {
            CallableStatement resultado = getConnection().prepareCall("{call procremovepoi(?,?)}");
            resultado.setDouble(1, latitude);
            resultado.setDouble(2, longitude);
            resultado.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    /**
     * Queries the database directly and returns a list with all the Paths.
     */
    public List<Poi> getAllPois() {
        CallableStatement callStmt;
        List<Poi> listPois = new ArrayList<>();
        try {
            callStmt = getConnection().prepareCall("{ ? = call getAllPois }");

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);

            callStmt.execute();

            ResultSet rSet = (ResultSet) callStmt.getObject(1);
            while (rSet.next()) {
                double latitude = rSet.getDouble(1);
                double longitude = rSet.getDouble(2);
                int elevation = rSet.getInt(3);
                String desc = rSet.getString(4);
                listPois.add(new Poi(latitude,longitude,elevation,desc));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPois;
    }

}
