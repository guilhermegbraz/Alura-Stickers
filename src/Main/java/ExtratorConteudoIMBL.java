package Main.java;

import Main.java.interfaces.ExtratorConteudodeJson;
import Main.java.interfaces.JsonParserModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoIMBL implements ExtratorConteudodeJson {

    private String arquivoJson;
    private JsonParserModel parser = new JsonParser();

    public void setArquivoJson(String arqJson) {
        this.arquivoJson = arqJson;
    }

    public String getArquivoJson() {
        return this.arquivoJson;
    }


    public List<Filme> extrairFilmes() throws RuntimeException {

        if (this.arquivoJson == null) {
            throw new RuntimeException("Você não setou o arquivo json");
        }

        List<Filme> filmes = new ArrayList<>();

        for (Map<String, String> filmeDaLista : parser.parse(this.arquivoJson)) {
            Filme filme = new Filme(
                    filmeDaLista.get("title"), filmeDaLista.get("imDbRating"),filmeDaLista.get("image"));

            filmes.add(filme);
        }

        return filmes;
    }

    @Override
    public List<Conteudo> extrairConteudos(String json) {

        List<Conteudo> conteudos = new ArrayList<>();

        for (Map<String, String> filmeJson : parser.parse(json)) {
            conteudos.add(new Conteudo(filmeJson.get("title"), filmeJson.get("image")));
        }
        return conteudos;
    }

}
