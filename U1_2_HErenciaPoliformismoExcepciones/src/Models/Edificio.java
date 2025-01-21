package Models;

public abstract class Edificio implements Comparable<Edificio> {
    private int codigo;
    private String nombre;
    private String direccion;
    private int numeroAlumnos;

    public Edificio(int codigo, String nombre, String direccion, int numeroAlumnos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.numeroAlumnos = numeroAlumnos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumeroAlumnos() {
        return numeroAlumnos;
    }

    public void setNumeroAlumnos(int numeroAlumnos) {
        this.numeroAlumnos = numeroAlumnos;
    }

    @Override
    public int compareTo(Edificio o) {
        int nombreDiff= this.nombre.compareToIgnoreCase(o.nombre);
        int direccionDiff= this.direccion.compareToIgnoreCase(o.direccion);

        if (nombreDiff!=0){
            return nombreDiff;
        }
        if (direccionDiff!=0){
            return direccionDiff;
        }
        return this.numeroAlumnos-o.numeroAlumnos;

    }

    @Override
    public abstract String toString();

    public abstract boolean canHoldStudents(int numeroAlumnos);


}
