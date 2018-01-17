import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
//import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class InfoBank {
  public ChromeDriver getChromeDriver() {
    ChromeDriver driver = new ChromeDriver();
    driver.get("http://stand.vtb.jtcc.ru:16006/");
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    return driver;
  }

  public void Login (ChromeDriver driver) {
    WebElement login = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/form/div[3]/div[1]/div/input"));
    login.click();
    login.clear();
    login.sendKeys("1111111111");

    WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/form/div[3]/div[2]/div/input"));
    password.click();
    password.clear();
    password.sendKeys("1111111111");


    WebElement buttonLogin = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/form/div[4]/button[1]"));
    buttonLogin.click();
  }

  public void DoubleClick(ChromeDriver driver, WebElement ppDone) {
    Actions builder = new Actions(driver);
    builder.doubleClick(ppDone).build().perform();
  }

  @Test
  public void Test1() {
    ChromeDriver driver = getChromeDriver();
    Login(driver);

    WebElement pp = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/div[1]/a[3]"));
    pp.click();

    try {
      TimeUnit.SECONDS.sleep(3);
    } catch (Exception ex) {
      ex.getStackTrace();
    }

    WebElement groupingDone = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[7]"));
    groupingDone.click();

    WebElement ppDone = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div[2]/div[2]"));
    ppDone.click();
    DoubleClick(driver, ppDone);

    WebElement infoBank = driver.findElement(By.xpath("//*[@id=\"appframe\"]/form/div[1]/div[1]/div[1]/div[2]/div/button[2]"));
    infoBank.click();

    WebElement receivingDocument = driver.findElement(By.xpath("//*[@id=\"appframe\"]/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div/div/input"));
    String receivingDocumentText = receivingDocument.getAttribute("value");

    WebElement executionDocument = driver.findElement(By.xpath("//*[@id=\"appframe\"]/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/div/div/input"));
    String executionDocumentText = executionDocument.getAttribute("value");

    WebElement messageFromBank = driver.findElement(By.xpath("//*[@id=\"appframe\"]/form/div[1]/div[2]/div[1]/div[3]/div/div/div[2]/div/div/textarea"));
    String  messageFromBankText = messageFromBank.getText();

    WebElement departmentReceivedDocument = driver.findElement(By.xpath("//*[@id=\"appframe\"]/form/div[1]/div[2]/div[1]/div[4]/div/div/div[2]/div/div/input"));
    String departmentReceivedDocumentText = departmentReceivedDocument.getAttribute("value");

    Assert.assertEquals("02.09.2017", receivingDocumentText);
    Assert.assertEquals("03.09.2017", executionDocumentText);
    Assert.assertEquals("kate", messageFromBankText);
    Assert.assertEquals("Ф. ОПЕРУ БАНКА ВТБ (ПАО) В САНКТ-ПЕТЕРБУРГЕ", departmentReceivedDocumentText);

  }


}
