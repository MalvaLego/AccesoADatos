package org.example.ManagementDB;

import java.sql.*;

public class ConnectDB {
    private String db="gestion_pub";
    private String jdbc="jdbc:mysql://localhost:3306/"+db;
    private String user="root";
    private String password="root";
    private Connection con;

    public Connection openConnect(){
        try{
            con=DriverManager.getConnection(jdbc,user,password);
            System.out.println("Conexión exitosa");
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
        return con;
    }

    public void closeConnect(){
        try{
            con.close();
            System.out.println("Conexión cerrada");
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }


}
