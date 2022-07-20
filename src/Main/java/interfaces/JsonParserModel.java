package Main.java.interfaces;

import java.util.List;
import java.util.Map;

public interface JsonParserModel {

    List<Map<String, String>> parse(String json);
}
