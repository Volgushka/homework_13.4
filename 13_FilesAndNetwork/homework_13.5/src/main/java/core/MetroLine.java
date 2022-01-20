package core;


public class MetroLine {
    private final String metroLineNumber;
    private final String metroLineName;

    public MetroLine(String number, String name) {
        metroLineNumber = number;
        metroLineName = name;
    }

    public String getMetroLineNumber() {
        return metroLineNumber;
    }

    public String getMetroLineName() {
        return metroLineName;
    }

}

