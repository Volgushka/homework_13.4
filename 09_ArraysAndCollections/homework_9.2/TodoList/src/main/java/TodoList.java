import java.util.ArrayList;

public class TodoList {

    ArrayList<String> mylist = new ArrayList<String>();

    public void add(String todo) {
        mylist.add(todo);
        System.out.println("Добавлено дело " + "\"" + todo.strip() + "\"");
        // TODO: добавьте переданное дело в конец списка
    }

    public void add(int index, String todo) {
        int limit = mylist.size();
        if (index < limit) {
            mylist.add(index, todo);
            System.out.println("Добавлено дело " + "\"" + todo.strip() + "\"");
        } else {
            mylist.add(limit, todo);
            System.out.println("Добавлено дело " + "\"" + todo.strip() + "\"");
        }
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
    }

    public void edit(String todo, int index) {
        int limit = mylist.size();
        if (index < limit) {
            mylist.remove(index);
            mylist.add(index, todo);
            System.out.println("Дело " + "\"" + mylist.get(index).strip() +
                    "\"" + "заменено на" + "\"" + todo.strip() + "\"");
        }

    }
    // TODO: заменить дело на index переданным todo индекс,
    //  проверьте возможность изменения

    public void delete(int index) {
        int limit = mylist.size();
        if (index < limit) {

            System.out.println("Дело " + "\"" + mylist.get(index).strip() + "\"" + " удалено");
            mylist.remove(index);
        } else {
            System.out.println("Дело с таким номером не существует");
        }
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
    }

    public ArrayList<String> getTodos() {
        return mylist;
    }

}
