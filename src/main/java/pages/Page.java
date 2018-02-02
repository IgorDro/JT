package pages;

import com.sun.jna.Native;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.Scanner;

import static java.awt.SystemColor.textText;
import static java.awt.SystemColor.windowText;


public abstract class Page {

  protected static WebDriver driver;

  public Page() {
    PageFactory.initElements(driver, this);
  }

  public static WebDriver getDriver() {

//    String line, br = "";
//    try {
//    Scanner scanner = new Scanner(new FileReader("C:\\Webdrivers\\StartNode.bat"));
//    while(scanner.hasNextLine())
//    {
//      line = scanner.nextLine();
//      if (line.contains("set bro="))
//      {br = line.substring(8);
//        break;}
//    }} catch (IOException ex) {
//      System.out.println("Что-то пошло не так");
//    }


    String theDefault = "firefox";
//    Properties props = new Properties();
//    props = System.getProperties();



    if (driver == null)
      try {
        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setBrowserName(System.getProperty("browserName"));
//        caps.setCapability("browsername","chrome" );
        caps.setBrowserName(getPropertyOrEnv("browserName", theDefault));
//        caps.setBrowserName(props.getProperty("browserName"));
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
      } catch (MalformedURLException ex) {
        System.out.println("Что-то пошло не так опять");
      }


    // driver = new ChromeDriver();
    //driver = new FirefoxDriver();
    return driver;
  }

  public static String getPropertyOrEnv(String name, String theDefault) {
    String theValue = System.getProperty(name);
    if (theValue == null) {
      System.out.println("Свойство не найдено " + name);
      theValue = System.getenv(name);

      if (theValue == null) {
        System.out.println("Не удалось найти переменную " + name + " используйте значение по умолчанию " + theDefault);
        theValue = theDefault;
      } else {
        System.out.println("Используйте переменную " + name + " со значением " + theValue);
      }
    } else {
      System.out.println("Используйте свойство " + name + " со значением " + theValue);
    }
    return theValue;
  }



//  -DbrowserName=chrome
//
//  -browserName 'chrome' -platform 'win10'
}
