package org.example.Controllers;

import org.example.ManagementDB.ManagementDB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;

public class ControllerEmployee {

    public static void SaveCSV(Connection con){
        File file= new File("employees.csv");
        try{
            FileReader fr= new FileReader(file);
            BufferedReader br= new BufferedReader(fr);
            String cad;
            while ((cad=br.readLine())!=null){
                String[] vector=cad.split(";");

                String query="insert into employees values " +
                        "('"+vector[0]+"','"+vector[1]+"','"+vector[2]+"',"+vector[3]+");";
                insertData(con,query);
            }
        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage());
        }
    }

    public static void insertData(Connection con,String query){
        ManagementDB.updateInsertData(con,query);
    }




}
