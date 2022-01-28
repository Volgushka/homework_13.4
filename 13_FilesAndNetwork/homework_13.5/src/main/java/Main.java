import com.google.gson.JsonArray;
import core.CreateMetroMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;


public class Main {

    private final static String moskowMetroJsonFile = "src/main/resources/metromap.json";

    public static void main(String[] args) throws IOException, ParseException {
        CreateMetroMap metroMap = new CreateMetroMap();
        metroMap.createMetroMap();
        getStationsCount(moskowMetroJsonFile);
        getConnectionsCount(moskowMetroJsonFile);
    }

    public static void getStationsCount(String filePath) throws ParseException, IOException {
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader(filePath)) {
            JSONObject metromap = (JSONObject) parser.parse(reader);

            JSONObject stationsJSON = (JSONObject) metromap.get("stations");

            for (Object l : stationsJSON.keySet()) {
                String key = l.toString();
                String[] value = stationsJSON.get(l).toString().split(",");
                int sumValue = value.length;
                System.out.println("Линия метро " + key + ". " + "Kоличество станций " + "- " + sumValue);
            }
        }

    }

    public static void getConnectionsCount(String filePath) throws ParseException, IOException {
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader(filePath)) {
            JSONObject metromap = (JSONObject) parser.parse(reader);

            JSONArray сonnectionsJSON = (JSONArray) metromap.get("сonnections");

            int transition = сonnectionsJSON.size();
            System.out.println("Количество переходов в метро  -  " + transition);
        }
    }

}

