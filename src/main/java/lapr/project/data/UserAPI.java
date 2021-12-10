package lapr.project.data;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;
import lapr.project.model.User;
import oracle.jdbc.OracleTypes;

/**
 * @author Jorge Pessoa
 */
public class UserAPI extends DataHandler {

    public UserAPI() {
        super();
    }
    
        public UserAPI(String jdbcUrl, String username, String password) {
        super(jdbcUrl, username, password);
    }

    /**
     * Queries the database directly and returns a specific user by email.
     */
    public User getUserByEmail(String id) {
        CallableStatement callStmt;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getUserByEmail(?) }");

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setString(2, id);

            callStmt.execute();

            ResultSet rSet = (ResultSet) callStmt.getObject(1);
            if (rSet.next()) {
                String email = rSet.getString(1);
                String pass = rSet.getString(2);
                int points = rSet.getInt(3);
                int visa = rSet.getInt(4);
                String username = rSet.getString(5);
                int height = rSet.getInt(6);
                int weight = rSet.getInt(7);
                String gender = rSet.getString(8);
                double avgSpeed = rSet.getDouble(9);
                return new User(email, username, height, weight, points, gender, avgSpeed, visa, pass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("No User with email: " + id);
    }

    /**
     * Queries the database directly and returns a specific user by username.
     */
    public User getUserByUsername(String id) {
        CallableStatement callStmt;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getUserByUsername(?) }");

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setString(2, id);

            callStmt.execute();

            ResultSet rSet = (ResultSet) callStmt.getObject(1);
            if (rSet.next()) {
                String email = rSet.getString(1);
                String pass = rSet.getString(2);
                int points = rSet.getInt(3);
                int visa = rSet.getInt(4);
                String username = rSet.getString(5);
                int height = rSet.getInt(6);
                int weight = rSet.getInt(7);
                String gender = rSet.getString(8);
                double avgSpeed = rSet.getDouble(9);
                return new User(email, username, height, weight, points, gender, avgSpeed, visa, pass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param username nome do novo utilizador
     * @param email email do novo utilizador
     * @param height altura do novo utilizador
     * @param weight peso do novo utilizador
     * @param averageSpeed média de velocidade
     * @param visa número de cartão visa
     */
    public int createUser(String username, String email, int height, int weight, double averageSpeed, int visa, String gender, String pass) {
        try {
            
            openConnection();

            CallableStatement callStmt = getConnection().prepareCall("{ call procAddUser(?,?,?,?,?,?,?,?) }");
            
            callStmt.setString(1, email);
            callStmt.setInt(2, visa);
            callStmt.setString(3, username);
            callStmt.setInt(4, height);
            callStmt.setInt(5, weight);
            callStmt.setDouble(6, averageSpeed);
            callStmt.setString(7, gender);
            callStmt.setString(8, pass);
            
            callStmt.executeUpdate();

            closeAll();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            closeAll();
        }
    }
    
    public boolean addUser(List<String[]> place) {
        try {
            openConnection();

            getConnection().setAutoCommit(false);

            Statement stmt = getConnection().createStatement();

            for (String[] i : place) {
                String insert = String.format("INSERT INTO Clients(username,email,height,weight,avg_cycling_spd,visa,gender,pass) "
                        + "VALUES('%s','%s',%s,%s,%s,%s,'%s','%s')",
                        i[0], i[1], i[2], i[3], i[4], i[5], i[6], i[7]);

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
     * Adiciona os utilizadores presentes em users à base de dadaos
     *
     * @param users utilizadores a adicionar à base de dados com as respetivas
     * informações acerca dos mesmos
     * @return número de utilizadores adicionados à base de dados
     */
    public int createUsers(List<User> users) {
        int i = 0;
        for (User user : users) {
            createUser(user.getUsername(), user.getEmail(), user.getHeight(), user.getWeight(), user.getAverageSpeed(), user.getVisaCardNumber(), user.getGender(), user.getPassword());
            i++;
        }
        return i;
    }
    
    /**
     * Adiciona os pontos ao cliente conforme os critérios de atribuição dos mesmos
     * @param clientEmail email do cliente
     * @param elevDifference diferença de elevação dos parques
     * @param tripTime tempo de duração da viagem, em minutos
     */
    public void addPoints (String clientEmail,Integer elevDifference, Double tripTime){
        try {
            
            Integer maxDif = 50;
            Integer minDif = 25;
            Integer maxTime = 15;
            
            if (elevDifference > maxDif){
        
                CallableStatement resultado1 = getConnection().prepareCall("{call addFifteenPoints(?)");
            
                 resultado1.setString(1, clientEmail);
                 resultado1.executeUpdate();
                 
            
            } else if (elevDifference >= minDif || elevDifference <= maxDif){
                
                 CallableStatement resultado2 = getConnection().prepareCall("{call addFivePoints(?)");
            
                 resultado2.setString(1, clientEmail);
                 resultado2.executeUpdate();
            }   
            
            if (tripTime < maxTime){
                CallableStatement resultado2 = getConnection().prepareCall("{call addFivePoints(?)");
            
                 resultado2.setString(1, clientEmail);
                 resultado2.executeUpdate();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            closeAll();        
        }
        
    }
    
    public int getUserPoints(String userEmail) {
       
        try {
            int userPoints = 0;
            CallableStatement resultado = getConnection().prepareCall("{?= call funcGetUserPoints(?)}");

            resultado.registerOutParameter(1, Types.INTEGER);
            resultado.setString(2, userEmail);

            resultado.executeUpdate();

            userPoints = resultado.getInt(1);

            return userPoints;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            closeAll();

        }
    }
}
