package core;

import core.MetroLine;
import core.MetroStation;

import java.util.*;
import java.util.stream.Collectors;

public class MetroStationIndex {
        List<MetroLine> linesForMap = new ArrayList<>();
        TreeMap<String, Set<String>> stationsForMap = new TreeMap();
        List<TreeSet<MetroStation>>connectionsForMap = new ArrayList<>();

        public MetroStationIndex() {
        }

        public void createLinesList(MetroLine line) {
        linesForMap.add(line);
    }

        public void createStationsList (MetroLine line, List<MetroStation> stations) {
            Set<String> stationsSet = stations.stream().map(MetroStation::getStationName).collect(Collectors.toSet());
            this.stationsForMap.put(line.getMetroLineNumber(), stationsSet);
        }

        public void addConnection(TreeSet<MetroStation> stations) {
            if (!connectionsForMap.contains(stations)) {
                connectionsForMap.add(stations);
            }
        }

        public List<TreeSet<MetroStation>> getConnections() {
            return connectionsForMap;
        }

}
