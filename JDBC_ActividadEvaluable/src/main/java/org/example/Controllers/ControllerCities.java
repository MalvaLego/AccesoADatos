package org.example.Controllers;

import org.example.Exceptions.CodLocalidadNotFound;
import org.example.ManagementDB.ManagementDB;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControllerCities {



    public static void SaveCSV(Connection con){
        File file= new File("cities.csv");
        try{
            FileReader fr= new FileReader(file);
            BufferedReader br= new BufferedReader(fr);
            String cad;
            while ((cad=br.readLine())!=null){
                String[] vector=cad.split(";");

                String query="insert into cities values " +
                        "("+vector[0]+",'"+vector[1]+"','"+vector[2]+"');";
                insertData(con,query);
            }
        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage());
        }
    }

    public static void insertData(Connection con,String query){
        ManagementDB.updateInsertData(con,query);
    }


    public static ResultSet getCitiesInfo(Connection con, String dato){
        String query="select pubs.nombre as 'NombrePub',owners.nombre as 'NombreOwner',cities.nombre as 'NombreLocalidad' from pubs\n" +
                "join cities on pubs.cod_localidad=cities.cod_localidad\n" +
                "join owners on pubs.cod_pub=owners.cod_pub\n" +
                "where cities.cod_localidad="+dato;

        ResultSet config=null;
        try{
            Statement sta=con.createStatement();
            config=sta.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Error:"+e.getMessage());
        }
        return config;
    }

    public static void showCitiesInfo(ResultSet config) throws CodLocalidadNotFound {
        try{
            System.out.printf("%-30s %-30s %-30s\n","NombrePub","NombreOwner","NombreLocalidad");
            while(config.next()){
                String NombrePub=config.getString("NombrePub");
                String NombreOwner=config.getString("NombreOwner");
                String NombreLocalidad=config.getString("NombreLocalidad");

                System.out.printf("%-30s %-30s %-30s\n",NombrePub,NombreOwner,NombreLocalidad);
            }
        } catch (SQLException e) {
            System.out.println("Error:"+e.getMessage());
        } catch (Exception e) {
            throw new CodLocalidadNotFound("Código localida no encontrado");
        }
    }


}
