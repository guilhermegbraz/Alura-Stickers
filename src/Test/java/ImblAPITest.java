package Test.java;

import Main.java.CarregarFilmeDeArquivoJson;
import Main.java.Filme;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Scanner;

public class ImblAPITest {
    public static void main(String[] args) throws Exception  {

        /*String url = "https://imdb-api.com/en/API/Top250Movies/k_5999zcau";*/
        String url = "https://api.mocki.io/v2/549a5d8b/Top250Movies";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();


        CarregarFilmeDeArquivoJson carregarFilmeDeArquivoJson = new CarregarFilmeDeArquivoJson();
        carregarFilmeDeArquivoJson.setArquivoJson(body);
        List<Filme> filmes = carregarFilmeDeArquivoJson.getListaDeFilmes();

        //Scanner sc = new Scanner(System.in);
        GeradorDeFigurinhas geradorDeFigurinhas = new GeradorDeFigurinhas();

     for(Filme filme : filmes) {

         /*System.out.println("Qual a sua avaliação para o filme " + filme.getTitulo() + " ?");
         filme.setAvaliacaoPessoal(sc.next());*/

         String nomeSaida = "figurinha " + filme.getTitulo() + ".png";
         String caminhoImagem = filme.getPoster();
         String frase = "Este filme é top " + filme.getAvaliacaoImbl();

         geradorDeFigurinhas.cria(new URL(caminhoImagem).openStream(), nomeSaida, frase);

         System.out.println(filme);
     }

    }

}
