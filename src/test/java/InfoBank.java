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
    WebElement login = driver.findElement(By.xpath("//input[contains(@placeholder,'Логин')]"));
    login.click();
    login.clear();
    login.sendKeys("1111111111");

    WebElement password = driver.findElement(By.xpath("//input[contains(@placeholder,'Пароль')]"));
    password.click();
    password.clear();
    password.sendKeys("1111111111");


    WebElement buttonLogin = driver.findElement(By.xpath("//button[contains(text(),'Войти')]"));
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

    WebElement pp = driver.findElement(By.xpath("//a[contains(text(),'Расчеты в рублях')]"));
    pp.click();

    try {
      TimeUnit.SECONDS.sleep(3);
    } catch (Exception ex) {
      ex.getStackTrace();
    }

    WebElement groupingDone = driver.findElement(By.xpath("//div[contains(@class,'MenuFilters__menuFiltersItem--2Wlau')]//span[contains(.,'Исполнены')]//ancestor::div[contains(@class,'MenuFilters__menuFiltersItem--2Wlau')]"));
    groupingDone.click();

    WebElement ppDone = driver.findElement(By.xpath("//div[contains(@class,'table__row')]//span[contains(.,'1109')]//ancestor::div[contains(@class,'table__row')]"));
    ppDone.click();
    DoubleClick(driver, ppDone);

    WebElement infoBank = driver.findElement(By.xpath("//span[contains(.,'Информация из банка')]"));
    infoBank.click();

    WebElement receivingDocument = driver.findElement(By.xpath("//input[@value = '02.09.2017']"));
    String receivingDocumentText = receivingDocument.getAttribute("value");

    WebElement executionDocument = driver.findElement(By.xpath("//input[@value = '03.09.2017']"));
    String executionDocumentText = executionDocument.getAttribute("value");

    WebElement messageFromBank = driver.findElement(By.xpath("//textarea"));
    String  messageFromBankText = messageFromBank.getText();

    WebElement departmentReceivedDocument = driver.findElement(By.xpath("//input[@value = 'Ф. ОПЕРУ БАНКА ВТБ (ПАО) В САНКТ-ПЕТЕРБУРГЕ']"));
    String departmentReceivedDocumentText = departmentReceivedDocument.getAttribute("value");


    Assert.assertEquals("02.09.2017", receivingDocumentText);
    Assert.assertEquals("03.09.2017", executionDocumentText);
    Assert.assertEquals("kate", messageFromBankText);
    Assert.assertEquals("Ф. ОПЕРУ БАНКА ВТБ (ПАО) В САНКТ-ПЕТЕРБУРГЕ", departmentReceivedDocumentText);
    driver.quit();

  }


}
