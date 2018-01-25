import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import static pages.Page.getDriver;

public class InnTest {

  User user = new User("1111111111", "1111111111");

  @BeforeMethod
  public void setUp() {
    getDriver().get("http://stand.vtb.jtcc.ru:16006/");
  }

  //Логинимся
  @Test
  public void loginTest() {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = loginPage.Login(user);
    homePage.createNewPP();
  }

  //Перейти к заполнению ПП.
  @Test
  public void Test1() {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = loginPage.Login(user);
    CreatePP createPP = homePage.createNewPP();
    createPP.clickINN();
    Assert.assertEquals("7728124050", createPP.innValue());
  }

  //Установить показатель статуса налогоплательщика = 03, установить значение поля "ИНН плательщика" = 0, сохранить ПП
  @Test
  public void Test2() {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = loginPage.Login(user);
    CreatePP createPP = homePage.createNewPP();
    createPP.clickINN();
    createPP.clickPaymentBudget();
    IndicatorsStatusPP indicatorsStatusPP = createPP.clickIndicatorsStatusPP();
    indicatorsStatusPP.clickRow("03");
    indicatorsStatusPP.clickButtonApply();
    createPP.clearFieldDelete();
    createPP.sendINN("0");
    createPP.clickSavePP();
    Assert.assertFalse(createPP.flag( "//div[contains(text(), 'ИНН плательщика не прошел проверку контрольного числа')]"));
  }

  //Установить показатель статуса налогоплательщика = 05, установить значение поля "ИНН плательщика" = 0, сохранить ПП
  @Test
  public void Test3() {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = loginPage.Login(user);
    CreatePP createPP = homePage.createNewPP();
    createPP.clickINN();
    createPP.clickPaymentBudget();
    IndicatorsStatusPP indicatorsStatusPP = createPP.clickIndicatorsStatusPP();
    indicatorsStatusPP.clickRow("05");
    indicatorsStatusPP.clickButtonApply();
    createPP.clearFieldDelete();
    createPP.sendINN("0");
    createPP.clickSavePP();
    Assert.assertFalse(createPP.flag( "//div[contains(text(), 'ИНН плательщика не прошел проверку контрольного числа')]"));
  }

  //Установить показатель статуса налогоплательщика = 19, установить значение поля "ИНН плательщика" = 0, сохранить ПП
  @Test
  public void Test4() {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = loginPage.Login(user);
    CreatePP createPP = homePage.createNewPP();
    createPP.clickINN();
    createPP.clickPaymentBudget();
    IndicatorsStatusPP indicatorsStatusPP = createPP.clickIndicatorsStatusPP();
    indicatorsStatusPP.clickRow("19");
    indicatorsStatusPP.clickButtonApply();
    createPP.clearFieldDelete();
    createPP.sendINN("0");
    createPP.clickSavePP();
    Assert.assertFalse(createPP.flag("//div[contains(text(), 'ИНН плательщика не прошел проверку контрольного числа')]"));
  }

  //Установить показатель статуса налогоплательщика любым, кроме 03; 05; 19, установить значение поля "ИНН плательщика" = 0, сохранить ПП
  @Test
  public void Test5() {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = loginPage.Login(user);
    CreatePP createPP = homePage.createNewPP();
    createPP.clickINN();
    createPP.clickPaymentBudget();
    IndicatorsStatusPP indicatorsStatusPP = createPP.clickIndicatorsStatusPP();
    indicatorsStatusPP.clickPagingAll();
    indicatorsStatusPP.clickRow("23");
    indicatorsStatusPP.clickButtonApply();
    createPP.clearFieldDelete();
    createPP.sendINN("0");
    createPP.clickSavePP();
    Assert.assertFalse(createPP.flag("//div[contains(text(), 'Поле инн плательщика обязательно для заполнения')]"));
  }

  //Авторизоваться в системе от имени организации, ввести "ИНН плательщика" в 10 знаков., сохранить ПП
  @Test
  public void Test6() {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = loginPage.Login(user);
    CreatePP createPP = homePage.createNewPP();
    createPP.clearFieldDelete();
    createPP.sendINN("7702070139");
    createPP.clickSavePP();
    Assert.assertFalse(createPP.flag("//div[contains(text(), 'ИНН плательщика не прошел проверку контрольного числа')]"));
  }

  ////Авторизоваться в системе от имени организации, ввести "ИНН плательщика" в 12 знаков., сохранить ПП
  @Test
  public void Test7() {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = loginPage.Login(user);
    CreatePP createPP = homePage.createNewPP();
    createPP.clearFieldDelete();
    createPP.sendINN("563565286576");
    createPP.clickSavePP();
    Assert.assertTrue(createPP.flag("//div[contains(text(), 'ИНН плательщика не прошел проверку контрольного числа')]"));
  }

  //Ввести в поле ИНН что-то, кроме цифр
  @Test
  public void Test8() {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = loginPage.Login(user);
    CreatePP createPP = homePage.createNewPP();
    createPP.clearFieldDelete();
    createPP.sendINN("asdfasdf");
    createPP.clickPaymentBudget();
    Assert.assertEquals("", createPP.innValue());
  }

  //Ввести в поле ИНН > 12 цифр
  @Test
  public void Test9() {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = loginPage.Login(user);
    CreatePP createPP = homePage.createNewPP();
    createPP.clearFieldDelete();
    createPP.sendINN("5635652865761");
    Assert.assertEquals("563565286576", createPP.innValue());
  }

}
