package homework1;

import java.util.Arrays;

public class Task5 {
  public static void main(String[] args) {
    int[] binaryArr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

    for (int i = 0; i < binaryArr.length; i++) {
      if (binaryArr[i] == 0)
        binaryArr[i] = 1;
      else
        binaryArr[i] = 0;
    }
    System.out.println(Arrays.toString(binaryArr));
  }
}
