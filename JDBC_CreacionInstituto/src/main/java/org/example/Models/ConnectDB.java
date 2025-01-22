package org.example.Models;

import java.sql.*;

public class ConnectDB {
    private String db="instituto";
    //private String port;
    private String jdbc ="jdbc:mysql://localhost:3306/"+db;
    private String username="root" ;
    private String password="root" ;
    private Connection con;


    public Connection connectDB() {
        try{
            con = DriverManager.getConnection(jdbc,username,password);
            System.out.println("Conexion exitosa");

        }catch (SQLException ex){
            System.out.println("Error "+ex.getMessage());
        }
        return con;
    }
    public void closeConnection() {
        try{
            con.close();
            System.out.println("Conexion Cerrada");

        }catch (SQLException ex){
            System.out.println("Error "+ex.getMessage());
        }

    }

    public void creacionTabla(String sqlQuery) {

        try{
            Statement sta= con.createStatement();
            sta.executeUpdate(sqlQuery);
            System.out.println("Table created.");
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void insertarTabla(String sqlQuery) {
        try{
            Statement sta= con.createStatement();
            sta.executeUpdate(sqlQuery);
            System.out.println("Datos Insertados");
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}
