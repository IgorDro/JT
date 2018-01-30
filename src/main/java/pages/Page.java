package pages;

import com.sun.jna.Native;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import static java.awt.SystemColor.windowText;


public abstract class Page {

    protected static WebDriver driver;

    public Page(){
      PageFactory.initElements(driver, this);
    }

    public static WebDriver getDriver() {
      if (driver == null)
       driver = new ChromeDriver();
     //driver = new FirefoxDriver();
      return driver;
  }
}
