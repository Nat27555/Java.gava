package finaltask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    public static void main(String[] args) {

        // Создаю HashMap телефонной книги
        HashMap<String, List<String>> phoneBook = new HashMap<>();

        addContact(phoneBook, "Петр Крутов", "123456789");
        addContact(phoneBook, "Петр Крутов", "987654321");
        addContact(phoneBook, "Иван Селиванов", "23232323");
        addContact(phoneBook, "Петр Крутов", "5656565655");
        addContact(phoneBook, "Михаил Сергеев", "789654332");
        addContact(phoneBook, "Павел ", "8765845362");
        addContact(phoneBook, "Михаил Сергеев", "8382546374");

        System.out.println("Исходный phoneBook: " + phoneBook);
        System.out.println();
        printPhoneBook(phoneBook);

    }

    private static void addContact(Map<String, List<String>> phoneBook, String name, String phone){
        phoneBook.computeIfAbsent(name, k -> new ArrayList<>()).add(phone);
    }
    private static void printPhoneBook(Map<String, List<String>> phoneBook) {
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());

        entries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));

        for (Map.Entry<String, List<String>> entry : entries) {
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();

            System.out.println( name + ": " + phoneNumbers);
        }
    }
}