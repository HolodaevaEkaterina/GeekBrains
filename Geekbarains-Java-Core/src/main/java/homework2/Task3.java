package homework2;

public class Task3 {
  public static void main(String[] args) {
    System.out.println(ConvertSecInHour(1));
  }

  public static String ConvertSecInHour(int sec) {
    int min = 0;
    int mod = 0;
    int hour = 0;
    int hourMod = 0;

    if (sec >= 60) {
      min = sec / 60;
      mod = sec % 60;
      hour = min / 60;
      hourMod = min % 60;
    }
    else mod = sec;
    if (hour > 23)
      return ("Too much");
    return String.format("%02d:%02d:%02d", hour, hourMod, mod);
  }
}
