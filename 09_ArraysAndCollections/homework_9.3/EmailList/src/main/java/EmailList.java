import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.ArrayList;

public class EmailList {

    TreeSet<String> myEmaillist = new TreeSet<String>();

    public void add(String email) {
        String regex = "^(.+)@(.+)\\.(.+)$";
        if (email.matches(regex)) {
            myEmaillist.add(email.toLowerCase());
        } else {
            System.out.println(Main.WRONG_EMAIL_ANSWER);
        }
        // TODO: валидный формат email добавляется
    }

    public List<String> getSortedEmails() {
        // TODO: возвращается список электронных адресов в алфавитном порядке
        return new ArrayList(myEmaillist);
    }

}

