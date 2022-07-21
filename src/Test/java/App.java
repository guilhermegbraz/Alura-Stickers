package Test.java;

import Main.java.interfaces.ExtratorConteudodeJson;
import Main.java.model.Conteudo;
import Main.java.model.Filme;
import Main.java.service.ClienteHttp;
import Main.java.service.ExtratorConteudoIMBL;
import Main.java.service.ExtratorConteudoNASA;
import Main.java.service.GeradorDeFigurinhas;


import java.net.URL;

import java.util.List;

public class App {
    public static void main(String[] args) throws Exception  {
        /*String url = "https://imdb-api.com/en/API/Top250Movies/k_5999zcau";*/
        //String url = "https://api.mocki.io/v2/549a5d8b/Top250Movies";

        String url = "http://localhost:8080/linguagens";
        String body = new ClienteHttp().getBody(url);

        ExtratorConteudodeJson extrator = new ExtratorConteudoNASA();
        List<Conteudo> linguagens = extrator.extrairConteudos(body);

        GeradorDeFigurinhas geradorDeFigurinhas = new GeradorDeFigurinhas();

     for(Conteudo linguagem : linguagens) {
         String nomeSaida = "figurinha " + linguagem.getTitulo() + ".png";
         String caminhoImagem = linguagem.getUrlImagem();
         String frase = "Este linguagem é top Hein";

         geradorDeFigurinhas.cria(new URL(caminhoImagem).openStream(), nomeSaida, frase);

         System.out.println(linguagem);
        }

    }

}
