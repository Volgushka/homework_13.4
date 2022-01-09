import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Main {

    public static final String csvFile = "D:\\Java\\java_basics\\13_FilesAndNetwork\\homework_13.3\\src\\test\\resources\\movementList.csv";

    public static void main(String[] args) throws Exception {

        Movements statement = new Movements(csvFile);

            try {

            System.out.println("Сумма доходов:  " + statement.getIncomeSum() + " руб.");
            System.out.println("Сумма расходов: " + statement.getExpenseSum() + " руб.");


            System.out.println();

            System.out.println("Суммы расходов по организациям: ");
            statement.expensesByOrganizations();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}