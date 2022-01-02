import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
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

            try {

                System.out.println("Размер папки :" + inputPath + " составляет: " + FileUtils.FolderSize(inputPath));
                logger.info("Поиск размера папки: " + inputPath);

            } catch (NullPointerException e) {

                if (inputPath.split(" ").length > 1) {
                    System.err.println(e.getMessage());
                    System.err.println("Вы ввели пути двух папок.Необходимо ввести путь одной папки.");
                }
                else {
                    System.err.println(e.getMessage());
                    System.err.println("Неверный путь либо такой папки не существует");
                }
                logger.error("Неверный путь либо такой папки не существует: " + inputPath + " " + e);
            }

        }
    }
}