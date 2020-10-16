package homework2;

import java.util.Arrays;

public class Task2 {
  public static void main(String[] args) {
    int[] arr = new int[] {72, 142, 3, -8, -69874, 74, 487};
    System.out.println(Arrays.toString(Sort(arr)));
  }

  public static int[] Sort(int[] arr) {
    for(int i = 0; i < arr.length; i++) {
      int x;
      int[] k = SearchMin(arr, i);
      x = arr[i];
      arr[i] = k[0];
      arr[k[1]] = x;
    }
    return arr;
  }

  public static int[] SearchMin(int[] arr, int begin) {
    int min = 0;
    int index = 0;
    for(int i = begin; i < arr.length; i++)
      if (i == begin || arr[i] < min) {
        min = arr[i];
        index = i;
      }
    return new int[]{min, index};

  }
}
