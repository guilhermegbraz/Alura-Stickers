package Test.java;

import Main.java.*;
import Main.java.model.Filme;


import java.net.URL;

import java.util.List;

public class App {
    public static void main(String[] args) throws Exception  {
        /*String url = "https://imdb-api.com/en/API/Top250Movies/k_5999zcau";*/


        String url = "https://api.mocki.io/v2/549a5d8b/Top250Movies";
        String body = new ClienteHttp().getBody(url);

        ExtratorConteudoIMBL extratorFilmes = new ExtratorConteudoIMBL();
        List<Filme> filmes = extratorFilmes.extrairFilmes(body);

        GeradorDeFigurinhas geradorDeFigurinhas = new GeradorDeFigurinhas();

     for(Filme filme : filmes) {
         String nomeSaida = "figurinha " + filme.getTitulo() + ".png";
         String caminhoImagem = filme.getUrlImagem();
         String frase = "Este filme é top " + filme.getAvaliacaoImbl();

         geradorDeFigurinhas.cria(new URL(caminhoImagem).openStream(), nomeSaida, frase);

         System.out.println(filme);
        }

    }

}
