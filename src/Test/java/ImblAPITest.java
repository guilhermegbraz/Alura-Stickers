package Test.java;

import Main.java.CarregarFilmeDeArquivoJson;
import Main.java.Filme;
import Main.java.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ImblAPITest {
    public static void main(String[] args) throws Exception  {

        String url = "https://imdb-api.com/en/API/Top250Movies/k_5999zcau";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();


        CarregarFilmeDeArquivoJson carregarFilmeDeArquivoJson = new CarregarFilmeDeArquivoJson();
        carregarFilmeDeArquivoJson.setArquivoJson(body);
        List<Filme> filmes = carregarFilmeDeArquivoJson.getListaDeFilmes();

     for(Filme filme : filmes) {
         System.out.println("Qual a sua avaliação para o filme " + filme.getTitulo() + " ?");
         Scanner sc = new Scanner(System.in);
         filme.setAvaliacaoPessoal(sc.next());
         System.out.println(filme);
     }

    }

}
