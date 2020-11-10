package homework12;

import java.util.stream.Stream;

public class Task4 {
  public static void main(String[] args) {
    String[] strings = {"qw", "asd", "a", "qazwsx"};
    int count = Stream.of(strings).reduce("",(a, b) -> (a + b)).length();
    System.out.println(count);
  }
}
