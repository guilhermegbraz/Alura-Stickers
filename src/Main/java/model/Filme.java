package Main.java.model;

import Main.java.model.Conteudo;

public class Filme extends Conteudo {

    private final String avaliacaoImbl;
    String avaliacaoPessoal;


    public Filme(String titulo, String avaliacaoImbl, String poster) {
        super(titulo, poster);
        this.avaliacaoImbl = avaliacaoImbl;
    }

    public Filme( Conteudo conteudoFilme, String avaliacaoImbl) {
        super(conteudoFilme.getTitulo(), conteudoFilme.getUrlImagem());
        this.avaliacaoImbl = avaliacaoImbl;
    }

    public String getAvaliacaoImbl() {
        return avaliacaoImbl;
    }

    public String getAvaliacaoPessoal() {
        return avaliacaoPessoal;
    }

    public void setAvaliacaoPessoal(String avaliacaoPessoal) {
        this.avaliacaoPessoal = avaliacaoPessoal;
    }

   public String toString() {
        StringBuilder resultado = new StringBuilder();

        String NEGRITO = "\u001b[1m";
        String SUBLINHADO = "\u001b[5m";
        String NORMAL = "\u001b[0m";
        String FUNDOMAGENTA = "\u001b[45m";
        String AZUL = "\u001b[34m";
        String COR_NOTA;


        resultado.append(FUNDOMAGENTA + NEGRITO + "Titulo: " + NORMAL);
        resultado.append( FUNDOMAGENTA + SUBLINHADO + this.getTitulo() + NORMAL + "\n");

        resultado.append(NEGRITO + "Link para o poster: " + NORMAL);
        resultado.append(AZUL + SUBLINHADO + this.getUrlImagem() + NORMAL + "\n");

        resultado.append(NEGRITO + "Avaliação: " + NORMAL);
        for (int i = 0; i < Float.parseFloat(this.avaliacaoImbl); i++) {
            resultado.append("⭐");
        }
        if (Float.parseFloat(this.avaliacaoImbl) <= 5f) {
             COR_NOTA = "\u001b[31m";
        } else {COR_NOTA = "\u001b[32m";}

        resultado.append(" " + COR_NOTA +"(" + this.avaliacaoImbl + ")" + NORMAL + "\n");

        return resultado.toString();
    }


}
