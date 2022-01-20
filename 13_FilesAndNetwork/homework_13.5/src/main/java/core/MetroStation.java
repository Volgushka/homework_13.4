package core;

public class MetroStation

{
    private String stationName;
    private String lineStationNumber;

    public MetroStation(String name, String lineStationNumber)
    {
        this.stationName = name;
        this.lineStationNumber = lineStationNumber;
    }

    public String getlineStationNumber() {
        return lineStationNumber;
    }

    public String getStationName() {
        return stationName;
    }

}