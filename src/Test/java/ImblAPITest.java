package Test.java;

import Main.java.*;


import java.net.URL;

import java.util.List;

public class ImblAPITest {
    public static void main(String[] args) throws Exception  {

        /*String url = "https://imdb-api.com/en/API/Top250Movies/k_5999zcau";*/
        String url = "https://api.mocki.io/v2/549a5d8b/Top250Movies";

        String body = new ClienteHttp().getBody(url);

        ExtratorConteudoIMBL carregarFilmeDeArquivoJson = new ExtratorConteudoIMBL();
        carregarFilmeDeArquivoJson.setParser(new JsonParser());
        carregarFilmeDeArquivoJson.setArquivoJson(body);
        List<Filme> filmes = carregarFilmeDeArquivoJson.extrairFilmes();

        //Scanner sc = new Scanner(System.in);
        GeradorDeFigurinhas geradorDeFigurinhas = new GeradorDeFigurinhas();

     for(Filme filme : filmes) {

         String nomeSaida = "figurinha " + filme.getTitulo() + ".png";
         String caminhoImagem = filme.getPoster();
         String frase = "Este filme é top " + filme.getAvaliacaoImbl();

         geradorDeFigurinhas.cria(new URL(caminhoImagem).openStream(), nomeSaida, frase);

         System.out.println(filme);
     }

    }

}
