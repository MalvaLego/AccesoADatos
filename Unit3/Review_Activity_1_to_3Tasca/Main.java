import Models.*;

import java.io.*;
import java.util.*;

public class Main {
    /**
     * Main con métodos
     * @author Natalia Coronado
     * @version 1.0
     * @param
     */
    public static void main(String[] args) throws IOException {

        Library l=testing();
        ordened(l);
        devuelveBook(l);
        devuelveBooks(l);
        devuelveSocios(l);
        devuelveSocio(l);
        fichero(l);
    }

    //Creación de los objetos
    private static Library testing() {
        Library l=new Library("Alejandría","/mi kulo");

        //BOOKS
        ArrayList<String> list1= new ArrayList<>();
        list1.add("fantasia");
        list1.add("novela");
        Book b1=new PhysicalBook(01,"El priorato del naranjo","Samantha",list1,2019);

        ArrayList<String> list2= new ArrayList<>();
        list2.add("misterio");
        list2.add("novela");
        Book b2=new DigitalBook(02,"Muerte en el nilo","Agatha",list2,22);

        ArrayList<String> list3= new ArrayList<>();
        list3.add("ficcion");
        list3.add("novela");
        Book b3=new PhysicalBook(03,"La canción de Aquiles","Madeline",list3,2021);

        ArrayList<String> list4= new ArrayList<>();
        list4.add("ficcion");
        list4.add("aventura");
        Book b4=new DigitalBook(04,"La flor y la muerte","Iria y Selene",list4,34);

        l.addBook(b1);
        l.addBook(b2);
        l.addBook(b3);
        l.addBook(b4);

        //SOCIOS
        Socio s1=new Socio("01B","chiara","oliver",01,77);
        Socio s2=new Socio("02B","violeta","hódar",02,77);
        Socio s3=new Socio("03B","taylor","swift",03,88);
        Socio s4=new Socio("04B","olivia","rodrigo",04,99);

        l.addSocio(s1);
        l.addSocio(s2);
        l.addSocio(s3);
        l.addSocio(s4);

        return l;
    }

    //Ordenar la lista de libros
    public static void ordened(Library l){
        Collections.sort(l.getListaBooks());
    }

    private static void devuelveBook(Library l) {
        System.out.println();
        System.out.println("Un método que dado un ISBN, devuelva el libro asociado: ");
        Book o=l.returnBook(01);
        System.out.println(o.toString());
    }

    private static void devuelveBooks(Library l) {
        System.out.println();
        System.out.println("Un método que devuelva los libros de un género dado: ");
        ArrayList<Book> list=l.returnBooks("ficcion");
        for (Book o: list){
            System.out.println(o.toString());
        }
    }

    private static void devuelveSocios(Library l) {
        System.out.println();
        System.out.println("Un método que devuelve los socios que viven en un código postal dado");
        ArrayList<Socio> list=l.returnSocios(77);
        for (Socio o: list){
            System.out.println(o.toString());
        }
    }

    private static void devuelveSocio(Library l) {
        System.out.println();
        System.out.println("Un método que, dado un NIF, devuelva el socio que tiene ese NIF");
        Socio o=l.returnSocio("03B");
        System.out.println(o.toString());
    }

    // EDICIÓN DE FICHEROS
    private static void fichero(Library l) throws IOException {

        File fichero=nameFichero();
        writeCabeceraFichero(fichero);
        writeFichero(fichero,l);
        ArrayList<String> list=readFichero(fichero);
        printFichero(list);
    }

    private static File nameFichero() throws IOException {
        Scanner sc=new Scanner(System.in);

        int num=0;

        System.out.println("Escriba el nombre para el archivo: ");
        String name=sc.nextLine();

        while (num==0){
        System.out.println("Escriba un número para el nombre: ");
            try {
                num=sc.nextInt();
            }catch (InputMismatchException ex) {
                System.out.println("Tiene que ser un número");
                sc.nextLine();
            }
            catch (Exception e){
                System.out.println("Error");
            }
        }


        File fichero=new File("C:\\Users\\Natalia Coronado\\Documents\\"+name+num+".csv");
        if (fichero.createNewFile()) {
            System.out.println("No se habia creado el fichero, ahora sí");
        }
        return fichero;
    }

    private static void writeCabeceraFichero(File fichero) {
        try (FileWriter fw = new FileWriter(fichero)){
            fw.write("ISBN;TITULO;AUTOR;\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeFichero(File fichero,Library l) {
        try (FileWriter fw = new FileWriter(fichero,true)){
            for (Book o: l.getListaBooks()){
                fw.write(o.getIsbn()+";"+o.getTitulo()+";"+o.getAutor()+";\n");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static ArrayList<String> readFichero(File fichero) throws IOException {
        ArrayList<String> list=new ArrayList<String>();

        FileReader fr= new FileReader(fichero);
        BufferedReader br= new BufferedReader(fr);
        String cad;
        try{
            while ((cad=br.readLine())!=null){
                list.add(cad);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }

    private static void printFichero(ArrayList<String> list) {
        for (String cad: list){
            System.out.println(cad);
        }
    }


}
