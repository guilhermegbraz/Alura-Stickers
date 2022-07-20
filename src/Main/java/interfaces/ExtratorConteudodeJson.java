package Main.java.interfaces;

import Main.java.model.Conteudo;

import java.util.List;

public interface ExtratorConteudodeJson {

    List<Conteudo> extrairConteudos(String json);
}
