package org.example.Models;

import java.sql.*;

public class ConnectDB {
    private String db="sakila";
    //private String port;
    private String jdbc ="jdbc:mysql://localhost:3306/"+db;
    private String username ;
    private String password ;
    private Connection con;


    public  Connection connectDB() {
        try{
            con = DriverManager.getConnection(jdbc,"root","root");
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




}
