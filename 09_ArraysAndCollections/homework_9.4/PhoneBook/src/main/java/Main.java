import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Введите номер, имя или команду(LIST):");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        PhoneBook example = new PhoneBook();

        if (example.nameControl(input)) {
            example.getContactByName(input);

            if (example.getContactByName(input) == null) {
                System.out.println("Такого имени в телефонной книге нет.");
                System.out.println("Введите номер телефона для абонента " + input + " :");
                String inputPhone = scanner.nextLine();
                example.addContact(input, inputPhone);
            }
            System.out.println("Контакт сохранен!");
        } else if (example.phoneControl(input)) {
            example.getContactByPhone(input);

            if (example.getContactByPhone(input) == null) {
                System.out.println("Такого номера нет в телефонной книге.");
                System.out.println("Введите имя абонента для номера " + input + " :");
                String inputName = scanner.nextLine();
                example.addContact(inputName, input);
            }
            System.out.println("Контакт сохранен!");
        } else if (input.equals("LIST")) {
            example.getAllContacts();
        } else {
            System.out.println("Неверный формат ввода");
        }
    }
}