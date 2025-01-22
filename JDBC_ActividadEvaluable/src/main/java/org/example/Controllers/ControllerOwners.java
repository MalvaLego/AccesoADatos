package org.example.Controllers;

import org.example.Models.Owner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class ControllerOwners {

    public static ResultSet getOwnersInfo(Connection con){
        String query="select * from owners";
        ResultSet config=null;
        try{
            Statement sta=con.createStatement();
            config=sta.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Error:"+e.getMessage());
        }
        return config;
    }

    public static LinkedList<Owner> showOwnerInfo(ResultSet config){
        LinkedList<Owner> lista= new LinkedList<>();

        try{
            while(config.next()){
                String dni_titular=config.getString("dni_titular");
                String nombre=config.getString("nombre");
                String domicilio=config.getString("domicilio");
                int cod_pub= config.getInt("cod_pub");

                Owner o= new Owner(dni_titular,nombre,domicilio,cod_pub);
                lista.add(o);
            }


        } catch (SQLException e) {
            System.out.println("Error:"+e.getMessage());
        }


        return lista;
    }
}
