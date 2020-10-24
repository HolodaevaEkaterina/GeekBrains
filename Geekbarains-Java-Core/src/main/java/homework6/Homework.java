package homework6;

public class Homework {

  public static void main(String[] args) {
    try {
      String[][] arr1 = {{"1", "2"},{"3", "4"}};
      String[][] arr2 = {{"1", "2", "3", "4"},{"1", "2", "3", "4"},{"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
      String[][] arr3 = {{"1", "2", "a", "4"},{"1", "2", "3", "4"},{"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
      System.out.println(convertAndSum(arr3));
    } catch (MyArrayDataException | MyArraySizeException e){
      e.printStackTrace();
    }
  }

  public static int convertAndSum(String[][] arr) throws MyArraySizeException, MyArrayDataException{
    if (arr.length != 4) {
      throw new MyArraySizeException("Неверный размер массива");
    }
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        try {
          sum += Integer.parseInt(arr[i][j]);
        } catch (NumberFormatException e){
          throw new MyArrayDataException("Невозможно конвертировать данные в ячейке [" + i +',' + j + ']');
        }
      }
    }
    return sum;
  }
}
