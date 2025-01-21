package Interfaces;

import Exceptions.BuildingNotFoundException;
import Models.Edificio;

import java.util.ArrayList;

public interface IBuilding {

    public Edificio devuelveEdificio(int codigo,String nombre,String direccion) throws BuildingNotFoundException;
    public ArrayList<Edificio> devuelveEdificios(String direccion);
}
