import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        for (; ; ) {
            System.out.println("Введите адрес копируемой папки: ");
            String scr = scanner.nextLine();

            System.out.println("Введите адрес папки назначения: ");
            String dest = scanner.nextLine();

            if (!new File(scr).exists()) {      // проверка наличия источника
                System.out.println("Такой папки не существует");

            } else {

                try {
                    FileUtils.copyFolder(scr, dest);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(0);
                }
            }

            System.out.println("Папка успешно скопирована");
        }
    }
}