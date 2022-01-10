import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import java.util.stream.Collectors;

public class Movements {

    String pathMovementsCsv;


    public Movements(String pathMovementsCsv) {
        this.pathMovementsCsv = pathMovementsCsv;
    }
    public List<Lines> createLines() throws IOException {


        ArrayList<Lines> myMovements = new ArrayList<>();

        try (BufferedReader file = new BufferedReader(new FileReader(pathMovementsCsv))) {
            String crudeString;
            boolean firstline = true;

            while ((crudeString = file.readLine()) != null) {

                if (firstline) {
                    firstline = false;
                } else {
                    String[] parsedString = crudeString.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                    parsedString[6] = parsedString[6].replaceAll("\\,", "\\.").replaceAll("\"", "");
                    parsedString[7] = parsedString[7].replaceAll("\\,", "\\.").replaceAll("\"", "");
                    Lines line = new Lines(parsedString[0], parsedString[1], parsedString[2], parsedString[3],
                            parsedString[4], parsedString[5], parsedString[6], parsedString[7],getOrganizations(parsedString[5]));
                    myMovements.add(line);
                }
            }
            return myMovements;
        }
    }
    public double getExpenseSum() throws NumberFormatException, IOException {
        return createLines().stream()
                .mapToDouble(v -> Double.parseDouble(v.getOut()))
                .sum();
    }


    public double getIncomeSum() throws IOException {
        return createLines().stream()
                .mapToDouble(v -> Double.parseDouble(v.getIncome()))
                .sum();
    }
    public String getOrganizations(String string){
        String newString = string.replace('\\','/');
        int beginIndex = newString.lastIndexOf("/");
        int endIndex = newString.indexOf("  ",beginIndex);
        return string.substring(beginIndex+1,endIndex);
    }

    public Map<String,Double> expensesByOrganizations() throws IOException {

        return createLines().stream().filter(a -> Double.parseDouble(a.getOut()) > 0).
        collect(Collectors.toMap(Lines::getOrganization, v -> Double.parseDouble(v.getOut()), Double::sum));



    }
}
