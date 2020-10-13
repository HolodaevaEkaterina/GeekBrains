package homework1;

import java.util.Arrays;
import java.util.Random;

public class Task9 {
  public static void main(String[] args) {
    int[] arr = new int[10];

    Random rnd = new Random();
    for(int i = 0; i < arr.length; i++)
      arr[i] = rnd.nextInt();

    System.out.println(Arrays.toString(arr));

    int max = 0;
    int min = 0;
    for(int i = 0; i < arr.length; i++)
      if (i == 0) {
        max = arr[i];
        min = arr[i];
      }
      else if (arr[i] > max)
      max = arr[i];
      else if (arr[i] < min)
        min = arr[i];

    System.out.println("Максимальный элемент:" + max);
    System.out.println("Минимальный элемент:" + min);
  }
}
