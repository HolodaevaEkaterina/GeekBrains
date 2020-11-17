package homework12;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;
import java.util.stream.Stream;

public class Task1 {

  public static void main(String[] args) {
    Random rnd = new Random();
    StringBuilder builder = new StringBuilder();
    for(int i = 0; i < 100; i++) {
      builder.append(RandomStringUtils.random(rnd.nextInt(7) + 1,true, false));
      builder.append(" ");
    }
    String str = builder.toString();
    System.out.println(str);
    String result = Stream.of(str.split(" "))
                          .filter(x -> x.length() == 5)
                          .reduce("", (a, b) -> a + " " + b + " ");

    System.out.println(result);
  }
}
