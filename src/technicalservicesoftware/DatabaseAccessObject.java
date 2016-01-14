/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package technicalservicesoftware;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Gizem
 */

public class DatabaseAccessObject{
    private String driver="org.postgresql.Driver";
    private String baglantiUrl="jdbc:postgresql://localhost:5432/TechnicalServiceSoftwareDB";
    private String kullaniciadi="postgres";
    private String parola="xxxx";
    private Connection baglanti=null;
    private void DbBaglan(){
        try{
            Class.forName(driver);           
            baglanti=DriverManager.getConnection(baglantiUrl,kullaniciadi,parola);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getBaglanti(){
        if (baglanti==null){
            DbBaglan();
        }

        return baglanti;    

    }
   
}

