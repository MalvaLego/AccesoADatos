package Interfaces;

import Exceptions.DegreeNotFoundException;
import Models.Carrera;

import java.util.ArrayList;
import java.util.LinkedList;

public interface IDegree {

    public LinkedList<Carrera> devuelveCarreras();
    public Carrera devuelveCarrera(String titulo,int creditos) throws DegreeNotFoundException;
}
