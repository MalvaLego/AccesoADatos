package Models;

public class Taller extends Edificio{
    private int numeroLaboratorios;

    public Taller(int codigo, String nombre, String direccion, int numeroAlumnos,int numeroLaboratorios) {
        super(codigo, nombre, direccion, numeroAlumnos);
        this.numeroLaboratorios=numeroLaboratorios;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+" "+getClass()+"{" +
                "Codigo=" + getCodigo() +
                " Nombre=" + getNombre() +
                " Dirección=" + getDireccion() +
                " numeroAlumnos=" + getNumeroAlumnos() +
                " numeroLaboratorios=" + numeroLaboratorios +
                '}';
    }

    @Override
    public boolean canHoldStudents(int numeroAlumnos) {
        if (numeroAlumnos>=0){
            return true;
        }
        return false;
    }


}
