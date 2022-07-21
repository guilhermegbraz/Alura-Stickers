package Main.java.service;

import Main.java.interfaces.ExtratorConteudodeJson;
import Main.java.interfaces.JsonParserModel;
import Main.java.model.Conteudo;
import Main.java.model.JsonParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoNASA implements ExtratorConteudodeJson {

    private JsonParserModel parser = new JsonParser();

    @Override
    public List<Conteudo> extrairConteudos(String json) {

        List<Conteudo> conteudos = new ArrayList<>();

        for (Map<String, String> nasaJson : parser.parse(json)) {
            conteudos.add(new Conteudo(nasaJson.get("title"), nasaJson.get("urlImage")));
        }

        return conteudos;
    }
}
