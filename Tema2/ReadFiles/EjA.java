import java.io.*;

public class EjA {
    public static void main(String[] args) throws IOException {
        /*
        *Metodo que recibe una ruta completa, valida si es un fichero, comprueba que la extensión
        *sea .txt, .odt o .doc, y muestra el contenido del fichero utilizando FileReader.
        *Si no es un fichero de texto, debe mostrar un mensaje indicándolo.
         * */
       String rutaCompleta="//Usuarios/Natalia Coronado/Documentos/fichero1.txt";
       nsQueHace(rutaCompleta);
    }

    public static void nsQueHace(String rutaCompleta) throws IOException {
        File f= new File(rutaCompleta);

        String[] array =f.getName().split("\\.");
        System.out.println(array[0]);
        System.out.println(array[1]);
        //if (f.isFile()){
            if (array[1].equals("txt")){
                FileReader fr=new FileReader(f);
                BufferedReader br= new BufferedReader(fr);
                String cad;
                while ((cad=br.readLine())!=null){
                    System.out.println(cad);
                }
            }else{
                System.out.println("No es un fichero de texto");
            }
        //}else{
        //    System.out.println("no es un fichero");
        //}
        
    }
    
}
