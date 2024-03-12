import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//import java.util.List;
import java.util.Collections;

class Phones {
    // Добавляем номер в телефонную книгу:
    public static void addNumber(String key, int value, Map <String, ArrayList<Integer>> map) {
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }
    }
       // Печатаем список контактов:
    public static void printBook (Map<String, ArrayList<Integer>> map) {
        for (var item : map.entrySet()) {
            String phones = "";
            for (int el : item.getValue()) {
                phones = phones + el + "; ";
            }
            System.out.printf("%s: %s \n", item.getKey(), phones);
        }
    }
public static void main(String[] args) {
        Map <String, ArrayList <Integer>> bookPhone = new HashMap<>();
        addNumber("Ivanov", 123456, bookPhone);
        addNumber("Ivanov", 1234, bookPhone);
        addNumber("Petrov", 546585, bookPhone);
        addNumber("Sidorov", 8956477, bookPhone);
        addNumber("Ivanov", 12345678, bookPhone);
        addNumber("Petrov", 787897, bookPhone);
        System.out.print(bookPhone + "\n\n");
        // System.out.print(bookPhone + "\n\n");
        // System.out.println(bookPhone.get("Ivanov"));
        // var sort_vrem = new ArrayList<>(bookPhone.get("Ivanov"));
        // Collections.sort(sort_vrem, Collections.reverseOrder());
        // System.out.println(sort_vrem);
        // bookPhone.put("Ivanov", sort_vrem);

        //Перебираем Hashmap, используя цикл for с методом keySet():
        for (String key : bookPhone.keySet()) {
            var sort_vrem = new ArrayList<>(bookPhone.get(key));
            Collections.sort(sort_vrem, Collections.reverseOrder());
            bookPhone.put(key, sort_vrem);
        }
        printBook(bookPhone);
  
    }
}
