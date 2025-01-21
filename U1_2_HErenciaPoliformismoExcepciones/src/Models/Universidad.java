package Models;

import Exceptions.BuildingNotFoundException;
import Exceptions.DegreeNotFoundException;
import Interfaces.IBuilding;
import Interfaces.IDegree;

import java.util.*;

public class Universidad implements IBuilding, IDegree {
    private int id;
    private String nombre;
    private int anyoFundacion;
    ArrayList<Edificio> listaEdificios=new ArrayList<Edificio>();
    LinkedList<Carrera> listaCarreras= new LinkedList<Carrera>();

    public Universidad(int id, String nombre, int anyoFundacion) {
        this.id = id;
        this.nombre = nombre;
        this.anyoFundacion = anyoFundacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnyoFundacion() {
        return anyoFundacion;
    }

    public void setAnyoFundacion(int anyoFundacion) {
        this.anyoFundacion = anyoFundacion;
    }

    public ArrayList<Edificio> getListaEdificios() {
        return listaEdificios;
    }

    public LinkedList<Carrera> getListaCarreras() {
        return listaCarreras;
    }

    public void addEdificio(Edificio o){
        listaEdificios.add(o);
    }
    public void addCarrera(Carrera o){
        listaCarreras.add(o);
    }

    @Override
    public String toString() {
        return getClass()+"{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", anyoFundacion=" + anyoFundacion +
                ", listaEdificios=" + listaEdificios +
                ", listaCarreras=" + listaCarreras +
                '}';
    }

    /**
     *
     * @param codigo
     * @param nombre
     * @param direccion
     * @return
     * @throws BuildingNotFoundException
     */
    @Override
    public Edificio devuelveEdificio(int codigo, String nombre, String direccion) throws BuildingNotFoundException {
        for (Edificio e: getListaEdificios()){
            if ((e.getCodigo()==codigo) &&
               (e.getNombre().equalsIgnoreCase(nombre)) &&
               (e.getDireccion().equalsIgnoreCase(direccion))){
               return e;
            }
        }
        throw new BuildingNotFoundException("ERROR! No se ha encontrado el edificio con esos datos");
    }

    /**
     *
     * @param direccion
     * @return
     */
    @Override
    public ArrayList<Edificio> devuelveEdificios(String direccion) {
        ArrayList<Edificio> list= new ArrayList<Edificio>();

        for (Edificio e: getListaEdificios()){
            if (e.getDireccion().equalsIgnoreCase(direccion)){
                list.add(e);
            }
        }
        return list;
    }

    /**
     *
     * @return
     */
    @Override
    public LinkedList<Carrera> devuelveCarreras() {
        LinkedList<Carrera> list= new LinkedList<>();

        for (Carrera o: getListaCarreras()){
            if (o.getCreditos()>200){
                list.add(o);
            }
        }
        return list;
    }

    /**
     *
     * @param titulo
     * @param creditos
     * @return
     * @throws DegreeNotFoundException
     */
    @Override
    public Carrera devuelveCarrera(String titulo, int creditos) throws DegreeNotFoundException {
        for (Carrera o: getListaCarreras()){
            if ((o.getCreditos()==creditos) &&
                    (o.getTitulo().equalsIgnoreCase(titulo)) ){
                return o;
            }
        }
        throw new DegreeNotFoundException("ERROR! No se ha encontrado la carrera con esos datos");
    }
}
