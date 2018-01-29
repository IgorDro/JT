package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;


public abstract class Page {

    protected static WebDriver driver;

    public Page(){
      PageFactory.initElements(driver, this);
    }

    public static WebDriver getDriver() {
      if (driver == null)
      //  driver = new ChromeDriver();
     driver = new FirefoxDriver();
      return driver;
  }
}
