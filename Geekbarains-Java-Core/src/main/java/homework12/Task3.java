package homework12;

import java.util.stream.Stream;

public class Task3 {

  public static void main(String[] args) {
    int sum = Stream.iterate(100, item -> item < 201, item -> item + 2)
                                      .reduce(0, Integer::sum);
    System.out.println(sum);
  }
}
