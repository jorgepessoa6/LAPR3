package lapr.project.data;

import java.sql.CallableStatement;
import java.sql.SQLException;

public class RequestTripAPI extends DataHandler {

    public void requestTrip(String emailUser, boolean scooter, String desc, int idPark){
        requestTrip(emailUser, scooter, desc, idPark, 0f);
    }

    public int requestTrip(String emailUser, boolean scooter, String desc, int idPark, float dist){
        int idVehicle = 0;
        int vehicle = -1;
        if (scooter) {
            vehicle = 1;
        }
        if (dist < 0) {
            dist *= -1;
        }
        try {
            openConnection();
            CallableStatement callStmt = getConnection().prepareCall("{? = call funcrequesttrip(?,?,?,?,?) }");

            callStmt.setString(1, emailUser.trim());
            callStmt.setInt(2, vehicle);
            callStmt.setString(3, desc);
            callStmt.setInt(4, idPark);
            callStmt.setFloat(5, dist);

            callStmt.execute();

            idVehicle = callStmt.getInt(1);

            callStmt.close();
            closeAll();
            
            return idVehicle;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return -1;
    }
}
