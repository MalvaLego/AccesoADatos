package Models;

public class Aula extends Edificio{
    private int numeroAulas;

    public Aula(int codigo, String nombre, String direccion, int numeroAlumnos,int numeroAulas) {
        super(codigo, nombre, direccion, numeroAlumnos);
        this.numeroAulas=numeroAulas;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+getClass()+"{" +
                "Codigo=" + getCodigo() +
                " Nombre=" + getNombre() +
                " Dirección=" + getDireccion() +
                " numeroAlumnos=" + getNumeroAlumnos() +
                " numeroAulas=" + numeroAulas +
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
