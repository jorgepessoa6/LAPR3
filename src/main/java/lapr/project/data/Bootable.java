/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.data;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.*;
import java.util.logging.Logger;

/**
 *
 * @author rickropes
 */
public class Bootable extends DataHandler {

    public void createTables(String txt) throws IOException {
        try {
            Logger.getLogger("\nEstabelecer a ligação à BD...");
            openConnection();
            Connection con = getConnection();
            Logger.getLogger("\t... Ligação obtida.");

            Reader r = new FileReader(txt);
            ScriptRunner sr = new ScriptRunner(con,true,false);
            sr.runScript(r);
            r.close();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
    
     
}
    
 
