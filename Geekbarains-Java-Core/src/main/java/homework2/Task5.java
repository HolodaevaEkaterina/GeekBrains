package homework2;

import java.util.Arrays;
import java.util.Random;

public class Task5 {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6};
    System.out.println(Arrays.toString(MixArray(arr)));
  }

  public static int[] MixArray(int[] arr) {
    Random rnd = new Random();
    int length = arr.length;
    for(int i = 0; i < arr.length; i++) {
      int r = rnd.nextInt(length - 1);
      int k = arr[i];
      arr[i] = arr[r];
      arr[r] = k;
    }
    return arr;
  }
}
