package org.example.Models;

import java.sql.*;

public class ControllerFilmFirst {

    public ResultSet getFilmInfo(Connection con){
        String query = "SELECT * FROM city LIMIT 100";
        ResultSet config = null;
        try{
            Statement stmt = con.createStatement() ;
            config = stmt.executeQuery(query);
            System.out.println("Consulta "+ query + " ejecutada correctamente.");

        }catch (SQLException ex){
            System.out.println("Error "+ex.getMessage());
        }
        return config;
    }
    public void showFilmInfo(ResultSet config) {
        try{
            System.out.printf("%-5s %-25s %-10s %-20s\n", "ID", "NAME", "COUNTRY ID", "LAST UPDATE");
            while(config.next()){
                int id = config.getInt("city_id");
                String name = config.getString("city");
                int country_id = config.getInt("country_id");
                Timestamp last_update = config.getTimestamp("last_update");

                System.out.printf("%-5s %-25s %-10s %-20s\n", id, name, country_id, last_update);
            }
        }catch (SQLException ex){
            System.out.println("Error "+ex.getMessage());
        }
    }
}
