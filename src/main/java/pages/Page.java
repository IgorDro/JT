package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;

import static jdk.nashorn.internal.objects.NativeString.toLowerCase;


public abstract class Page {

  protected static WebDriver driver;

  public Page() {
    PageFactory.initElements(driver, this);
  }

  public static WebDriver getDriver() {
    String theDefault = "firefox";

    if (driver == null)
      try {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName(getPropertyOrEnv("browserName", theDefault));
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
      } catch (MalformedURLException ex) {
        System.out.println("Что-то пошло не так опять");
      }
    // driver = new ChromeDriver();
    //driver = new FirefoxDriver();
    return driver;
  }

  public static String getPropertyOrEnv(String name, String theDefault) {
    String theValue = toLowerCase(System.getProperty(name));
    if (theValue == null) {
        theValue = theDefault;
    } else  if (theValue.equals("chrome")) {
      } else {
        theValue = theDefault;
      }
    return theValue;
  }
}