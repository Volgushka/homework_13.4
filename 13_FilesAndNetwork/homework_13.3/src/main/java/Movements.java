import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Movements {


    public Movements(String pathMovementsCsv) {
    }
    public ArrayList<Lines> createLines() throws IOException {

   //     BufferedReader file = new BufferedReader(new FileReader(String.valueOf(new Movements(Main.csvFile))));
        BufferedReader file = new BufferedReader(new FileReader("D:\\Java\\java_basics\\13_FilesAndNetwork\\homework_13.3\\src\\test\\resources\\movementList.csv"));
        ArrayList <Lines>  myMovements = new ArrayList<>();
        String crudeString;
        boolean firstline = true;

        while((crudeString = file.readLine()) != null){

            if (firstline){firstline = false;
            }
             else {
                String [] parsedString = crudeString.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                parsedString[7] = parsedString[7].replace("\"", "");;
                Lines line = new Lines(parsedString[0], parsedString[1], parsedString[2], parsedString[3], parsedString[4], parsedString[5], parsedString[6],parsedString[7]);
                myMovements.add(line);
            }
        }
        return myMovements;
    }

    public double getExpenseSum() throws NumberFormatException, IOException {
        double getExpenseSum;
        Stream<String> streamExpense = createLines().stream().map(Lines::getOut);
        getExpenseSum = streamExpense.mapToDouble(Double::parseDouble).sum();
        return getExpenseSum;
    }

    public double getIncomeSum() throws Exception {
        double getIncomeSum;
        Stream<String> streamIncom = createLines().stream().map(Lines::getIncome);
        getIncomeSum = streamIncom.mapToDouble(Double::parseDouble).sum();
        return getIncomeSum;
    }

    public void expensesByOrganizations() throws IOException {
        Map<String, Double> expensesByOrganizations = createLines().stream().filter(a -> Double.parseDouble(a.getOut()) > 0)
                .collect(Collectors.toMap(k -> k.getDescription(), v -> v.getOut(), (v1, v2) -> String.valueOf(Double.parseDouble((String) v1) + Double.parseDouble((String) v2));
        String specifiers = "%-40s %-10s%n";
        expensesByOrganizations.forEach((k, v) -> System.out.format(specifiers, k, v));

    }
}
