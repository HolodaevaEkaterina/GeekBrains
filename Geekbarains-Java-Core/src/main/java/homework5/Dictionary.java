package homework5;

import java.util.Arrays;

public class Dictionary {

  private final Pair[] pairs;

  public Dictionary(int size) {
    this.pairs = new Pair[size];
  }

  public String get(String key) {
    for(Pair pair : pairs) {
      if(pair.getKey().equals(key)) {
        return pair.getValue();
      }
    }
    return "";
  }

  public void put(String key, String value) {
    int count =0;
    for(int i = 0; i < pairs.length; i++)
      if(pairs[i] == null) {
        pairs[i] = new Pair(key, value);
        count++;
        break;
      }
    if(count == 0)
      System.out.println("Мест нет");
  }

  public void delete(String key) {
    for(int i = 0;i < pairs.length; i++) {
      if(pairs[i] == null)
        continue;
      if(key.equals(pairs[i].getKey())) {
         pairs[i] = null;
      }
    }
  }

  public static void main(String[] args) {
    Dictionary dict = new Dictionary(10);
    dict.put("1", "word1");
    dict.put("3", "word3");
    var word1 = dict.get("1");
    var word3 = dict.get("3");
    System.out.println(word1);
    System.out.println(word3);
    dict.delete("1");
  }

  private static class Pair {
    private final String key;

    private final String value;

    public Pair(String key, String value) {
      this.key = key;
      this.value = value;
    }

    public String getKey() {
      return key;
    }

    public String getValue() {
      return value;
    }
  }
}
