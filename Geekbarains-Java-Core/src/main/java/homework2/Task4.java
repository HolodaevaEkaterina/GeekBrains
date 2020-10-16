package homework2;

import java.util.Arrays;

public class Task4 {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    System.out.println(Arrays.toString(Reverse(arr)));
  }

  public static int[] Reverse(int[] arr) {
    int length = arr.length;
    int half = length / 2;
    for (int i = 0; i < half; i++) {
      int k = arr[i];
      arr[i] = arr[length - i - 1];
      arr[length - i - 1] = k;
    }
    return arr;
  }
}
