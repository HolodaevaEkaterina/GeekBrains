package homework8;

import homework4.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Homework8 {

  public static void main(String[] args) {
    String[] words = {"sun", "wind","tea", "sun", "super", "sea","phone", "bottle", "tea", "knife", "cake",
      "cup", "phone", "sun", "cake"};
    System.out.println(fillHashMap(words));
    System.out.println(findUniqueWords(words));
  }

  public static Map<String, Integer>  fillHashMap(String[] words) {
    Map<String, Integer> hashMap = new HashMap<>();
    for (String word : words) {
      Integer frequency = hashMap.get(word);
      hashMap.put(word, frequency == null ? 1 : hashMap.get(word) + 1);
    }
    return hashMap;
  }

  public static List<String> findUniqueWords(String[] words) {
    List<String> listUniqueWords = new ArrayList<>();
    Map<String, Integer> hashMap = fillHashMap(words);
    for(String word : hashMap.keySet()) {
      if(hashMap.get(word) == 1) {
        listUniqueWords.add(word);
      }
    }
    return listUniqueWords;
  }
}
