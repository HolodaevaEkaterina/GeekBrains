package homework1;

public class Task11 {
  public static void main(String[] args) {
    int[] arr = {3, 1, 1, 3};
    System.out.println(Check(arr));
  }
  public static boolean Check(int[] arr) {
    int sum = 0;
    int partSum = 0;
    for(int i = 0; i < arr.length; i++ )
      sum += arr[i];

    for(int i = 0; i < arr.length; i++ ) {
      partSum += arr[i];
      if (partSum == sum - partSum)
        return true;
    }
    return false;
  }
}
