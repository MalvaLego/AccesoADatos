package org.example.DB;

public class CiclistaEntity {
    private int dorsal;
    private Integer edad;
    private String nombre;
    private String nomeq;

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNomeq() {
        return nomeq;
    }

    public void setNomeq(String nomeq) {
        this.nomeq = nomeq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CiclistaEntity that = (CiclistaEntity) o;

        if (dorsal != that.dorsal) return false;
        if (edad != null ? !edad.equals(that.edad) : that.edad != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (nomeq != null ? !nomeq.equals(that.nomeq) : that.nomeq != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dorsal;
        result = 31 * result + (edad != null ? edad.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (nomeq != null ? nomeq.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "CiclistaEntity{" +
                "dorsal=" + dorsal +
                ", edad=" + edad +
                ", nombre='" + nombre + '\'' +
                ", nomeq='" + nomeq + '\'' +
                '}'+"\n";
    }
}
