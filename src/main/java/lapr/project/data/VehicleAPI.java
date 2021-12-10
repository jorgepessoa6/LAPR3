package lapr.project.data;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lapr.project.model.Bicycle;
import lapr.project.model.Park;
import lapr.project.model.Scooter;
import oracle.jdbc.OracleTypes;

public class VehicleAPI extends DataHandler {

    public VehicleAPI() {
        super();
    }

    public VehicleAPI(String jdbcUrl, String username, String password) {
        super(jdbcUrl, username, password);
    }

    public void addBicycle(boolean isActive, String parkId, String desc, int weight, String wheel, double aerodynamicCf, double frontalArea) {
        String estado;
        try {
            if (isActive) {
                estado = "1";
            } else {
                estado = "0";
            }

            openConnection();

            CallableStatement callStmt = getConnection().prepareCall("{ call procAddBicycle(?,?,?,?,?,?,?) }");

            callStmt.setString(1, estado);
            callStmt.setString(2, parkId);
            callStmt.setString(3, desc);
            callStmt.setInt(4, weight);
            callStmt.setString(5, wheel);
            callStmt.setDouble(6, aerodynamicCf);
            callStmt.setDouble(7, frontalArea);

            callStmt.execute();

            closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addEscooter(boolean isActive, String parkId, String desc, int weight, String type, double aerodynamicCf, double frontalArea, int maxBattery, int actualBattery, int motor) {
        String estado;
        String tipo;
        try {
            if (isActive) {
                estado = "1";
            } else {
                estado = "0";
            }
            if (type.toUpperCase().equals("OFF-ROAD")) {
                tipo = "off-road";
            } else {
                tipo = "city";
            }

            openConnection();

            CallableStatement callStmt = getConnection().prepareCall("{ call procAddScooter(?,?,?,?,?,?,?,?,?,?) }");

            callStmt.setString(1, estado);
            callStmt.setString(2, parkId);
            callStmt.setString(3, desc);
            callStmt.setInt(4, weight);
            callStmt.setString(5, tipo);
            callStmt.setDouble(6, aerodynamicCf);
            callStmt.setDouble(7, frontalArea);
            callStmt.setInt(8, maxBattery);
            callStmt.setInt(9, actualBattery);
            callStmt.setInt(10, motor);

            callStmt.execute();

            closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Queries the database directly and returns a list with all the parks.
     */
    public List<Integer> getAvailableVehicles(double lat, double log) {
        List<Integer> vehicleList = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT cod_vehicle FROM Vehicle WHERE ");
        query.append(" latitude = ").append(lat);
        query.append(" longitude = ").append(log);
        saveInfoVehicle(vehicleList, query);
        return vehicleList;
    }

    private void saveInfoVehicle(List<Integer> vehicleList, StringBuilder query) {
        try {
            openConnection();
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query.toString());
            while (resultSet.next()) {
                vehicleList.add(resultSet.getInt("cod_vehicle"));
            }
            resultSet.close();
            statement.close();
            closeAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
    }
    
    public void updateVehicle(String idVehicle, boolean estado,String parque) {
        String disp=null;
        try {
            if(estado){
                disp="S";
            }else disp ="N";
            openConnection();

            CallableStatement callStmt = getConnection().prepareCall("{ call procUpdateVehicle(?,?,?) }");

            callStmt.setString(1, idVehicle);
            callStmt.setString(2, disp);
            callStmt.setString(3, parque);

            callStmt.execute();

            closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();

        }
    }

    /**
     * Removes vehicle
     *
     * @param idVehicle id of vehicle
     * @return true if removes vehicle with success
     */
    public boolean removeVehicleAPI(String idVehicle) {
        boolean isRemoved = false;
        try {
            CallableStatement resultado = getConnection().prepareCall("{call procdeletevehicle(?)}");
            resultado.setString(1, idVehicle);
            resultado.executeUpdate();
            resultado.close();
            isRemoved = true;
            return isRemoved;
        } catch (SQLException e) {
            e.printStackTrace();
            return isRemoved;
        }
    }

    public boolean addScooter(List<String[]> place) {
        ParkAPI parkAPI = new ParkAPI();
        try {
            openConnection();

            getConnection().setAutoCommit(false);

            Statement stmt = getConnection().createStatement();

            for (String[] i : place) {
                String insert = String.format("INSERT INTO vehicles(vehicle_desc,estado)"
                        + "VALUES('%s',%s)",
                        i[0], 1);
                String insert2 = String.format("INSERT INTO escooter(vehicle_desc,weight,scooter_type,aerodynamic_cf,frontal_area,battery_max,battery_actual,motor)"
                        + "VALUES('%s',%s,'%s',%s,%s,%s,%s)",
                        i[0], i[1], i[2], i[7], i[8], i[5], i[6], i[9]);
                String insert3 = String.format("INSERT INTO vehicle_parks(vehicle_desc, park_id)"
                        + "VALUES('%s','%s')",
                        i[0], parkAPI.getParkByCoord(Double.parseDouble(i[3]), Double.parseDouble(i[4])).getIdPark());
                stmt.addBatch(insert);
                stmt.addBatch(insert2);
                stmt.addBatch(insert3);
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

    public boolean addBike(List<String[]> place) {
        ParkAPI parkAPI = new ParkAPI();
        try {
            openConnection();

            getConnection().setAutoCommit(false);

            Statement stmt = getConnection().createStatement();

            for (String[] i : place) {
                String insert = String.format("INSERT INTO vehicles(vehicle_desc,estado)"
                        + "VALUES('%s',%s)",
                        i[0], 1);
                String insert2 = String.format("INSERT INTO bicycle(vehicle_desc,weight,aerodynamic_cf,frontal_area,wheel_size)"
                        + "VALUES('%s',%s,%s,%s,%s)",
                        i[0], i[1], i[4], i[5], i[6]);
                String insert3 = String.format("INSERT INTO vehicle_parks(vehicle_desc, park_id)"
                        + "VALUES('%s','%s')",
                        i[0], parkAPI.getParkByCoord(Double.parseDouble(i[2]), Double.parseDouble(i[3])).getIdPark());
                stmt.addBatch(insert);
                stmt.addBatch(insert2);
                stmt.addBatch(insert3);
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
     * Retorna uma lista com os códigos dos veículos de um parque
     *
     * @param park parque a procurar os veículos
     * @return lista com os códigos dos veículos do parque passado por parâmetro
     */
    public List<String> getDescVehiclesByPark(Park park) {
        List<String> descVehicles = new ArrayList<>();
        try {

            CallableStatement cs = getConnection().prepareCall("{call procGetVehiclesDescByPark(?,?)}");

            cs.setString(1, park.getIdPark());
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.executeUpdate();

            //Recuperar o cursor na forma de um ResultSet
            ResultSet cs1 = (ResultSet) cs.getObject(2);

            while (cs1.next()) {
                String cod_vehicle = cs1.getString("vehicle_desc");
                descVehicles.add(cod_vehicle);
            }

            return descVehicles;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            closeAll();

        }
    }

    /**
     * Retorna um map com os códigos e respetivas carga atuais dos veículos
     *
     * @param descVehicles descrição dos veículos
     * @return um map com os códigos e respetivas carga atuais dos veículos
     */
    public Map<String, Double> getActuallyBatery(List<String> descVehicles) {
        Map<String, Double> batteryActuallyVehicles = new HashMap<>();

        try {
            double battery = 0;
            CallableStatement resultado = getConnection().prepareCall("{?= call funcGetActualBattery(?)}");
            for (String desc : descVehicles) {

                resultado.registerOutParameter(1, Types.DOUBLE);
                resultado.setString(2, desc);

                resultado.executeUpdate();

                battery = resultado.getDouble(1);

                batteryActuallyVehicles.put(desc, battery);
            }

            return batteryActuallyVehicles;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            closeAll();

        }
    }

    public int getBattery(String cod_vehicle) {
        int number = 0;
        try {
            CallableStatement resultado = getConnection().prepareCall("{? = call funcgetBattery(?)}");
            resultado.registerOutParameter(1, Types.INTEGER);
            resultado.setString(2, cod_vehicle);
            resultado.executeQuery();
            number = resultado.getInt(1);
            return number;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            closeAll();

        }

    }

    public int getBatteryMax(String cod_vehicle) {
        int number = 0;
        try {
            CallableStatement resultado = getConnection().prepareCall("{? = call funcgetBatteryMax(?)}");
            resultado.registerOutParameter(1, Types.INTEGER);
            resultado.setString(2, cod_vehicle);
            resultado.executeQuery();
            number = resultado.getInt(1);
            return number;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            closeAll();

        }

    }

    public void updateScooter(String idVehicle, int battery, int maxBattery) {
        try {
            openConnection();

            CallableStatement callStmt = getConnection().prepareCall("{ call procUpdateBatteryScooter(?,?,?) }");

            callStmt.setString(1, idVehicle);
            callStmt.setInt(2, battery);
            callStmt.setInt(3, maxBattery);

            callStmt.execute();

            closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();

        }
    }

    public int getScooterNumber(String cod_vehicle) {
        int number = 0;
        try {
            CallableStatement resultado = getConnection().prepareCall("{? = call funcgetScooterNumber(?)}");
            resultado.registerOutParameter(1, Types.INTEGER);
            resultado.setString(2, cod_vehicle);
            resultado.executeQuery();
            number = resultado.getInt(1);
            return number;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            closeAll();

        }

    }

    public Bicycle getBicycleByDesc(String id) {
        CallableStatement callStmt;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getBicycleByDesc(?) }");

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setString(2, id);

            callStmt.execute();

            ResultSet rSet = (ResultSet) callStmt.getObject(1);
            if (rSet.next()) {
                String desc = rSet.getString(1);
                int weight = rSet.getInt(2);
                double aeCf = rSet.getDouble(3);
                double fa = rSet.getDouble(4);
                String wheel = rSet.getString(5);
                return new Bicycle(getCodVehicleByDesc(desc),getParkbyDesc(desc), desc, weight, aeCf, fa, 1, true, Integer.parseInt(wheel));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("No Bicycle with description: " + id);
    }

    public int getCodVehicleByDesc(String id) {
        CallableStatement callStmt;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getCodVehicleByDesc(?) }");

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setString(2, id);

            callStmt.execute();

            ResultSet rSet = (ResultSet) callStmt.getObject(1);
            if (rSet.next()) {
                return rSet.getInt(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("No Vehicle with description: " + id);
    }

    public Scooter getScooterByDesc(String id) {
        CallableStatement callStmt;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getScooterByDesc(?) }");

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setString(2, id);

            callStmt.execute();

            ResultSet rSet = (ResultSet) callStmt.getObject(1);
            if (rSet.next()) {
                String desc = rSet.getString(1);
                int weight = rSet.getInt(2);
                double aeCf = rSet.getDouble(3);
                double fa = rSet.getDouble(4);
                int baMax = rSet.getInt(5);
                int batActual = rSet.getInt(6);
                String type = rSet.getString(7);
                int motor = rSet.getInt(8);
                Scooter scooter = new Scooter();
                scooter.setType(type);
                return new Scooter(getCodVehicleByDesc(desc),getParkbyDesc(desc), desc, weight, scooter.getType(), baMax, batActual, aeCf, fa, true, motor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("No Scooter with description: " + id);
    }

    public String getParkbyDesc(String id) {
        CallableStatement callStmt;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getBicyclePark(?) }");

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setString(2, id);

            callStmt.execute();

            ResultSet rSet = (ResultSet) callStmt.getObject(1);
            if (rSet.next()) {
                return rSet.getString(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("No Vehicle with description: " + id);
    }

    /**
     * Retorna uma lista com os códigos dos veículos de um parque
     *
     * @param park parque a procurar os veículos
     * @return lista com os códigos dos veículos do parque passado por parâmetro
     */
    public List<String> getVehiclesByPark(Park park) {
        List<String> codsVehicles = new ArrayList<>();
        try {

            CallableStatement cs = getConnection().prepareCall("{call procGetVehiclesByPark(?,?)}");

            cs.setString(1, park.getIdPark());
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.executeUpdate();

            //Recuperar o cursor na forma de um ResultSet
            ResultSet cs1 = (ResultSet) cs.getObject(2);

            while (cs1.next()) {
                String cod_vehicle = cs1.getString("cod_vehicle");
                codsVehicles.add(cod_vehicle);
            }

            return codsVehicles;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            closeAll();

        }
    }

    /**
     * Retorna o tipo de escooter das descrições das escooters passadas por
     * parâmetro
     *
     * @param descVehicles descrições das escooters
     * @return tipo de escooter das descrições das escooters passadas por
     * parâmetro
     */
    public List<String> getEscootersTypes(List<String> descVehicles) {
        List<String> escootersTypes = new ArrayList<>();

        try {
            String type = "";
            CallableStatement resultado = getConnection().prepareCall("{?= call funcGetEscootersType(?)}");
            for (String desc : descVehicles) {

                resultado.registerOutParameter(1, Types.VARCHAR);
                resultado.setString(2, desc);

                resultado.executeUpdate();

                type = resultado.getString(1);

                escootersTypes.add(type);
            }

            return escootersTypes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            closeAll();

        }
    }
    
    public List<Scooter> getAllScooters(){
        CallableStatement callStmt;
        List<Scooter> list= new ArrayList<>();
        
        try {
            callStmt = getConnection().prepareCall("{ ? = call getAllScooters }");

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);

            callStmt.execute();

            ResultSet rSet = (ResultSet) callStmt.getObject(1);
            System.out.println(rSet);
            while (rSet.next()) {
                String desc = rSet.getString(1);
                list.add(getScooterByDesc(desc));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return list;}
    

}
