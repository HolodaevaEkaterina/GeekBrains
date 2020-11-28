package Homework6Tests;

import Homework6.pages.MainShopPage;
import Homework6Tests.BaseTest.BaseTest;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Scenario1Test extends BaseTest {

  private static final Logger logger = LoggerFactory.getLogger(Scenario1Test.class);

  //Поиск книг "Война и мир"
  @Feature("Searching")
  @Test
  public void scenario1Test() {
    logger.info("Search for books \"War and Peace\"");

    new MainShopPage(driver)
       .clickSearch()
       .enterText("война и мир")
       .clickKey(Keys.ENTER)
       .checkSearchingResult();
  }
}
