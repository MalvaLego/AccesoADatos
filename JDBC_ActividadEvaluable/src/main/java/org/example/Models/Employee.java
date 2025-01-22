package org.example.Models;

public class Employee {
    private String dni_empleado;
    private String nombre;
    private String domicilio;
    private int edad;

    public Employee(String dni_empleado, String nombre, String domicilio, int edad) {
        this.dni_empleado = dni_empleado;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.edad = edad;
    }

    public String getDni_empleado() {
        return dni_empleado;
    }

    public void setDni_empleado(String dni_empleado) {
        this.dni_empleado = dni_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "dni_empleado='" + dni_empleado + '\'' +
                ", nombre='" + nombre + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", edad=" + edad +
                '}';
    }
}
