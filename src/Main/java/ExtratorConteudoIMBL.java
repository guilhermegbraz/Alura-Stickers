package Main.java;

import Main.java.interfaces.ExtratorConteudodeJson;
import Main.java.interfaces.JsonParserModel;
import Main.java.model.Conteudo;
import Main.java.model.Filme;
import Main.java.model.JsonParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoIMBL implements ExtratorConteudodeJson {

    private JsonParserModel parser = new JsonParser();

    @Override
    public List<Conteudo> extrairConteudos(String json) {
        List<Conteudo> conteudos = new ArrayList<>();
        for (Map<String, String> filmeJson : parser.parse(json)) {
            conteudos.add(new Conteudo(filmeJson.get("title"), filmeJson.get("image")));
        }
        return conteudos;
    }

    public List<Filme> extrairFilmes(String json) throws RuntimeException {
        List<Filme> filmes = new ArrayList<>();
        for (Map<String, String> filmeDaLista : parser.parse(json)) {
            Filme filme = new Filme(
                    filmeDaLista.get("title"), filmeDaLista.get("imDbRating"),filmeDaLista.get("image"));

            filmes.add(filme);
        }

        return filmes;
    }



}
