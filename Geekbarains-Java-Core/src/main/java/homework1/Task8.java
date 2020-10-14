package homework1;

import java.util.Arrays;

public class Task8 {
  public static void main(String[] args) {
    int[][] arr = new int[2][2];

    for(int i = 0; i < arr.length; i++)
      for(int j = 0; j < arr.length; j++)
        if (i == j)
          arr[i][j] = 1;
        else
          arr[i][j] = 0;

    for(int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        System.out.print(arr[i][j] + "\t");
      }
      System.out.println();
    }
  }
}
