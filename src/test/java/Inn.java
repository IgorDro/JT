import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;




public class Inn {
  //Перейти к заполнению ПП.
  @Test
  public void Test1() {
    ChromeDriver driver = getChromeDriver();
    Login(driver,"1111111111", "1111111111");
    CreatePP(driver);

    WebElement inn = driver.findElement(By.cssSelector("#appframe > form > div.Layout__base--1cl9w > div.LayoutContent__base--2Eko8.PayDocRu__contentPayDocRuForm--2joTZ > div.PayDocRu__tabContent--muDt2.PayDocRu__mainTab--3jpGE > div:nth-child(5) > div.fieldGroup__body > div:nth-child(1) > div > div > div:nth-child(1) > div > div.field__control > input"));
    inn.click();
    String innText = inn.getAttribute("value");
    Assert.assertEquals("7728124050", innText);
  }
  //Установить показатель статуса налогоплательщика = 03, установить значение поля "ИНН плательщика" = 0, сохранить ПП
  @Test
  public void Test2(){
    ChromeDriver driver = getChromeDriver();
    Login(driver, "1111111111", "1111111111");
    CreatePP(driver);

    WebElement paymentBudget = driver.findElement(By.xpath("//*[@id=\"appframe\"]/form/div[1]/div[2]/div[1]/div[12]/div[1]/div/div"));
    paymentBudget.click();

    WebElement statusPP = driver.findElement(By.xpath("//*[@id=\"appframe\"]/form/div[1]/div[2]/div[1]/div[12]/div[2]/div/div[1]/div/div/div[1]/button"));
    statusPP.click();

    WebElement statusPP3 = driver.findElement(By.xpath("//*[@id=\"appframe\"]/form/div[1]/div[2]/div[1]/div[12]/div[2]/div/div[1]/div/div[2]/div[2]/div[1]/div/div/div[2]/div/div[2]/div[4]"));
    statusPP3.click();

    WebElement statusPPButtonApply = driver.findElement(By.xpath("//*[@id=\"appframe\"]/form/div[1]/div[2]/div[1]/div[12]/div[2]/div/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/div/button[2]/div"));
    statusPPButtonApply.click();

    WebElement inn = driver.findElement(By.cssSelector("#appframe > form > div.Layout__base--1cl9w > div.LayoutContent__base--2Eko8.PayDocRu__contentPayDocRuForm--2joTZ > div.PayDocRu__tabContent--muDt2.PayDocRu__mainTab--3jpGE > div:nth-child(5) > div.fieldGroup__body > div:nth-child(1) > div > div > div:nth-child(1) > div > div.field__control > input"));
    inn.click();

    WebElement innClose = driver.findElement(By.xpath("//*[@id=\"appframe\"]/form/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div/div/div[1]/div/div[2]/div"));
    innClose.click();
    inn.sendKeys("0");

    SavePP(driver);


    boolean flag = true;
    try{
      WebElement controlINN = driver.findElement(By.xpath("//*[@id=\"appframe\"]/form/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div/div/div[1]/div/div[2]/div[2]"));
    }
    catch (Exception ex){
      flag = false;
    }

    Assert.assertFalse(flag);
  }
  //Установить показатель статуса налогоплательщика = 05, установить значение поля "ИНН плательщика" = 0, сохранить ПП
  @Test
  public void Test3(){
    ChromeDriver driver = getChromeDriver();
    Login(driver,"1111111111", "1111111111");
    CreatePP(driver);

    WebElement paymentBudget = driver.findElement(By.xpath("//*[@id=\"appframe\"]/form/div[1]/div[2]/div[1]/div[12]/div[1]/div/div"));
    paymentBudget.click();

    WebElement statusPP = driver.findElement(By.xpath("//*[@id=\"appframe\"]/form/div[1]/div[2]/div[1]/div[12]/div[2]/div/div[1]/div/div/div[1]/button"));
    statusPP.click();

    WebElement statusPP5 = driver.findElement(By.xpath("//*[@id=\"appframe\"]/form/div[1]/div[2]/div[1]/div[12]/div[2]/div/div[1]/div/div[2]/div[2]/div[1]/div/div/div[2]/div/div[2]/div[6]"));
    statusPP5.click();

    WebElement statusPPButtonApply = driver.findElement(By.xpath("//*[@id=\"appframe\"]/form/div[1]/div[2]/div[1]/div[12]/div[2]/div/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/div/button[2]/div"));
    statusPPButtonApply.click();

    WebElement inn = driver.findElement(By.cssSelector("#appframe > form > div.Layout__base--1cl9w > div.LayoutContent__base--2Eko8.PayDocRu__contentPayDocRuForm--2joTZ > div.PayDocRu__tabContent--muDt2.PayDocRu__mainTab--3jpGE > div:nth-child(5) > div.fieldGroup__body > div:nth-child(1) > div > div > div:nth-child(1) > div > div.field__control > input"));
    inn.click();

    WebElement innClose = driver.findElement(By.xpath("//*[@id=\"appframe\"]/form/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div/div/div[1]/div/div[2]/div"));
    innClose.click();
    inn.sendKeys("0");

    SavePP(driver);

    boolean flag = true;
    try{
      WebElement controlINN = driver.findElement(By.xpath("//*[@id=\"appframe\"]/form/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div/div/div[1]/div/div[2]/div[2]"));
    }
    catch (Exception ex){
      flag = false;
    }

    Assert.assertFalse(flag);

  }
  //Установить показатель статуса налогоплательщика = 19, установить значение поля "ИНН плательщика" = 0, сохранить ПП
  @Test
  public void Test4() {
    ChromeDriver driver = getChromeDriver();
    Login( driver,"1111111111", "1111111111");
    CreatePP(driver);

    WebElement paymentBudget = driver.findElement(By.xpath("//*[@id=\"appframe\"]/form/div[1]/div[2]/div[1]/div[12]/div[1]/div/div"));
    paymentBudget.click();

    WebElement statusPP = driver.findElement(By.xpath("//*[@id=\"appframe\"]/form/div[1]/div[2]/div[1]/div[12]/div[2]/div/div[1]/div/div/div[1]/button"));
    statusPP.click();

    WebElement statusPP19 = driver.findElement(By.xpath("//*[@id=\"appframe\"]/form/div[1]/div[2]/div[1]/div[12]/div[2]/div/div[1]/div/div[2]/div[2]/div[1]/div/div/div[2]/div/div[2]/div[20]"));
    statusPP19.click();

    WebElement statusPPButtonApply = driver.findElement(By.xpath("//*[@id=\"appframe\"]/form/div[1]/div[2]/div[1]/div[12]/div[2]/div/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/div/button[2]/div"));
    statusPPButtonApply.click();

    WebElement inn = driver.findElement(By.cssSelector("#appframe > form > div.Layout__base--1cl9w > div.LayoutContent__base--2Eko8.PayDocRu__contentPayDocRuForm--2joTZ > div.PayDocRu__tabContent--muDt2.PayDocRu__mainTab--3jpGE > div:nth-child(5) > div.fieldGroup__body > div:nth-child(1) > div > div > div:nth-child(1) > div > div.field__control > input"));
    inn.click();

    WebElement innClose = driver.findElement(By.xpath("//*[@id=\"appframe\"]/form/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div/div/div[1]/div/div[2]/div"));
    innClose.click();
    inn.sendKeys("0");

    SavePP(driver);

    boolean flag = true;
    try{
      WebElement controlINN = driver.findElement(By.xpath("//*[@id=\"appframe\"]/form/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div/div/div[1]/div/div[2]/div[2]"));
    }
    catch (Exception ex){
      flag = false;
    }

    Assert.assertFalse(flag);
  }
  //Установить показатель статуса налогоплательщика любым, кроме 03; 05; 19, установить значение поля "ИНН плательщика" = 0, сохранить ПП
  @Test
  public void Test5() {
    ChromeDriver driver = getChromeDriver();
    Login(driver, "1111111111", "1111111111");
    CreatePP(driver);

    WebElement paymentBudget = driver.findElement(By.xpath("//*[@id=\"appframe\"]/form/div[1]/div[2]/div[1]/div[12]/div[1]/div/div"));
    paymentBudget.click();

    WebElement statusPP = driver.findElement(By.xpath("//*[@id=\"appframe\"]/form/div[1]/div[2]/div[1]/div[12]/div[2]/div/div[1]/div/div/div[1]/button"));
    statusPP.click();

    WebElement pagingALL = driver.findElement(By.xpath("//*[@id=\"appframe\"]/form/div[1]/div[2]/div[1]/div[12]/div[2]/div/div[1]/div/div[2]/div[2]/div[2]/div/div[2]/div/div/button[3]"));
    pagingALL.click();

    WebElement statusPP13 = driver.findElement(By.xpath("//*[@id=\"appframe\"]/form/div[1]/div[2]/div[1]/div[12]/div[2]/div/div[1]/div/div[2]/div[2]/div[1]/div/div/div[2]/div/div[2]/div[14]"));
    statusPP13.click();

    WebElement statusPPButtonApply = driver.findElement(By.xpath("//*[@id=\"appframe\"]/form/div[1]/div[2]/div[1]/div[12]/div[2]/div/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/div/button[2]/div"));
    statusPPButtonApply.click();

    WebElement inn = driver.findElement(By.cssSelector("#appframe > form > div.Layout__base--1cl9w > div.LayoutContent__base--2Eko8.PayDocRu__contentPayDocRuForm--2joTZ > div.PayDocRu__tabContent--muDt2.PayDocRu__mainTab--3jpGE > div:nth-child(5) > div.fieldGroup__body > div:nth-child(1) > div > div > div:nth-child(1) > div > div.field__control > input"));
    inn.click();

    WebElement innClose = driver.findElement(By.xpath("//*[@id=\"appframe\"]/form/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div/div/div[1]/div/div[2]/div"));
    innClose.click();
    inn.sendKeys("0");

    SavePP(driver);

    boolean flag = true;
    try{
      WebElement controlINN = driver.findElement(By.xpath("//*[@id=\"appframe\"]/form/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div/div/div[1]/div/div[2]/div[2]"));
    }
    catch (Exception ex){
      flag = false;
    }

    Assert.assertFalse(flag);
  }
  //Авторизоваться в системе от имени организации, ввести "ИНН плательщика" в 10 знаков., сохранить ПП
  @Test
  public void Test6() {
    ChromeDriver driver = getChromeDriver();
    Login( driver,"1111111111", "1111111111");
    CreatePP(driver);

    WebElement inn = driver.findElement(By.cssSelector("#appframe > form > div.Layout__base--1cl9w > div.LayoutContent__base--2Eko8.PayDocRu__contentPayDocRuForm--2joTZ > div.PayDocRu__tabContent--muDt2.PayDocRu__mainTab--3jpGE > div:nth-child(5) > div.fieldGroup__body > div:nth-child(1) > div > div > div:nth-child(1) > div > div.field__control > input"));
    inn.click();

    WebElement innClose = driver.findElement(By.xpath("//*[@id=\"appframe\"]/form/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div/div/div[1]/div/div[2]/div"));
    innClose.click();
    inn.sendKeys("7702070139");

    SavePP(driver);

    boolean flag = true;
    try{
      WebElement controlINN = driver.findElement(By.xpath("//*[@id=\"appframe\"]/form/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div/div/div[1]/div/div[2]/div[2]"));
    }
    catch (Exception ex){
      flag = false;
    }

    Assert.assertFalse(flag);
  }
  //Авторизоваться в системе от имени организации, ввести "ИНН плательщика" в 12 знаков., сохранить ПП
  @Test
  public void Test7() {
    ChromeDriver driver = getChromeDriver();
    Login(driver, "1111111111", "1111111111");
    CreatePP(driver);

    WebElement inn = driver.findElement(By.cssSelector("#appframe > form > div.Layout__base--1cl9w > div.LayoutContent__base--2Eko8.PayDocRu__contentPayDocRuForm--2joTZ > div.PayDocRu__tabContent--muDt2.PayDocRu__mainTab--3jpGE > div:nth-child(5) > div.fieldGroup__body > div:nth-child(1) > div > div > div:nth-child(1) > div > div.field__control > input"));
    inn.click();

    WebElement innClose = driver.findElement(By.xpath("//*[@id=\"appframe\"]/form/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div/div/div[1]/div/div[2]/div"));
    innClose.click();
    inn.sendKeys("563565286576");

    SavePP(driver);

    boolean flag = true;
    try{
      WebElement controlINN = driver.findElement(By.xpath("//*[@id=\"appframe\"]/form/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div/div/div[1]/div/div[2]/div[2]"));
    }
    catch (Exception ex){
      flag = false;
    }

    Assert.assertTrue(flag);
  }
  //Ввести в поле ИНН что-то, кроме цифр
  @Test
  public void Test8() {
    ChromeDriver driver = getChromeDriver();
    Login(driver, "1111111111", "1111111111");
    CreatePP(driver);

    WebElement inn = driver.findElement(By.cssSelector("#appframe > form > div.Layout__base--1cl9w > div.LayoutContent__base--2Eko8.PayDocRu__contentPayDocRuForm--2joTZ > div.PayDocRu__tabContent--muDt2.PayDocRu__mainTab--3jpGE > div:nth-child(5) > div.fieldGroup__body > div:nth-child(1) > div > div > div:nth-child(1) > div > div.field__control > input"));
    inn.click();

    WebElement innClose = driver.findElement(By.xpath("//*[@id=\"appframe\"]/form/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div/div/div[1]/div/div[2]/div"));
    innClose.click();
    inn.sendKeys("asdfasdf");

    String innText = inn.getAttribute("value");
    Assert.assertEquals("", innText);
  }
  //Ввести в поле ИНН > 12 цифр
  @Test
  public void Test9() {
    ChromeDriver driver = getChromeDriver();
    Login( driver,"1111111111", "1111111111");
    CreatePP(driver);

    WebElement inn = driver.findElement(By.cssSelector("#appframe > form > div.Layout__base--1cl9w > div.LayoutContent__base--2Eko8.PayDocRu__contentPayDocRuForm--2joTZ > div.PayDocRu__tabContent--muDt2.PayDocRu__mainTab--3jpGE > div:nth-child(5) > div.fieldGroup__body > div:nth-child(1) > div > div > div:nth-child(1) > div > div.field__control > input"));
    inn.click();

    WebElement innClose = driver.findElement(By.xpath("//*[@id=\"appframe\"]/form/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div/div/div[1]/div/div[2]/div"));
    innClose.click();
    inn.sendKeys("5635652865761");

    String innText = inn.getAttribute("value");
    Assert.assertEquals("563565286576", innText);
  }







  public ChromeDriver getChromeDriver() {
    ChromeDriver driver = new ChromeDriver();
    driver.get("http://stand.vtb.jtcc.ru:16006/");
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    return driver;
  }
  public void CreatePP(ChromeDriver driver) {
    WebElement createPP = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/div/a[2]"));
    createPP.click();
  }

  public void Login(ChromeDriver driver, String loginName, String passwordName) {
    WebElement login = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/form/div[3]/div[1]/div/input"));
    login.click();
    login.clear();
    login.sendKeys(loginName);

    WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/form/div[3]/div[2]/div/input"));
    password.click();
    password.clear();
    password.sendKeys(passwordName);


    WebElement buttonLogin = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/form/div[4]/button[1]"));
    buttonLogin.click();
  }
  public void SavePP(ChromeDriver driver) {
    WebElement savePP = driver.findElement(By.xpath("//*[@id=\"appframe\"]/form/div[1]/div[2]/div[2]/div/div/div/div/div[2]/div[1]/button"));
    savePP.click();
  }
}



