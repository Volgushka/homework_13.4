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

        ArrayList<MetroConnections> cList = new ArrayList<>();

        for (Element element : connectionsElements) {
            String strLineIn = element.attr("data-line");
            Elements cElements1 = element.select("a:has(span.t-icon-metroln)");
            for (Element element1 : cElements1) {
                String strNameInBeforeFormated = element1.text();
                String strNameIn = strNameInBeforeFormated.replaceAll("\\d+\\.0000\\s", "");
                Elements cElements2 = element1.select("a:has(span.t-icon-metroln) > span.t-icon-metroln");
                for (Element element2 : cElements2) {
                    String strLineToBeforeFormated = element2.attr("class");
                    String strLineTo = strLineToBeforeFormated.replaceAll(".+\\-", "")
                            .replaceAll(".{4}", "");

                    String strNameToBeforeFormated = element2.attr("title");
                    String strNameTo = strNameToBeforeFormated.replaceAll("(.+\\«)(.+)(\\».+)", "$2");
                    cList.add(new MetroConnections(strLineIn, strNameIn, strLineTo, strNameTo));
                }
            }
        }

        TreeSet<String> connectionSet = new TreeSet<>();

        cList.stream()
                .forEach(d -> connectionSet.add(d.getNameIn() + "*" + d.getLineIn() + "*"
                        + d.getNameTo() + "*" + d.getLineTo()));

        TreeMap<Integer, String> connectionMap = new TreeMap<>();

        for (String f : connectionSet) {
            int sum = 0;
            for (char ch : f.toCharArray()) {
                sum += 1 + ch;
            }
            connectionMap.put(sum, f);
        }


        JSONArray connections = new JSONArray();

        for (Map.Entry<Integer, String> entry : connectionMap.entrySet()) {
            JSONObject connectionObject1 = new JSONObject();
            JSONObject connectionObject2 = new JSONObject();
            JSONObject connectionObject3 = new JSONObject();
            JSONArray cArray = new JSONArray();
            String str = String.valueOf(entry.getValue());
            String strLineIn = str.replaceAll("(\\W+)(\\w+)(\\W+)(\\w+)"
                    , "$2");
            String strNameIn = str.replaceAll("(\\W+)(\\w+)(\\W+)(\\w+)"
                    , "$1").replaceAll("\\*", "");
            String strLineTo = str.replaceAll("(\\W+)(\\w+)(\\W+)(\\w+)"
                    , "$4");
            String strNameTo = str.replaceAll("(\\W+)(\\w+)(\\W+)(\\w+)"
                    , "$3").replaceAll("\\*", "");

            connectionObject1.put("line", strLineIn);
            connectionObject1.put("station", strNameIn);
            connectionObject2.put("line", strLineTo);
            connectionObject2.put("station", strNameTo);
            cArray.add(connectionObject1);
            cArray.add(connectionObject2);
            connections.add(cArray);
        }
        return connections;
    }
}