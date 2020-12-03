package Homework7;

import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotMaker {

  @Attachment(type = "image/png")
  public static byte[] makeScreenshot(WebDriver driver, String filename) {
    byte[] temp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    //File destination = new File("./target/" + filename);
    return temp;
  }
}
