package homework1;

public class Task1 {
  public static void main(String[] args) {
    System.out.println(Check(2,8));
  }

  public static boolean Check(int a, int b) {
    if ((a + b) <= 20 && (a + b) >= 10)
      return true;
    else
      return false;
  }
}
