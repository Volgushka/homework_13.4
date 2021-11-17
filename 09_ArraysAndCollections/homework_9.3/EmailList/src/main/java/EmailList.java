import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.ArrayList;

public class EmailList {

    List<String> myEmailList = new ArrayList<>();

    public void add(String email) {
        String regex = "^(.+)@(.+)\\.(.+)$";
        if (email.matches(regex)) {
            myEmailList.add(email.toLowerCase());
        } else {
            System.out.println(Main.WRONG_EMAIL_ANSWER);
        }
        // TODO: валидный формат email добавляется
    }

    public List<String> getSortedEmails() {
        // TODO: возвращается список электронных адресов в алфавитном порядке
        TreeSet myEmailSet = new TreeSet(myEmailList);
        List newEmailList = new ArrayList(myEmailSet);
        return newEmailList;
    }

}
