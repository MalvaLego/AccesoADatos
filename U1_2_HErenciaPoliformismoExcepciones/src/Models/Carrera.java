package Models;

public class Carrera implements Comparable<Carrera>{
    private int codigo;
    private String titulo;
    private int creditos;

    public Carrera(int codigo, String titulo, int creditos) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.creditos = creditos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    @Override
    public int compareTo(Carrera o) {
        int tituloDiff= this.titulo.compareToIgnoreCase(o.titulo);
        int creditosDiff= this.creditos-o.creditos;

        if (tituloDiff!=0){
            return tituloDiff;
        }
        if (creditosDiff!=0){
            return creditosDiff;
        }
        return this.codigo-o.codigo;
    }

    @Override
    public String toString() {
        return getClass()+" "+getClass().getSimpleName()+"{" +
                "codigo=" + codigo +
                ", titulo='" + titulo + '\'' +
                ", creditos=" + creditos +
                '}';
    }


}
