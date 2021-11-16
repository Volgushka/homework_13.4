import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

//LIST, ADD, EDIT, DELETE.

public class Main {

    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {

        System.out.println("Какую операцию желаете произвести?: \n ADD (добавить) \n EDIT(редактировать)\n DELETE(удалить) \n LIST(вывести список дел)");
        Scanner input = new Scanner(System.in);
        String deal = input.nextLine();
        String[] dealList = deal.split(" ");
        String regex = "[0-9]+";

        String first = dealList[0];
        int second = 0;
        String secondS = Integer.toString(second);
        String third;
        if (dealList[1].matches(regex)) {
            second = Integer.parseInt(dealList[1]);
            third = deal.substring(first.length() + secondS.length(), deal.length());
        } else {
            third = deal.substring(first.length(), deal.length());
        }

        if (first.equals("ADD") & second == 0) {
            todoList.add(third);

        } else if (first.equals("ADD") & second != 0) {
            todoList.add(second, third);
        } else if (first.equals("EDIT")) {
//            System.out.println("Дело " + "\"" + todoList.getTodos().get(second).strip() + "\"" + "заменено на" + "\"" + third.strip() + "\"");
            todoList.edit(third, second);

        } else if (first.equals("DELETE")) {
            todoList.delete(second);
        } else if (first.equals("LIST")) {
            for (int i = 0; i < todoList.getTodos().size(); i++) {
                System.out.println(i + "-" + todoList.getTodos().get(i));
            }

        }
    }
}
