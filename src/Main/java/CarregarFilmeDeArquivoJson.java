package Main.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class CarregarFilmeDeArquivoJson {

    private String arquivoJson;
    static JsonParser parser = new JsonParser();

    public void setArquivoJson(String arqJson) {
        this.arquivoJson = arqJson;
    }

    public String getArquivoJson() {
        return this.arquivoJson;
    }

    public List<Filme> getListaDeFilmes() throws RuntimeException {
        if (this.arquivoJson == null) {
            throw new RuntimeException("Você não setou o arquivo json");
        }

        List<Map<String, String>> listaDeFilmes = parser.parse(this.arquivoJson);
        List<Filme> filmes = new ArrayList<>();
        for (Map<String, String> filmeDaLista : listaDeFilmes) {
            Filme filme = new Filme(
                    filmeDaLista.get("title"), filmeDaLista.get("imDbRating"),filmeDaLista.get("image"));
            filmes.add(filme);
        }

        return filmes;
    }
}
