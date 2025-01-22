package org.example.DB;

public class EquipoEntity {
    private String nomeq;
    private String director;

    public String getNomeq() {
        return nomeq;
    }

    public void setNomeq(String nomeq) {
        this.nomeq = nomeq;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EquipoEntity that = (EquipoEntity) o;

        if (nomeq != null ? !nomeq.equals(that.nomeq) : that.nomeq != null) return false;
        if (director != null ? !director.equals(that.director) : that.director != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nomeq != null ? nomeq.hashCode() : 0;
        result = 31 * result + (director != null ? director.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "EquipoEntity{" +
                "nomeq='" + nomeq + '\'' +
                ", director='" + director + '\'' +
                '}'+"\n";
    }
}
