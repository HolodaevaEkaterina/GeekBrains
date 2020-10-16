package homework2;

public class Task1 {
  public static void main(String[] args) {
    String str3 = new String(new char[4]);
    System.out.println(str3.length());
    DrawTriangle(5);
  }
  public static void DrawTriangle(int length) {
    for (int j = 0; j < length; j++) {
      int k = 0;
      while (k != j) {
        System.out.print(" ");
        k++;
      }
      for (int i = 0; i < length - j; i++) {
        System.out.print(" * ");
      }
      System.out.println();
    }
  }
}
