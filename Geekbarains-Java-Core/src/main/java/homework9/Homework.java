package homework9;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Homework {

  public static void main(String[] args) {
    System.out.println(countOccurrences("Hello", "testFile.txt"));
    concatFiles("testDirectory");
    deleteDir("testDirectory");
  }

  public static int countOccurrences(String sequence, String path) {
    try {
      return Files.lines(Path.of(path)).mapToInt(x -> count(sequence, x)).sum();
    } catch (IOException e) {
      e.printStackTrace();
      return 0;
    }
  }

  public static int count(String seq, String line) {
    Pattern pattern = Pattern.compile(seq);
    Matcher matcher = pattern.matcher(line);
    int count = 0;
    while (matcher.find()) {
      count++;
    }
    return count;
  }

  public static void concatFiles(String path) {
    try {
      if(!Files.exists(Path.of("newFile.txt"))) {
        Files.createFile(Path.of("newFile.txt"));
      }
      List<Path> files = Files.walk(Paths.get(path))
        .filter(Files::isRegularFile)
        .collect(Collectors.toList());
      StringBuilder sb = new StringBuilder();
      for(Path file : files) {
        Files.lines(file).forEach(sb::append);
      }
      byte[] byteArr = sb.toString().getBytes();
      Files.write(Paths.get("newFile.txt"),byteArr);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void deleteDir(String path) {
    File file = new File(path);
    if (!file.exists())
      return;

    if (file.isDirectory()) {
      for (File f : Objects.requireNonNull(file.listFiles())) {
        deleteDir(f.getPath());
      }
    }
    file.delete();
  }
}
