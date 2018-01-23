import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;




public class Inn {
  //Перейти к заполнению ПП.
  @Test
  public void Test1() {
    ChromeDriver driver = getChromeDriver();
    Login(driver,"1111111111", "1111111111");
    CreatePP(driver);

    WebElement inn = Innn(driver);
    String innText = inn.getAttribute("value");
    Assert.assertEquals("7728124050", innText);
    driver.quit();
  }
  //Установить показатель статуса налогоплательщика = 03, установить значение поля "ИНН плательщика" = 0, сохранить ПП
  @Test
  public void Test2(){
    ChromeDriver driver = getChromeDriver();
    Login(driver, "1111111111", "1111111111");
    CreatePP(driver);
    PaymentBudget(driver);
    StatusPP(driver);

    WebElement statusPP3 = driver.findElement(By.xpath("//div[contains(@class,'table__row')]//div[contains(.,'03')]//ancestor::div[contains(@class,'table__row')]"));
    statusPP3.click();

    StatusPPButtonApply(driver);
    WebElement inn = Innn(driver);
    inn.clear();
    inn.sendKeys("0");
    SavePP(driver);

    boolean flag = true;
    try{
      ControlINN(driver, "//div[contains(text(), 'Поле инн плательщика обязательно для заполнения')]");
    }
    catch (Exception ex){
      flag = false;
    }
    Assert.assertFalse(flag);
    driver.quit();
  }
  //Установить показатель статуса налогоплательщика = 05, установить значение поля "ИНН плательщика" = 0, сохранить ПП
  @Test
  public void Test3(){
    ChromeDriver driver = getChromeDriver();
    Login(driver,"1111111111", "1111111111");
    CreatePP(driver);
    PaymentBudget(driver);
    StatusPP(driver);

    WebElement statusPP5 = driver.findElement(By.xpath("//div[contains(@class,'table__row')]//div[contains(.,'05')]//ancestor::div[contains(@class,'table__row')]"));
    statusPP5.click();

    StatusPPButtonApply(driver);
    WebElement inn = Innn(driver);
    inn.clear();
    inn.sendKeys("0");
    SavePP(driver);

    boolean flag = true;
    try{
      ControlINN(driver, "//div[contains(text(), 'Поле инн плательщика обязательно для заполнения')]");
    }
    catch (Exception ex){
      flag = false;
    }
    Assert.assertFalse(flag);
    driver.quit();

  }
  //Установить показатель статуса налогоплательщика = 19, установить значение поля "ИНН плательщика" = 0, сохранить ПП
  @Test
  public void Test4() {
    ChromeDriver driver = getChromeDriver();
    Login( driver,"1111111111", "1111111111");
    CreatePP(driver);
    PaymentBudget(driver);
    StatusPP(driver);

    WebElement statusPP19 = driver.findElement(By.xpath("//div[contains(@class,'table__row')]//div[contains(.,'19')]//ancestor::div[contains(@class,'table__row')]"));
    statusPP19.click();

    StatusPPButtonApply(driver);
    WebElement inn = Innn(driver);
    inn.clear();
    inn.sendKeys("0");
    SavePP(driver);

    boolean flag = true;
    try{
      ControlINN(driver, "//div[contains(text(), 'Поле инн плательщика обязательно для заполнения')]");
    }
    catch (Exception ex){
      flag = false;
    }

    Assert.assertFalse(flag);
    driver.quit();
  }
  //Установить показатель статуса налогоплательщика любым, кроме 03; 05; 19, установить значение поля "ИНН плательщика" = 0, сохранить ПП
  @Test
  public void Test5() {
    ChromeDriver driver = getChromeDriver();
    Login(driver, "1111111111", "1111111111");
    CreatePP(driver);
    PaymentBudget(driver);
    StatusPP(driver);

    PagingAll(driver, "//span[contains(text(), 'Все')]");

    WebElement statusPP13 = driver.findElement(By.xpath("//div[contains(@class,'table__row')]//div[contains(.,'13')]//ancestor::div[contains(@class,'table__row')]"));

    statusPP13.click();

    StatusPPButtonApply(driver);
    WebElement inn = Innn(driver);
    inn.clear();
    inn.sendKeys("0");

    SavePP(driver);

    boolean flag = true;
    try{
      ControlINN(driver, "//div[contains(text(), 'Поле инн плательщика обязательно для заполнения')]");
    }
    catch (Exception ex){
      flag = false;
    }

    Assert.assertFalse(flag);
    driver.quit();
  }
  //Авторизоваться в системе от имени организации, ввести "ИНН плательщика" в 10 знаков., сохранить ПП
  @Test
  public void Test6() {
    ChromeDriver driver = getChromeDriver();
    Login( driver,"1111111111", "1111111111");
    CreatePP(driver);
    WebElement inn = Innn(driver);
    inn.click();
    inn.clear();
    inn.sendKeys("7702070139");
    SavePP(driver);

    boolean flag = true;
    try{
      ControlINN(driver, "//div[contains(text(), 'ИНН плательщика не прошел проверку контрольного числа')]");
    }
    catch (Exception ex){
      flag = false;
    }

    Assert.assertFalse(flag);
    driver.quit();
  }
  //Авторизоваться в системе от имени организации, ввести "ИНН плательщика" в 12 знаков., сохранить ПП
  @Test
  public void Test7() {
    ChromeDriver driver = getChromeDriver();
    Login(driver, "1111111111", "1111111111");
    CreatePP(driver);
    WebElement inn = Innn(driver);
    inn.clear();
    inn.sendKeys("563565286576");
    SavePP(driver);

    boolean flag = true;
    try{
      ControlINN(driver, "//div[contains(text(), 'ИНН плательщика не прошел проверку контрольного числа')]");
    }
    catch (Exception ex){
      flag = false;
    }

    Assert.assertTrue(flag);
    driver.quit();
  }
  //Ввести в поле ИНН что-то, кроме цифр
  @Test
  public void Test8() {
    ChromeDriver driver = getChromeDriver();
    Login(driver, "1111111111", "1111111111");
    CreatePP(driver);
    WebElement inn = Innn(driver);
    inn.clear();
    inn.sendKeys("asdfasdf");
    String innText = inn.getAttribute("value");
    Assert.assertEquals("", innText);
    driver.quit();
  }
  //Ввести в поле ИНН > 12 цифр
  @Test
  public void Test9() {
    ChromeDriver driver = getChromeDriver();
    Login( driver,"1111111111", "1111111111");
    CreatePP(driver);
    WebElement inn = Innn(driver);
    inn.clear();
    inn.sendKeys("5635652865761");
    String innText = inn.getAttribute("value");
    Assert.assertEquals("563565286576", innText);
    driver.quit();
  }


