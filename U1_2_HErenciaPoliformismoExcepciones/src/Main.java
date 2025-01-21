import Exceptions.DegreeNotFoundException;
import Models.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    /**
     *
     * @author Natalia
     *
     */

    public static void main(String[] args) {

        Universidad u=testing();
        ordenar(u);
        LinkedList<Carrera> listCarreras=u.getListaCarreras();
        cambiarPosicionCarreras(listCarreras);
        ArrayList<Edificio> listEdficios=u.getListaEdificios();
        imprimirEdificios(listEdficios);
    }

    private static Universidad testing() {

        Universidad u= new Universidad(0,"politécnica",2000);

        Carrera c1= new Carrera(1,"Jardinería",150);
        Carrera c2= new Carrera(2,"Periodismo",350);

        u.addCarrera(c1);
        u.addCarrera(c2);

        Edificio e1= new Aula(3,"A","c/pepe",19,3);
        Edificio e2= new Taller(4,"B","c/pepa",22,4);

        u.addEdificio(e1);
        u.addEdificio(e2);

        return u;
    }

    private static void ordenar(Universidad u) {
        System.out.println("-Edificios ordenados ascendentemente(con CompareTo):");
        for (Edificio o: u.getListaEdificios()){
            System.out.println(o.toString());
        }

        System.out.println("-Edificios ordenados descendentement");
        Collections.sort(u.getListaEdificios());
        for (Edificio o: u.getListaEdificios()){
            System.out.println(o.toString());
        }
    }

    private static void cambiarPosicionCarreras(LinkedList<Carrera> list) {
        System.out.println();
        System.out.println("-Lista de carreras sin cambiar:");
        for (Carrera o: list){
            System.out.println(o.toString());
        }

        System.out.println("-Lista de carreras cambiando posiciones:");
        Carrera primero=list.getFirst();
        list.removeFirst();
        list.addLast(primero);
        for (Carrera o: list){
            System.out.println(o.toString());
        }
    }

    private static void imprimirEdificios(ArrayList<Edificio> listEdficios) {
        System.out.println();
        System.out.println("Número de edificios de cada tipo: ");
        int numAula=0;
        int numTaller=0;

        for (Edificio o: listEdficios){
            if (o.getClass()== Aula.class){
                numAula++;
            }else{
                numTaller++;
            }
            System.out.println(o.toString());
        }

        System.out.println("Número de de Edificios Aula: "+numAula);
        System.out.println("Número de de Edificios Taller: "+numTaller);

    }


}