package lapr.project.data;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lapr.project.model.Trip;
import oracle.jdbc.OracleTypes;

/**
 * @author Jorge Pessoa
 */
public class TripAPI extends DataHandler {

    public TripAPI() {
        super();
    }

    public TripAPI(String jdbcUrl, String username, String password) {
        super(jdbcUrl, username, password);
    }

    public Trip getUnfinishedTripOfUser(String id) {
        CallableStatement callStmt;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getUnfinishedTripOfUser(?) }");

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setString(2, id);
            callStmt.execute();
            ResultSet rSet = (ResultSet) callStmt.getObject(1);
            if (rSet.next()) {
                int codTrip = rSet.getInt(1);
                String email = rSet.getString(2);
                String codVehicle = rSet.getString(3);
                String parkIdStart = rSet.getString(4);
                String startDate;
                if (rSet.getTimestamp(5) == null) {
                    startDate = null;
                } else {
                    startDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(rSet.getTimestamp(5));
                }
                String endDate;
                if (rSet.getTimestamp(6) == null) {
                    endDate = null;
                } else {
                    endDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(rSet.getTimestamp(6));
                }
                double latitudeEnd = rSet.getDouble(7);
                double longitudeEnd = rSet.getDouble(8);
                return new Trip(codTrip, codVehicle, email, parkIdStart, latitudeEnd, longitudeEnd, startDate, endDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Trip> getUserHistory(String id) {
        CallableStatement callStmt;
        List<Trip> listTrips = new ArrayList<>();
        try {
            callStmt = getConnection().prepareCall("{ ? = call getUserHistory(?) }");

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setString(2, id);

            callStmt.execute();

            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            while (rSet.next()) {
                int codTrip = rSet.getInt(1);
                String email = rSet.getString(2);
                String codVehicle = rSet.getString(3);
                String parkIdStart = rSet.getString(4);
                String startDate;
                if (rSet.getTimestamp(5) == null) {
                    startDate = null;
                } else {
                    startDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(rSet.getTimestamp(5));
                }
                String endDate;
                if (rSet.getTimestamp(6) == null) {
                    endDate = null;
                } else {
                    endDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(rSet.getTimestamp(6));
                }
                double latitudeEnd = rSet.getDouble(7);
                double longitudeEnd = rSet.getDouble(8);
                listTrips.add(new Trip(codTrip, codVehicle, email, parkIdStart, latitudeEnd, longitudeEnd, startDate, endDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listTrips;
    }

    public void createTrip(String desc, String email, String idStartPark) {
        try {
            openConnection();

            CallableStatement callStmt = getConnection().prepareCall("{ call procAddTrip(?,?,?) }");

            callStmt.setString(1, email);
            callStmt.setString(2, desc);
            callStmt.setString(3, idStartPark);

            callStmt.execute();

            closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getInfo(int request) {
        try {
            openConnection();

            Statement stmt = getConnection().createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM trips WHERE cod_trip = " + request);

            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getEmail(int request) {
        try {
            ResultSet rs = getInfo(request);
            rs.next();
            String email = rs.getString("email");
            closeAll();
            return email;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Date getStartDate(int request) {
        try {
            ResultSet rs = getInfo(request);
            rs.next();
            Date date = rs.getDate("start_date");
            closeAll();
            return date;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Retorna data de início da viagem
     *
     * @param tripCod código da viagem
     * @return data de início da viagem
     */
    public Date getStartDate(Integer tripCod) {

        try {
            Date startDate = null;
            CallableStatement resultado = getConnection().prepareCall("{?= call funcGetStartDate(?)}");

            resultado.registerOutParameter(1, Types.DATE);
            resultado.setInt(2, tripCod);

            resultado.executeUpdate();

            startDate = resultado.getDate(1);

            return startDate;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            closeAll();

        }

    }

    /**
     * Retorna data de fim da viagem
     *
     * @param tripCod código da viagem
     * @return data de fim da viagem
     */
    public Date getEndDate(Integer tripCod) {

        try {
            Date endDate = null;
            CallableStatement resultado = getConnection().prepareCall("{?= call funcGetEndDate(?)}");

            resultado.registerOutParameter(1, Types.DATE);
            resultado.setInt(2, tripCod);

            resultado.executeUpdate();

            endDate = resultado.getDate(1);

            return endDate;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            closeAll();

        }

    }

    /**
     * Retorna o parque de partida da viagem
     *
     * @param codTrip código da viagem
     * @return id do parque de partida da viagem
     */
    public String getParkIdStart(int codTrip) {

        try {
            String parkIdStart = null;
            CallableStatement resultado = getConnection().prepareCall("{?= call funcGetParkIdStart(?)}");

            resultado.registerOutParameter(1, Types.VARCHAR);
            resultado.setInt(2, codTrip);

            resultado.executeUpdate();

            parkIdStart = resultado.getString(1);

            return parkIdStart;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            closeAll();

        }

    }

    /**
     * Retorna o código da viagem com o veículo passado por parâmetro
     *
     * @param descVehicle id do veículo
     * @return código da viagem com o veículo passado por parâmetro
     */
    public int getTripByDescVehicle(String descVehicle) {

        try {
            int codTrip = 0;
            CallableStatement resultado = getConnection().prepareCall("{?= call funcGetTripByIdVehicle(?)}");

            resultado.registerOutParameter(1, Types.INTEGER);
            resultado.setString(2, descVehicle);

            resultado.executeUpdate();

            codTrip = resultado.getInt(1);

            return codTrip;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            closeAll();

        }

    }

    /**
     * Retorna o parque de chegada da viagem
     *
     * @param codTrip código da viagem
     * @return id do parque de chegada da viagem
     */
    public String getParkIdEnd(float latitude_end, float longitude_end) {

        try {
            String parkIdStart = null;
            CallableStatement resultado = getConnection().prepareCall("{?= call funcGetParkIdEnd(?,?)}");

            resultado.registerOutParameter(1, Types.VARCHAR);
            resultado.setFloat(2, latitude_end);
            resultado.setFloat(3, longitude_end);

            resultado.executeUpdate();

            parkIdStart = resultado.getString(1);

            return parkIdStart;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            closeAll();

        }
    }

    /**
     * Retorna a longitude do parque final da viagem
     *
     * @param codTrip código da viagem
     * @return longitude do parque final da viagem
     */
    public float getLongitudeEnd(int codTrip) {

        try {
            float longitudeEnd = 0.0F;
            CallableStatement resultado = getConnection().prepareCall("{?= call funcGetLongitudeEnd(?)}");

            resultado.registerOutParameter(1, Types.FLOAT);
            resultado.setInt(2, codTrip);

            resultado.executeUpdate();

            longitudeEnd = resultado.getFloat(1);

            return longitudeEnd;
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0F;
        } finally {
            closeAll();

        }
    }

    /**
     * Retorna a latitude do parque final da viagem
     *
     * @param codTrip código da viagem
     * @return latitude do parque final da viagem
     */
    public float getLatitudeEnd(int codTrip) {

        try {
            float latitudeEnd = 0.0F;
            CallableStatement resultado = getConnection().prepareCall("{?= call funcGetLatitudeEnd(?)}");

            resultado.registerOutParameter(1, Types.FLOAT);
            resultado.setInt(2, codTrip);

            resultado.executeUpdate();

            latitudeEnd = resultado.getFloat(1);

            return latitudeEnd;
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0F;
        } finally {
            closeAll();

        }
    }

    /**
     * Retorna as viagens de um utilizador
     *
     * @param userName
     * @return
     */
    public List<Integer> getTripsByUser(String userName) {
        List<Integer> trips = new ArrayList<>();
        try {

            CallableStatement cs = getConnection().prepareCall("{call procGetTripsByUser(?,?)}");

            cs.setString(1, userName);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.executeUpdate();

            //Recuperar o cursor na forma de um ResultSet
            ResultSet cs1 = (ResultSet) cs.getObject(2);

            while (cs1.next()) {
                int idTrip = cs1.getInt("cod_trip");
                trips.add(idTrip);
            }

            return trips;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            closeAll();

        }
    }

    /**
     * Retorna a descrição do veículo da viagem passada por parâmetro
     *
     * @param codTrip código da viagem
     * @return descrição do veículo da viagem passada por parâmetro
     */
    public String getVehicleDesc(int codTrip) {

        try {
            String vehicleDesc = "";
            CallableStatement resultado = getConnection().prepareCall("{?= call funcGetVehicleDesc(?)}");

            resultado.registerOutParameter(1, Types.VARCHAR);
            resultado.setInt(2, codTrip);

            resultado.executeUpdate();

            vehicleDesc = resultado.getString(1);

            return vehicleDesc;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            closeAll();

        }
    }

    public Trip getTripByCod(int id) {
        CallableStatement callStmt;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getTripByCod(?) }");

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setInt(2, id);

            callStmt.execute();

            ResultSet rSet = (ResultSet) callStmt.getObject(1);
            if (rSet.next()) {
                int codTrip = rSet.getInt(1);
                String email = rSet.getString(2);
                String codVehicle = rSet.getString(3);
                String parkIdStart = rSet.getString(4);
                String startDate;
                if (rSet.getTimestamp(5) == null) {
                    startDate = null;
                } else {
                    startDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(rSet.getTimestamp(5));
                }
                String endDate;
                if (rSet.getTimestamp(6) == null) {
                    endDate = null;
                } else {
                    endDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(rSet.getTimestamp(6));
                }
                double latitudeEnd = rSet.getDouble(7);
                double longitudeEnd = rSet.getDouble(8);
                return new Trip(codTrip, codVehicle, email, parkIdStart, latitudeEnd, longitudeEnd, startDate, endDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
