
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        System.out.println("Введите путь до папки: ");
        Scanner scanner = new Scanner(System.in);

        for (; ; ) {
            String inputPath = scanner.nextLine();

                System.out.println("Размер папки :" + inputPath + " составляет: " + FileUtils.getFolderSize(inputPath));
                logger.info("Поиск размера папки: " + inputPath);

        }
    }
}