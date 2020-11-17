package homework12;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task5 {

  public static void main(String[] args) {
    String[] strings = {"vzs", "bgbhjj", "dfrgbdd", "kleur"};
    List<String> firstStrings = Stream.of(strings).sorted().limit(3).collect(Collectors.toList());
    System.out.println(firstStrings);
  }
}
