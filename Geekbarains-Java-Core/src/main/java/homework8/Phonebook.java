package homework8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phonebook {

  private final Map<String, String> book;

  public Phonebook(Map<String, String> book) {
    this.book = book;
  }

  public void add(String phone, String surname) {
    String frequency = book.get(phone);
    if (frequency != null) {
      System.out.printf("В справочнике уже есть номер %s%n",phone);
    }
    else {
      book.put(phone, surname);
    }
  }

  public String get(String surname) {
    List<String> phones = new ArrayList<>();
    for(String item : book.keySet()) {
      if(book.get(item).toLowerCase().equals(surname.toLowerCase())) {
        phones.add(item);
      }
    }
    if(phones.isEmpty()) {
      System.out.printf("Фамилии %s в справочнике нет%n", surname);
      return "";
    }
    else {
      return phones.toString();
    }
  }

  public void print() {
    System.out.println(book);
  }

  public static void main(String[] args) {
    Map<String, String> book = new HashMap<>();
    book.put("217-78-89","Belov");
    book.put("852-78-89","Belov");
    book.put("225-78-89","Krasnov");

    Phonebook phonebook = new Phonebook(book);
    phonebook.add("123-78-78","Ivanov");
    phonebook.add("123-78-78","Lebedev");
    phonebook.print();
    System.out.println(phonebook.get("Belov"));
    System.out.println(phonebook.get("Ivanov"));
    System.out.println(phonebook.get("ivanov"));
    System.out.println(phonebook.get("Lebedev"));
  }
}
