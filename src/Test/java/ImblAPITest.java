package Test.java;

import Main.java.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ImblAPITest {
    public static void main(String[] args) throws Exception  {

        String url = "https://imdb-api.com/en/API/Top250Movies/k_5999zcau";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());// pode dar erro
        String body = response.body();


        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        StringBuilder result = new StringBuilder();

     for(Map<String, String> filme : listaDeFilmes) {
         result.append("Titulo: ");
         result.append(filme.get("title"));
         result.append(", Nota: ");
         result.append(filme.get("imDbRating"));
         result.append(", poster: ");
         result.append(filme.get("image"));
         result.append(".\n");
     }
        System.out.println(result.toString());


    }

}