  public ChromeDriver getChromeDriver() {
    ChromeDriver driver = new ChromeDriver();
    driver.get("http://stand.vtb.jtcc.ru:16006/");
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    return driver;
  }
  public void CreatePP(ChromeDriver driver) {
    WebElement createPP = driver.findElement(By.xpath("//div[contains(text(),'Создать ПП')]"));
    createPP.click();
  }
  public void Login(ChromeDriver driver, String loginName, String passwordName) {
    WebElement login = driver.findElement(By.xpath("//input[contains(@placeholder,'Логин')]"));
    login.click();
    login.clear();
    login.sendKeys(loginName);

    WebElement password = driver.findElement(By.xpath("//input[contains(@placeholder,'Пароль')]"));
    password.click();
    password.clear();
    password.sendKeys(passwordName);


    WebElement buttonLogin = driver.findElement(By.xpath("//button[contains(text(),'Войти')]"));
    buttonLogin.click();
  }
  public void SavePP(ChromeDriver driver) {
    WebElement savePP = driver.findElement(By.xpath("//.//div[text()='Сохранить']"));
    savePP.click();
  }
  public WebElement Innn(ChromeDriver driver) {
    WebElement inn = driver.findElement(By.xpath("//input[contains(@placeholder,'ИНН/КИО')]"));
    inn.click();
    return inn;
  }
  public void StatusPPButtonApply(ChromeDriver driver) {
    WebElement statusPPButtonApply = driver.findElement(By.xpath("//div[contains(text(),'Применить')]"));
    statusPPButtonApply.click();
  }
  public void StatusPP(ChromeDriver driver) {
    WebElement statusPP = driver.findElement(By.xpath("//button[contains(text(),'Пок. ст.')]"));
    statusPP.click();
  }
  public void PaymentBudget(ChromeDriver driver) {
    WebElement paymentBudget = driver.findElement(By.xpath("//div[@class = 'fieldGroup fieldGroup_collapsable fieldGroup_closed']"));
    paymentBudget.click();
  }
  public void ControlINN(ChromeDriver driver, String s) {
  WebElement controlINN = driver.findElement(By.xpath(s));
  }
  public void PagingAll(ChromeDriver driver, String s) {
    WebElement pagingALL = driver.findElement(By.xpath(s));
    pagingALL.click();
  }
}



