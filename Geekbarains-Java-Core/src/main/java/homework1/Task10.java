package homework1;

public class Task10 {
  public static void main(String[] args) {
    CheckLeap(1800);
  }

  public static void CheckLeap(int year) {
    if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0))
      System.out.println("Год високосный");
    else
      System.out.println("Год не високосный");
  }
}
