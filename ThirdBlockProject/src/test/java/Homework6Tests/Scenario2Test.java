package Homework6Tests;

import Homework6.pages.MainShopPage;
import Homework6Tests.BaseTest.BaseTest;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Поиск пунктов выдачи в Санкт Петербурге
public class Scenario2Test extends BaseTest {

  private static final Logger logger = LoggerFactory.getLogger(Scenario2Test.class);

  @Test
  public void scenario2Test() {

    logger.info("Search for pick-up points in St. Petersburg");

    new MainShopPage(driver)
      .addressesSearch()
      .searchCity("санкт-петербург")
      .clickKey(Keys.ENTER)
      .checkCityList();
  }
}
