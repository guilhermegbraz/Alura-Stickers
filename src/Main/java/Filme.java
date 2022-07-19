package Main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Filme {

    private final String titulo;
    private final String avaliacaoImbl;
    String avaliacaoPessoal;
    private String poster;

    public Filme(String titulo, String avaliacaoImbl, String poster) {
        this.titulo = titulo;
        this.avaliacaoImbl = avaliacaoImbl;
        this.poster = poster;
    }

    public void setAvaliacaoPessoal(String avaliacaoPessoal) {
        this.avaliacaoPessoal = avaliacaoPessoal;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAvaliacaoImbl() {
        return avaliacaoImbl;
    }

    public String getAvaliacaoPessoal() {
        return avaliacaoPessoal;
    }

    public String getPoster() {
        return poster;
    }


   public String toString() {
        String result = "Titulo: "+
        this.titulo +
        ", Nota: " +
        this.avaliacaoImbl;
        if (this.avaliacaoPessoal != null) {
            result = result + "Nota pessoal: " + this.avaliacaoPessoal;
        }

        result = result + ", poster: " + this.poster + ".";

        return result;
    }


}
