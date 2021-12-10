/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.data;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Gabriel Vieira
 */
public class InvoiceAPI extends DataHandler {

    public InvoiceAPI() {
    }

    public InvoiceAPI(String jdbcUrl, String username, String password) {
        super(jdbcUrl, username, password);
    }

    /**
     * Returns invoice value
     *
     * @param username username of user
     * @param mes month
     * @return invoice value
     */
    public float getValue(String username, String mes) {
        float valor = 0;
        try {
            CallableStatement result1 = getConnection().prepareCall("{? = call funcgetvalue(?,?)}");
            result1.registerOutParameter(1, OracleTypes.FLOAT);
            result1.setString(2, username);
            result1.setString(3, mes);
            result1.executeQuery();
            float resultado1 = result1.getFloat(1);
            valor = resultado1;
            result1.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return valor;
    }

    /**
     * Return invoice
     *
     * @param username username of user
     * @param mes month
     * @return invoice
     */
    public List<String> getInvoice(String username, String mes) {
        List<String> list = new ArrayList<>();
        try {
            list.add(username);

            CallableStatement result1 = getConnection().prepareCall("{? = call funcgetpreviouspoints(?,?)}");
            result1.registerOutParameter(1, OracleTypes.INTEGER);
            result1.setString(2, username);
            result1.setString(3, mes);
            result1.executeQuery();
            int resultado1 = result1.getInt(1);
            list.add(String.valueOf(resultado1));
            result1.close();
            CallableStatement result2 = getConnection().prepareCall("{? = call funcgetearnedpoints(?,?)}");
            result2.registerOutParameter(1, OracleTypes.INTEGER);
            result2.setString(2, username);
            result2.setString(3, mes);
            result2.executeQuery();
            int resultado2 = result2.getInt(1);
            list.add(String.valueOf(resultado2));
            result2.close();
            CallableStatement result3 = getConnection().prepareCall("{? = call funcgetinvoice(?,?,?)}");
            result3.registerOutParameter(1, OracleTypes.INTEGER);
            result3.setString(2, username);
            result3.setString(3, mes);
            result3.registerOutParameter(4, OracleTypes.CURSOR);
            result3.executeQuery();
            int resultado3 = result3.getInt(1);
            ResultSet resultado4 = (ResultSet) result3.getObject(4);
            list.add(String.valueOf(resultado3));
            while (resultado4.next()) {
                list.add(String.valueOf(resultado4.getString("points")));
                list.add(String.valueOf(resultado4.getString(2)));
            }
            resultado4.close();
            result3.close();
            CallableStatement result4 = getConnection().prepareCall("{call procgetinvoice(?,?,?)}");
            result4.registerOutParameter(1, OracleTypes.CURSOR);
            result4.setString(2, mes);
            result4.setString(3, username);
            result4.executeQuery();
            ResultSet resultado5 = (ResultSet) result4.getObject(1);
            while (resultado5.next()) {
                list.add(String.valueOf(resultado5.getString("vehicle_desc")));
                list.add(String.valueOf(resultado5.getString("start_date")));
                list.add(String.valueOf(resultado5.getString("end_date")));
                list.add(String.valueOf(resultado5.getString("latitude")));
                list.add(String.valueOf(resultado5.getString("longitude")));
                list.add(String.valueOf(resultado5.getString("latitude_end")));
                list.add(String.valueOf(resultado5.getString("longitude_end")));
            }
            resultado5.close();
            result4.close();
            CallableStatement result5 = getConnection().prepareCall("{call procgettime(?,?,?)}");
            result5.registerOutParameter(1, OracleTypes.CURSOR);
            result5.setString(2, username);
            result5.setString(3, mes);
            result5.executeQuery();
            ResultSet resultado6 = (ResultSet) result5.getObject(1);
            while (resultado6.next()) {
                list.add(String.valueOf(resultado6.getString(1)));
            }
            resultado6.close();
            result5.close();
            list.add(String.valueOf(getValue(username, mes)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Retorna o código da fatura da viagem passada por parâmetro
     *
     * @param idTrip código da viagem
     * @return código da fatura da viagem passada por parâmetro
     */
    public Integer getInvoiceByTripId(Integer idTrip) {

        try {
            int codInvoice = 0;
            CallableStatement resultado = getConnection().prepareCall("{?= call funcGetInvoiceByTripId(?)}");

            resultado.registerOutParameter(1, Types.INTEGER);
            resultado.setInt(2, idTrip);

            resultado.executeUpdate();

            codInvoice = resultado.getInt(1);

            return codInvoice;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            closeAll();

        }
    }

    public void setInvoiceCost(Integer cod_invoice, double valueToPay) {
        try {

            CallableStatement resultado1 = getConnection().prepareCall("{call addInvoiceValue(?,?)");

            resultado1.setInt(1, cod_invoice);
            resultado1.setDouble(2, valueToPay);
            resultado1.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return;
        } finally {
            closeAll();

        }
    }

}
