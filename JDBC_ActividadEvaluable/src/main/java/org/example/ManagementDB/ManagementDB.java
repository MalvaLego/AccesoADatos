package org.example.ManagementDB;

import java.sql.*;

public class ManagementDB {


    public static void updateInsertData(Connection con, String query){
        try{
            Statement sta=con.createStatement();
            sta.executeUpdate(query);
            System.out.println("Datos insertados");
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }





}
