package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public abstract class Page {

    protected static WebDriver driver;

    public Page(){
      PageFactory.initElements(driver, this);
    }

    public static WebDriver getDriver() {
      if (driver == null)
        driver = new ChromeDriver();

      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
      return driver;
  }
}
