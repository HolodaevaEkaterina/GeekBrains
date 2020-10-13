package homework1;

import java.util.Arrays;

public class Task6 {
  public static void main(String[] args) {
    int[] arr = new int[8];

    for(int i = 0; i < arr.length; i++)
      arr[i] = 3 * i + 2;

    System.out.println(Arrays.toString(arr));
  }
}
