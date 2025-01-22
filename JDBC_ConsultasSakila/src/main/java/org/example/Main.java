package org.example;

import org.example.Models.*;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        testing();
    }

    private static void testing() {
        ConnectDB controllerDB = new ConnectDB();
        Connection con = controllerDB.connectDB();

        metodo1(con);

        controllerDB.closeConnection();

    }

    private static void metodo1(Connection con) {
        ControllerFilmFirst controllerCity = new ControllerFilmFirst();

        //controllerCity.showCityInfo(controllerCity.getOneHundredCities(con));
    }
}