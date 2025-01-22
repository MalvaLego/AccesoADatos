package org.example;

import org.example.Models.ConnectDB;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        testing();
    }

    private static void testing() {
        ConnectDB controllerDB = new ConnectDB();
        Connection con = controllerDB.connectDB();

        //crearTabla(con,controllerDB);
        crearTablaStudents(controllerDB);
        crearTablaProfesor(controllerDB);
        crearTablaAsignatura(controllerDB);
        crearTablaMatricula(controllerDB);

        addStudents(controllerDB);
        addProfesor(controllerDB);
        addAsignatura(controllerDB);
        addMatricula(controllerDB);

        controllerDB.closeConnection();
    }

    private static void crearTablaStudents(ConnectDB controllerDB) {
        String sqlQuery1="create table if not exists students(" +
                "id_alumno int PRIMARY KEY auto_increment, " +
                "nombre VARCHAR(30) not null, " +
                "apellidos VARCHAR(30) not null, " +
                "fecha_nac DATE not null" +
                ");";
        controllerDB.creacionTabla(sqlQuery1);
    }

    private static void crearTablaProfesor(ConnectDB controllerDB) {
        String sqlQuery1="create table if not exists profesor(" +
                "id_professor int PRIMARY KEY auto_increment, " +
                "nombre VARCHAR(30) not null, " +
                "apellidos VARCHAR(30) not null, " +
                "fecha_nac DATE not null" +
                ");";
        controllerDB.creacionTabla(sqlQuery1);
    }

    private static void crearTablaAsignatura(ConnectDB controllerDB) {
        String sqlQuery1="create table if not exists asignatura(" +
                "id_asignatura int PRIMARY KEY auto_increment, " +
                "nombre VARCHAR(30) not null, " +
                "id_professor int not null, " +
                "FOREIGN KEY id_professor(id_professor) REFERENCES profesor(id_professor)" +
                ");";
        controllerDB.creacionTabla(sqlQuery1);
    }

    private static void crearTablaMatricula(ConnectDB controllerDB) {
        String sqlQuery1="create table if not exists matricula(" +
                "id_professor int not null," +
                "id_alumno int not null," +
                "FOREIGN KEY id_alumno(id_alumno) REFERENCES students(id_alumno), " +
                "FOREIGN KEY id_professor(id_professor) REFERENCES profesor(id_professor), " +
                "fecha VARCHAR(4) not null, " +
                "nota int not null" +
                ");";
        controllerDB.creacionTabla(sqlQuery1);
    }

    //------------------------------------------------------------------------------------------------

    private static void addStudents(ConnectDB controllerDB) {
        String sqlQuery1="insert into students (nombre, apellidos, fecha_nac) values" +
                "('taylor', 'swift', '13/12/09')," +
                "('chiara', 'oliver', '10/03/04');";

        controllerDB.insertarTabla(sqlQuery1);
    }

    private static void addAsignatura(ConnectDB controllerDB) {
        String sqlQuery1="insert into asignatura (nombre,id_professor) values" +
                "('mates',1)," +
                "('mates',2);";

        controllerDB.insertarTabla(sqlQuery1);
    }

    private static void addMatricula(ConnectDB controllerDB) {
        String sqlQuery1="insert into matricula values" +
                "(1, 1, '2027', 4)," +
                "(2, 2, '2026', 9);";

        controllerDB.insertarTabla(sqlQuery1);
    }

    private static void addProfesor(ConnectDB controllerDB) {
        String sqlQuery1="insert into profesor (nombre, apellidos, fecha_nac) values" +
                "('Gandalf', 'el Blanco', '23/02/01')," +
                "('Morfeo', 'Neo', '07/08/03')" +
                "('Yennefer', 'Neo', '07/08/03');";

        controllerDB.insertarTabla(sqlQuery1);
    }

}