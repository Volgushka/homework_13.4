package core;

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
    public List<String> lines_str_arr = new ArrayList<>();

    public void createMetroMap() throws IOException {

        BufferedWriter metroWriter = new BufferedWriter(new FileWriter("src/main/resources/metromap.json"));

        Document metro = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines").maxBodySize(0).get();

        Elements el_lines = metro.select("span.js-metro-line.t-metrostation-list-header");
        Elements el_stations = metro.select("div.js-metro-stations.t-metrostation-list-table");
        Elements el_connections = metro.select("p.t-metrostation-list-headerlink");

        JSONObject metroJson = new JSONObject();

        metroJson.put("stations", createMetroStationsForMap(el_stations));
        metroJson.put("line", createMetroLineForMap(el_lines));
        metroJson.put("connections", createMetroStationsForMap(el_connections));


        try {
            metroWriter.write(metroJson.toJSONString());
            metroWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private JSONArray createMetroLineForMap(Elements el_lines) {
        JSONArray lines_js_arr = new JSONArray();

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
                if (!lines_str_arr.contains(numberLine)) {
                    lines_str_arr.add(numberLine);
                }
            }
        }

        for (String m : lines_str_arr) {
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

    private JSONArray createConnectionsForMap(Elements el_connections) {

        JSONObject connections_js_o = new JSONObject();
        JSONArray allConnections_js_arr = new JSONArray();
        JSONArray connections_js_arr = new JSONArray();
        List<String> connect = new ArrayList<>();
        List<List> connectionsList = new ArrayList<>();

        for (Element element : el_connections) {

            String numberLine = element.attr("data-line");

            String newURL = element.attr("href");
            Document metroConnections = (Document) Jsoup.connect("http://www.moscowmap.ru" + newURL);

            Elements el_connect = metroConnections.select("p >div.t-metrostation-list-table");
            for (Element elementStation : el_connect) {
                String stationName = elementStation.text();
                Elements innerLines = elementStation.select("span.class");
                for (Element innerLine : innerLines) {
                    String innerline = innerLine.toString().replace("t-icon-metroln ln-", "");

                    if (innerLine != null) {

                        connect.add(stationName);
                        connect.add(numberLine);
                        connect.add(innerline);
                        connectionsList.add(connect);
                    }
                }

                for (String l : lines_str_arr) {
                    for (List list : connectionsList) {
                        if (list.get(1).equals(l)) {
                            connections_js_o.put("line", list.get(1));
                            connections_js_o.put("station", list.get(0));
                            connections_js_arr.add(connections_js_o);
                        }
                        if (list.get(2).equals(l)) {
                            connections_js_o.put("line", list.get(1));
                            connections_js_o.put("station", list.get(0));
                            connections_js_arr.add(connections_js_o);
                        }
                    }

                    connections_js_arr.add(connections_js_o);
                }
                allConnections_js_arr.add(connections_js_arr);
            }
        }

        return allConnections_js_arr;
    }
}

