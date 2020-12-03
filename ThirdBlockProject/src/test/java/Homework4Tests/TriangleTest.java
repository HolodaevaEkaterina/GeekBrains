package Homework4Tests;

import Homework4.AreaClass;
import io.qameta.allure.Feature;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class  TriangleTest {

  private static final Logger logger = LoggerFactory.getLogger(TriangleTest.class);

  private final AreaClass areaClass = new AreaClass();

  @Feature("Old tests")
  @ParameterizedTest(name = "can calculate square with sides {0} , {1} and  {2}, and result - {3}")
  @MethodSource("calculationProvider1")
  void CalculateArea_ExistTriangles_Cases(int a, int b, int c, double result){
    logger.info("Calculate square of triangle with sides: " + a + " " + b + " " + c);

    //act
    double actual =  areaClass.CalculateArea(a, b, c);

    assertEquals(result, actual);
  }

  @Feature("Old tests")
  @ParameterizedTest(name = "can`t calculate square with sides {0} , {1} and  {2}")
  @MethodSource("calculationProvider2")
  void CalculateArea_NonExistTriangles_Cases(int a, int b, int c){
    logger.info("Calculate square of triangle with sides: " + a + " " + b + " " + c);

    //act
    double actual =  areaClass.CalculateArea(a, b, c);

    assertEquals(-1, actual);
  }

  static Stream<Arguments> calculationProvider1() {
    return Stream.of(
      Arguments.of(5, 3, 4, 6), //прямоугольный
      Arguments.of(5, 5, 5, 10.825317547305483), //равносторонний
      Arguments.of(5, 5, 6, 12), //равнобедренный
      Arguments.of(8, 8, 14, 27.110883423451916) //тупоугольный
    );
  }

  static Stream<Arguments> calculationProvider2() {
    return Stream.of(
      Arguments.of(5, 5, 11), //сумма 2-ух сторон меньше третьей
      Arguments.of(5, 0, 5), //одна сторона 0
      Arguments.of(5, 5, 10) //сумма двух сторон равна 3
    );
  }
}
