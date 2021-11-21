import java.util.*;

public class PhoneBook {

    Map<String, String> myPhoneBook = new TreeMap<>();

    public boolean nameControl(String name) {
        String regexName = "[А-ЯA-Z]{1}[а-яa-z]+";
        return name.matches(regexName);
    }

    public boolean phoneControl(String phone) {
        String regexPhone = "[0-9]{11}";
        return phone.matches(regexPhone);
    }

    public void addContact(String phone, String name) {/* в качестве ключа в данном случае может быть только номер
      потому что только номер имеет уникальность в паре  номер - имя
      у имени может быть несколько номеров
       но вообще лучше ключом выбирать имя. Только тогда значения
        олжны быть списком(массивом)*/
        if (phoneControl(phone) && nameControl(name)) {
            myPhoneBook.put(phone, name);
        } else {
            System.out.println("Неверный формат ввода");
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

    public Set<String> getContactByName(String name) {

        Set<String> getPhoneByName = new TreeSet<>();

        for (Map.Entry<String, String> entry : myPhoneBook.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value.equals(name)) {
                getPhoneByName.add(value + " - " + key);
            }
        }
        return getPhoneByName;
    }


    public Map<String, ArrayList<String>> getVersaKeyName() {

        Map<String, ArrayList<String>> myNewPhoneBook = new TreeMap<>();

        for (Map.Entry some : myPhoneBook.entrySet())
        {
            String name = (String) some.getValue();
            if (!myNewPhoneBook.containsKey(name))
            {
                myNewPhoneBook.put(name, new ArrayList<String>());
                myNewPhoneBook.get(name).add((String) some.getKey());
            }
            else
            {
                myNewPhoneBook.get(name).add((String) some.getKey());
            }
        }
        return myNewPhoneBook;
    }

    public Set<String> getAllContacts() {

        Set<String> getPhoneBookAllContacts = new TreeSet<>();

        for (String key : getVersaKeyName().keySet()) {
            getPhoneBookAllContacts.add(key + " - " + getVersaKeyName().get(key).toString().replaceAll("[\\[\\]]",""));
        }
        return getPhoneBookAllContacts;
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
