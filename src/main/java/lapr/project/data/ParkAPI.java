package lapr.project.data;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import lapr.project.model.Park;
import lapr.project.model.Report;
import static lapr.project.model.Report.calculateLoadEstimate;
import oracle.jdbc.OracleTypes;

public class ParkAPI extends DataHandler {

    public ParkAPI() {
        super();
    }

    public ParkAPI(String jdbcUrl, String username, String password) {
        super(jdbcUrl, username, password);
    }

    /**
     * Queries the database directly and returns a list with all the parks.
     */
    public List<Park> getAllParks() {
        CallableStatement callStmt;
        List<Park> listParks = new ArrayList<>();
        try {
            callStmt = getConnection().prepareCall("{ ? = call getAllParks }");

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);

            callStmt.execute();

            ResultSet rSet = (ResultSet) callStmt.getObject(1);
            System.out.println(rSet);
            while (rSet.next()) {

                String idPark = rSet.getString(1);
                double latitude = rSet.getDouble(2);
                double longitude = rSet.getDouble(3);
                getParkInfoAllParks(latitude, longitude, listParks, idPark);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listParks;
    }

    private void getParkInfoAllParks(double latitude, double longitude, List<Park> listParks, String idPark) {
        CallableStatement callStmt = null;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getParkInfoByCoord(?,?) }");

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setDouble(2, latitude);
            callStmt.setDouble(3, longitude);

            callStmt.execute();
            ResultSet rSet2 = (ResultSet) callStmt.getObject(1);
            if (rSet2.next()) {
                latitude = rSet2.getDouble(1);
                longitude = rSet2.getDouble(2);
                int elevation = rSet2.getInt(3);
                String parkDesc = rSet2.getString(4);
                int maxBicycles = rSet2.getInt(5);
                int maxScooters = rSet2.getInt(6);
                double voltage = rSet2.getDouble(7);
                double current = rSet2.getDouble(8);
                listParks.add(new Park(idPark, parkDesc, maxScooters, maxBicycles, latitude, longitude, elevation, voltage, current));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Queries the database directly and returns a specific park by park_id.
     */
    public Park getParkById(String id) {
        CallableStatement callStmt;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getParkById(?) }");

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setString(2, id);

            callStmt.execute();

            ResultSet rSet = (ResultSet) callStmt.getObject(1);
            if (rSet.next()) {
                String idPark = rSet.getString(1);
                double latitude = rSet.getDouble(2);
                double longitude = rSet.getDouble(3);
                return getParkInfoID(latitude, longitude, idPark);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("No Park with ID: " + id);
    }

    /**
     * Queries the database directly and returns a specific park by park_id.
     */
    public Park getParkByCoord(double a, double b) {
        CallableStatement callStmt;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getParkByCoord(?,?) }");

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setDouble(2, a);
            callStmt.setDouble(3, b);

            callStmt.execute();

            ResultSet rSet = (ResultSet) callStmt.getObject(1);
            if (rSet.next()) {
                String idPark = rSet.getString(1);
                double latitude = rSet.getDouble(2);
                double longitude = rSet.getDouble(3);
                return getParkInfoID(latitude, longitude, idPark);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Park getParkInfoID(double latitude, double longitude, String idPark) {
        CallableStatement callStmt;
        ResultSet rSet;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getParkInfoByCoord(?,?) }");
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setDouble(2, latitude);
            callStmt.setDouble(3, longitude);
            callStmt.execute();
            rSet = (ResultSet) callStmt.getObject(1);
            if (rSet.next()) {
                latitude = rSet.getDouble(1);
                longitude = rSet.getDouble(2);
                int elevation = rSet.getInt(3);
                String parkDesc = rSet.getString(4);
                int maxBicycles = rSet.getInt(5);
                int maxScooters = rSet.getInt(6);
                double voltage = rSet.getDouble(7);
                double current = rSet.getDouble(8);
                return new Park(idPark, parkDesc, maxScooters, maxBicycles, latitude, longitude, elevation, voltage, current);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("No Park with ID: " + idPark);
    }

    /**
     * Atualiza o parque na base de dados
     *
     * @param description descrição do parque
     * @param latitude latitude do parque
     * @param longitude maxScooters do parque
     * @param elevation elevação do parque
     * @param maxBicycles número máximo de bicicletas do parque
     * @param maxScooters número máximo de scooters do parque
     * @param voltage voltagem do parque
     * @param current current do parque
     */
    public void updateParkAPI(String description, double latitude, double longitude, int elevation, int maxBicycles, int maxScooters, double voltage, double current) {
        try {
            openConnection();

            CallableStatement callStmt = getConnection().prepareCall("{ call procUpdatePark(?,?,?,?,?,?,?,?) }");

            callStmt.setInt(1, elevation);
            callStmt.setString(2, description);
            callStmt.setInt(3, maxBicycles);
            callStmt.setInt(4, maxScooters);
            callStmt.setDouble(5, voltage);
            callStmt.setDouble(6, current);
            callStmt.setDouble(7, latitude);
            callStmt.setDouble(8, longitude);

            callStmt.executeUpdate();

            closeAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
    }

    /**
     * Return list of bicycles at a park
     *
     * @param latitude latitude of park
     * @param longitude maxScooters of park
     * @return list of bicycles at a park
     */
    public List<String> getBicyclesInParksByLatAndLon(double latitude, double longitude) {
        List<String> list = new ArrayList<>();
        try {
            CallableStatement resultado = getConnection().prepareCall("{call procgetbicyclesinparkbycoordinates(?,?,?)}");
            resultado.setDouble(1, latitude);
            resultado.setDouble(2, longitude);
            resultado.registerOutParameter(3, OracleTypes.CURSOR);
            resultado.executeQuery();
            ResultSet resultado1 = (ResultSet) resultado.getObject(3);
            while (resultado1.next()) {
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
     * Return list of escooters at a park
     *
     * @param latitude latitude of park
     * @param longitude maxScooters of park
     * @return list of escooters at a park
     */
    public List<String> getEscootersInParksByLatAndLon(double latitude, double longitude) {
        List<String> list = new ArrayList<>();
        try {
            CallableStatement resultado = getConnection().prepareCall("{call procgetescootersinparkbycoordinates(?,?,?)}");
            resultado.setDouble(1, latitude);
            resultado.setDouble(2, longitude);
            resultado.registerOutParameter(3, OracleTypes.CURSOR);
            resultado.executeQuery();
            ResultSet resultado1 = (ResultSet) resultado.getObject(3);
            while (resultado1.next()) {
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
     * Return a list of bicycles at a park
     *
     * @param idPark id of park
     * @return list of bicycles at a park
     */
    public List<String> getBicyclesInParksById(String idPark) {
        List<String> list = new ArrayList<>();
        try {
            CallableStatement resultado = getConnection().prepareCall("{call procgetbicyclesinpark(?,?)}");
            resultado.setString(1, idPark);
            resultado.registerOutParameter(2, OracleTypes.CURSOR);
            resultado.executeQuery();
            ResultSet resultado1 = (ResultSet) resultado.getObject(2);
            while (resultado1.next()) {
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
     * Return a list of escooters at a park
     *
     * @param idPark id of park
     * @return list of escooters at a park
     */
    public List<String> getEscootersInParksById(String idPark) {
        List<String> list = new ArrayList<>();
        try {
            CallableStatement resultado = getConnection().prepareCall("{call procgetescootersinpark(?,?)}");
            resultado.setString(1, idPark);
            resultado.registerOutParameter(2, OracleTypes.CURSOR);
            resultado.executeQuery();
            ResultSet resultado1 = (ResultSet) resultado.getObject(2);
            while (resultado1.next()) {
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
     * Return the number of free places at a park for bicycles
     *
     * @param idPark id of park
     * @param username username of user
     * @return the number of free places at a park for bicycles
     */
    public int getFreePlacesBicyclesInParksByIdAndUsername(String idPark, String username) {
        int number = 0;
        try {
            CallableStatement resultado = getConnection().prepareCall("{? = call funcgetfreeplacesbicyclesinpark(?,?)}");
            resultado.registerOutParameter(1, Types.INTEGER);
            resultado.setString(2, idPark);
            resultado.setString(3, username);
            resultado.executeQuery();
            number = resultado.getInt(1);
            resultado.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return number;
    }

    /**
     * Return number of free places at a park for scooters
     *
     * @param idPark id park
     * @param username username of user
     * @return number of free places at a park for scooters
     */
    public int getFreePlacesScootersInParksByIdAndUsername(String idPark, String username) {
        int number = 0;
        try {
            CallableStatement resultado = getConnection().prepareCall("{? = call funcgetfreeplacesscootersinpark(?,?)}");
            resultado.registerOutParameter(1, Types.INTEGER);
            resultado.setString(2, idPark);
            resultado.setString(3, username);
            resultado.executeQuery();
            number = resultado.getInt(1);
            resultado.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return number;
    }

    /**
     * Return number of free places at a park for determined vehicle
     *
     * @param username username of user
     * @param idpark id of park
     * @return number of free places at a park for determined vehicle
     */
    public int getFreePlacesVehiclesInParks(String username, String idpark) {
        int number = 0;
        try {
            CallableStatement resultado = getConnection().prepareCall("{? = call funcgetfreeplacesvehiclesinpark(?,?)}");
            resultado.registerOutParameter(1, Types.INTEGER);
            resultado.setString(2, username);
            resultado.setString(3, idpark);
            resultado.executeQuery();
            number = resultado.getInt(1);
            resultado.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return number;
    }

    /**
     * Removes park
     *
     * @param idPark id of park
     * @return true if park was removed with success
     */
    public boolean removeParkAPI(String idPark) {
        boolean estado = false;
        try {
            CallableStatement resultado = getConnection().prepareCall("{call procdeletepark(?)}");
            resultado.setString(1, idPark);
            resultado.executeUpdate();
            resultado.close();
            estado = true;
            return estado;
        } catch (SQLException e) {
            e.printStackTrace();
            return estado;
        }
    }

    public boolean addPark(String idPark, double latitude, double longitude, int elevation, String description, int maxCapacityScooters, int maxCapacityBicycles, double voltage, double current) {
        try {
            openConnection();

            CallableStatement callStmt = getConnection().prepareCall("{ call procAddPark(?,?,?,?,?,?,?,?,?) }");

            callStmt.setString(1, idPark);
            callStmt.setDouble(2, latitude);
            callStmt.setDouble(3, longitude);
            callStmt.setInt(4, elevation);
            callStmt.setString(5, description);
            callStmt.setInt(6, maxCapacityBicycles);
            callStmt.setInt(7, maxCapacityScooters);
            callStmt.setDouble(8, voltage);
            callStmt.setDouble(9, current);

            callStmt.execute();

            closeAll();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addPark(List<String[]> place) {
        try {
            openConnection();

            getConnection().setAutoCommit(false);

            Statement stmt = getConnection().createStatement();

            for (String[] i : place) {
                String insert = String.format("INSERT INTO parks_info(latitude,longitude,elevation,park_desc,max_bicycles,max_scooters,input_voltage,input_current) "
                        + "VALUES(%s,%s,%s,'%s',%s,%s,%s,%s)",
                        i[1], i[2], i[3], i[4], i[5], i[6], i[7], i[8]);

                System.out.println(insert);

                String insert2 = String.format("INSERT INTO parks(park_id,latitude,longitude)"
                        + "VALUES('%s',%s,%s)", i[0], i[1], i[2]);

                stmt.addBatch(insert);
                stmt.addBatch(insert2);
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
     * Retorna a elevação do parque
     *
     * @param idPark id do parque
     * @return elevação do parque
     */
    public Integer getParkElevation(String idPark) {

        try {
            Integer elevation = 0;
            CallableStatement resultado = getConnection().prepareCall("{?= call funcGetParkElevation(?)}");

            resultado.registerOutParameter(1, Types.INTEGER);
            resultado.setString(2, idPark);

            resultado.executeUpdate();

            elevation = resultado.getInt(1);

            return elevation;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            closeAll();

        }

    }

    public float getLatitudeById(String idPark) {

        try {
            float latitude = 0;
            CallableStatement resultado = getConnection().prepareCall("{?= call funcGetParkLatitude(?)}");

            resultado.registerOutParameter(1, Types.FLOAT);
            resultado.setString(2, idPark);

            resultado.executeUpdate();

            latitude = resultado.getFloat(1);

            return latitude;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            closeAll();

        }
    }

    public float getLongitudeById(String idPark) {

        try {
            float longitude = 0;
            CallableStatement resultado = getConnection().prepareCall("{?= call funcGetParkLongitude(?)}");

            resultado.registerOutParameter(1, Types.FLOAT);
            resultado.setString(2, idPark);

            resultado.executeUpdate();

            longitude = resultado.getFloat(1);

            return longitude;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            closeAll();

        }
    }

    public int getMaxScooters(float latitude, float longitude) {

        try {
            int maxScooters = 0;
            CallableStatement resultado = getConnection().prepareCall("{?= call GetMaxScooters(?,?)}");
          
                resultado.registerOutParameter(1, Types.INTEGER);
                resultado.setFloat(2, latitude);
                resultado.setFloat(3, longitude);
                

            resultado.registerOutParameter(1, Types.INTEGER);
            resultado.setFloat(2, latitude);
            resultado.setFloat(3, longitude);

            resultado.executeUpdate();

            maxScooters = resultado.getInt(1);

            return maxScooters;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            closeAll();

        }
     }
     

}
