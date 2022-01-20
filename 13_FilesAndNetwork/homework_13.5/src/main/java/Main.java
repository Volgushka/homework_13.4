import com.google.gson.Gson;
import core.CreateMetroMap;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;



public class Main {

    private final static String moskowMetroJsonFile = "src/main/resources/metromap.json";

    public static void main(String[] args) throws IOException, ParseException {
        CreateMetroMap metroMap = new CreateMetroMap();
        metroMap.createMetroMap();
        getStationsCount(moskowMetroJsonFile);
      //  getConnectionsCount(moskowMetroJsonFile);
    }

    public static void getStationsCount(String filePath) throws ParseException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        StringBuilder stringBuilder = new StringBuilder();
        //array.add(object);
        JSONObject jo = (JSONObject) obj;

        String line = (String) jo.get("line");;
        System.out.println(line);

    }


}
