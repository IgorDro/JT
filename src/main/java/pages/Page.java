package pages;

import jdk.nashorn.internal.objects.NativeString;
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
      //System.out.println("Свойство не найдено " + theValue);
      theValue = System.getenv(name);
     // if (theValue == null) {
     //   System.out.println("Не удалось найти переменную, используйте значение по умолчанию " + theDefault);
        theValue = theDefault;
    //  } else {
      //  System.out.println("Используйте переменную, со значением " + theValue);
     // }
    } else  if (theValue.equals("chrome")) {
      //  System.out.println("Используйте свойств, со значением " + theValue);
      return toLowerCase(theValue);
      } else {
      //  System.out.println("Такого браузера нет или используется по умолчанию, используйте значение по умолчанию " + theDefault);
        theValue = theDefault;
      }
    return toLowerCase(theValue);
  }
}