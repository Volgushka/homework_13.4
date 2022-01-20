package core;

import org.checkerframework.checker.units.qual.A;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CreateMetroMap {
    List<String> lines_str_arr = new ArrayList<>();

    public void createMetroMap() throws IOException {

        BufferedWriter metroWriter = new BufferedWriter(new FileWriter("src/main/resources/metromap.json"));

        Document metro = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines").maxBodySize(0).get();

        Elements el_lines = metro.select("span.js-metro-line.t-metrostation-list-header");
        Elements el_stations = metro.select("div.js-metro-stations.t-metrostation-list-table");
        Elements el_connections = metro.select("div.js-metro-stations.t-metrostation-list-table");

        JSONObject metroJson = new JSONObject();

        metroJson.put("stations", createMetroStationsForMap(el_stations));
        metroJson.put("line", createMetroLineForMap(el_lines));

        //   metroJson.put("connections", (el_connections));


        try {
            metroWriter.write(metroJson.toJSONString());
            metroWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private  JSONArray createMetroLineForMap(Elements el_lines) {
        JSONArray lines_js_arr = new JSONArray();
        List<String> lines_str_arr = new ArrayList<>();

        for (Element elementLine : el_lines) {
            JSONObject jsonLine = new JSONObject();

            String nameLine = elementLine.text();
            String numberLine = elementLine.attr("data-line");
            jsonLine.put("number", numberLine);
            jsonLine.put("name", nameLine);
            lines_js_arr.add(jsonLine);


        }
        return lines_js_arr;
    }


    private JSONObject createMetroStationsForMap(Elements el_station) {

        JSONObject station_js_o = new JSONObject();
        JSONArray stationsThisLineList = new JSONArray();

        List<MetroStation> stationsList = new ArrayList<>();

        for (Element element : el_station) {
            String numberLine = element.attr("data-line");
            Elements nameStation = element.select("span.name");
            for (Element elementStation : nameStation) {
                String stationName = elementStation.text();
                stationsList.add(new MetroStation(stationName, numberLine));
                if(!lines_str_arr.contains(numberLine)){
                lines_str_arr.add(numberLine);}
            }
        }

       for (String m: lines_str_arr) {
           for (MetroStation ms : stationsList) {
               if (m.equals(ms.getlineStationNumber())) {
                   stationsThisLineList.add(ms.getStationName());
               }
           }
           JSONArray copy = (JSONArray) stationsThisLineList.clone();
           station_js_o.put(m, copy);
           stationsThisLineList.clear();
       }
       return station_js_o;
    }

    private static JSONArray getArrayConnections(Elements connectionsElements) {

        return null;
    }
}