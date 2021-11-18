import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class PhoneBook {

    Map<String, String> myPhoneBook = new TreeMap<>();

    public void addContact(String phone, String name) {
        String regexPhone = "[0-9]{11}";
        String regexName = "[А-ЯA-Z]{1}[а-яa-z]+";

        if (phone.matches(regexPhone) && name.matches(regexName)) {
            myPhoneBook.put(phone, name);
        } else {
            System.out.println("Неверный формат ввода");
        }
    }
}
        // проверьте корректность формата имени и телефона (отдельные методы для проверки)
        // если такой номер уже есть в списке, то перезаписать имя абонента

    public String getContactByPhone(String phone) {
        if (myPhoneBook.containsKey(phone)) {
            return myPhoneBook.get(phone) + " - " + phone;
        } else {
            return "";
        }
    }

        // если контакт не найдены - вернуть пустую строку

    public Set<String> getContactByName(String name) {

        Set<String> setPhoneBook = new TreeSet<>();
        String namePlusTel = "";
        if (myPhoneBook.containsValue(name)) {
            namePlusTel = namePlusTel.concat(name) + " - ";
            for (String tel : myPhoneBook.keySet()) {
                if (myPhoneBook.get(tel).equals(name)) {
                    namePlusTel = namePlusTel.concat(tel) + ", ";
                }
            }
            setPhoneBook.add(namePlusTel.substring(0, namePlusTel.length() - 2));
            return setPhoneBook;
        } else {
            return new TreeSet<>();
        }
    }

// формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet


    public Set<String> getAllContacts() {

        Set<String> setPhoneBook = new TreeSet<>();

        for (String key : myPhoneBook.keySet()) {
            setPhoneBook.add(myPhoneBook.get(key) + " - " + key);
        }
        return setPhoneBook;
    }
}
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet


    // для обхода Map используйте получение пары ключ->значение Map.Entry<String,String>
    // это поможет вам найти все ключи (key) по значению (value)
    /*
        for (Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey(); // получения ключа
            String value = entry.getValue(); // получения ключа
        }
    */
}