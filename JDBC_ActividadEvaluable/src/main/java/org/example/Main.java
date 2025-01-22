package org.example;

import org.example.Controllers.*;
import org.example.ManagementDB.ConnectDB;
import org.example.ManagementDB.ManagementDB;
import org.example.Models.Employee;
import org.example.Models.Owner;

import java.sql.*;
import java.util.LinkedList;

public class Main {
    /**
     * @author Natalia
     * @param args
     */
    public static void main(String[] args) {

        testing();
    }

    private static void testing() {
        ConnectDB connectDB=new ConnectDB();
        Connection con=connectDB.openConnect();

        //Apartado F
        Employee e= new Employee("03162314K","Natalia","Casa",19);

        apartadoA(con);
        apartadoB(con);
        apartadoC(con);
        apartadoD(con);
        apartadoE(con,e);


        connectDB.closeConnect();
    }

    private static void apartadoA(Connection con) {
        ControllerCities.SaveCSV(con);
        ControllerEmployee.SaveCSV(con);
    }

    /**
     * Devuelve una lista con el contenido de la tabla owners
     * @param con
     */
    private static void apartadoB(Connection con) {
        LinkedList<Owner>lista =ControllerOwners.showOwnerInfo(ControllerOwners.getOwnersInfo(con));
    }

    /**
     * Recibe un parámetro y devuelve la suma total de las cantidades de los árticulos del parámetro
     * @param con
     */
    private static void apartadoC(Connection con) {
        String dato="2";
        ControllerPubs.showPubsInfo(ControllerPubs.getPubsInfo(con,dato));
    }

    /**
     * Recibe un parámetro y devuelve nombres de la información de ese parámetro
     * @param con
     */
    private static void apartadoD(Connection con) {
        String dato="1";
        ControllerCities.showCitiesInfo(ControllerCities.getCitiesInfo(con,dato));
    }

    private static void apartadoE(Connection con,Employee e) {
        String query="insert into employees values" +
                "('"+e.getDni_empleado()+"','"+e.getNombre()+"','"+e.getDomicilio()+"',"+e.getEdad()+");";
        ManagementDB.updateInsertData(con,query);
    }



}