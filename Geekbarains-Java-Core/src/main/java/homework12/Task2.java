package homework12;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task2 {

  public static void main(String[] args) {
    String[][] array = {{"as", "qwe", "sfsdfs","hfj8", "hfjf"}, {"qwe", "ghjk", "ghjk", "as", "afsd"}};

    List<String> stringList =  Stream.of(array).flatMap(Arrays::stream)
                                               .collect(Collectors.toList());
    List<String> uniqueList = stringList.stream().filter(word -> Collections.frequency(stringList, word) == 1)
                            .collect(Collectors.toList());
    System.out.println(uniqueList);
  }
}
