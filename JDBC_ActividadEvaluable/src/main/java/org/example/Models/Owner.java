package org.example.Models;

public class Owner {
    private String dni_titular;
    private String nombre;
    private String domicilio;
    private int cod_pub;

    public Owner(String dni_titular, String nombre, String domicilio, int cod_pub) {
        this.dni_titular = dni_titular;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.cod_pub = cod_pub;
    }

    public String getDni_titular() {
        return dni_titular;
    }

    public void setDni_titular(String dni_titular) {
        this.dni_titular = dni_titular;
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

    public int getCod_pub() {
        return cod_pub;
    }

    public void setCod_pub(int cod_pub) {
        this.cod_pub = cod_pub;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "dni_titular='" + dni_titular + '\'' +
                ", nombre='" + nombre + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", cod_pub=" + cod_pub +
                '}';
    }
}
