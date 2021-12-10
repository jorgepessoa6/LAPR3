/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lapr.project.data.InvoiceAPI;

/**
 *
 * @author Gabriel Vieira
 */
public class Invoice {

    public Invoice() {
    }

    /**
     * Writes invoice
     *
     * @param outputFileName name for output file
     * @param mes month
     * @param username username of user
     */
    public void writeInvoice(String username, String mes, String outputFileName) {
        InvoiceAPI in = new InvoiceAPI();
        List<String> listInvoice = new ArrayList<>();
        listInvoice = in.getInvoice(username, mes);
        FileWriter fileWriter = null;
        try {
            String FILE_HEADER = "vehicle description;vehicle unlock time;"
                    + "vehicle lock time;origin park latitude;"
                    + "origin park longitude;destination park latitude;"
                    + "destination park longitude;total time spent in seconds;"
                    + "charged value";
            String COMMA_DELIMITER = ";";
            String NEW_LINE_SEPARATOR = "\n";
            fileWriter = new FileWriter(outputFileName);
            fileWriter.append(listInvoice.get(0));
            fileWriter.append(NEW_LINE_SEPARATOR);
            fileWriter.append("Previous points:" + listInvoice.get(1));
            fileWriter.append(NEW_LINE_SEPARATOR);
            fileWriter.append("Earned points:" + listInvoice.get(2));
            fileWriter.append(NEW_LINE_SEPARATOR);
            fileWriter.append("Discounted points:" + listInvoice.get(3));
            fileWriter.append(NEW_LINE_SEPARATOR);
            fileWriter.append("Actual points:" + listInvoice.get(4));
            fileWriter.append(NEW_LINE_SEPARATOR);
            fileWriter.append("Charged Value:" + listInvoice.get(5));
            fileWriter.append(NEW_LINE_SEPARATOR);
            fileWriter.append(FILE_HEADER.toString());
            fileWriter.append(NEW_LINE_SEPARATOR);
            fileWriter.append(listInvoice.get(6));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(listInvoice.get(7));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(listInvoice.get(8));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(listInvoice.get(9));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(listInvoice.get(10));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(listInvoice.get(11));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(listInvoice.get(12));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(listInvoice.get(13));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(listInvoice.get(14));
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
