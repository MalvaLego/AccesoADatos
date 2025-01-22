package org.example.Controllers;

import org.example.Models.Owner;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class ControllerPubs {


    public static ResultSet getPubsInfo(Connection con,String dato){
        String query="select sum(stocks.cantidad) as 'Suma Total'\n" +
                "from pubs\n" +
                "join stocks on stocks.cod_pub=pubs.cod_pub\n" +
                "where pubs.cod_pub="+dato+" group by pubs.cod_pub;\n";

        ResultSet config=null;
        try{
            Statement sta=con.createStatement();
            config=sta.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Error:"+e.getMessage());
        }
        return config;
    }

    public static void showPubsInfo(ResultSet config){
        try{
            System.out.printf("%-10s\n","Suma Total");
            while(config.next()){
                int suma= config.getInt("Suma Total");

                System.out.printf("%-10s\n",suma);
            }
        } catch (SQLException e) {
            System.out.println("Error:"+e.getMessage());
        }

    }


}
