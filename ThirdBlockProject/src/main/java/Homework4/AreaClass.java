package Homework4;

public class AreaClass {
  public static void main(String[] args) {

  }
  public double CalculateArea(int a, int b, int c) {
    if (a + b > c && a + c > b && b + c > a && a != 0 && b != 0  && c != 0) {
      double p = ((double)a + (double)b + (double)c) / 2;
      return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
    else {
     return -1;
    }
  }
}
