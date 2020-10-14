package homework1;

public class Task3 {
  public static void main(String[] args) {
    System.out.println(ChooseNegative(-9));
  }

  public static boolean ChooseNegative(int a) {
    if (a < 0)
      return true;
    else
      return false;
  }
}
