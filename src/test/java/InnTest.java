import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import ru.yandex.qatools.allure.annotations.Title;

import static pages.Page.getDriver;

//проверяем можно ли закомитить
//Автотесты для https://jiraeu.epam.com/browse/VTBDBOTLAB-72

@Title("Проверки поля 'ИНН плательщика'")
public class InnTest {

  User user = new User("1111111111", "1111111111");

  @BeforeMethod
  public void setUp() {
    getDriver().get("http://stand.vtb.jtcc.ru:16006/");
  }

  @Title("Логинимся")
  @Test
  public void loginTest() {
    new LoginPage().Login(user)
            .createNewPP();
  }

  @Title("Перейти к заполнению ПП.")
  @Test
  public void test1() {
    new LoginPage().Login(user)
            .createNewPP()
            .clickINN();
    Assert.assertEquals("7728124050", CreatePP.innValue());
  }

  @Title("Установить показатель статуса налогоплательщика = 03, установить значение поля \"ИНН плательщика\" = 0, сохранить ПП")
  @Test
  public void test2() {
    new LoginPage().Login(user)
            .createNewPP()
            .clickINN()
            .clickPaymentBudget()
            .clickIndicatorsStatusPP()
            .clickRow("03")
            .clickButtonApply()
            .clearFieldDelete()
            .sendINN("0")
            .clickSavePP();
    Assert.assertFalse(CreatePP.flag( "//div[contains(text(), 'ИНН плательщика не прошел проверку контрольного числа')]"));
  }

  @Title("Установить показатель статуса налогоплательщика = 05, установить значение поля \"ИНН плательщика\" = 0, сохранить ПП")
  @Test
  public void test3() {
    new LoginPage().Login(user)
            .createNewPP()
            .clickINN()
            .clickPaymentBudget()
            .clickIndicatorsStatusPP()
            .clickRow("05")
            .clickButtonApply()
            .clearFieldDelete()
            .sendINN("0")
            .clickSavePP();
    Assert.assertFalse(CreatePP.flag( "//div[contains(text(), 'ИНН плательщика не прошел проверку контрольного числа')]"));
  }

  @Title("Установить показатель статуса налогоплательщика = 19, установить значение поля \"ИНН плательщика\" = 0, сохранить ПП")
  @Test
  public void test4() {
    new LoginPage().Login(user)
            .createNewPP()
            .clickINN()
            .clickPaymentBudget()
            .clickIndicatorsStatusPP()
            .clickRow("19")
            .clickButtonApply()
            .clearFieldDelete()
            .sendINN("0")
            .clickSavePP();
    Assert.assertFalse(CreatePP.flag("//div[contains(text(), 'ИНН плательщика не прошел проверку контрольного числа')]"));
  }

  @Title("Установить показатель статуса налогоплательщика любым, кроме 03; 05; 19, установить значение поля \"ИНН плательщика\" = 0, сохранить ПП")
  @Test
  public void test5() {
    new LoginPage().Login(user)
            .createNewPP()
            .clickINN()
            .clickPaymentBudget()
            .clickIndicatorsStatusPP()
            .clickPagingAll()
            .clickRow("23")
            .clickButtonApply()
            .clearFieldDelete()
            .sendINN("0")
            .clickSavePP();
    Assert.assertFalse(CreatePP.flag("//div[contains(text(), 'Поле инн плательщика обязательно для заполнения')]"));
  }

  @Title("Авторизоваться в системе от имени организации, ввести \"ИНН плательщика\" в 10 знаков., сохранить ПП")
  @Test
  public void test6() {
    new LoginPage().Login(user)
            .createNewPP()
            .clearFieldDelete()
            .sendINN("7702070139")
            .clickSavePP();
    Assert.assertFalse(CreatePP.flag("//div[contains(text(), 'ИНН плательщика не прошел проверку контрольного числа')]"));
  }

  @Title("Авторизоваться в системе от имени организации, ввести \"ИНН плательщика\" в 12 знаков., сохранить ПП")
  @Test
  public void test7() {
    new LoginPage().Login(user)
            .createNewPP()
            .clearFieldDelete()
            .sendINN("563565286576")
            .clickSavePP();
    Assert.assertTrue(CreatePP.flag("//div[contains(text(), 'ИНН плательщика не прошел проверку контрольного числа')]"));
  }

  @Title("Ввести в поле ИНН что-то, кроме цифр")
  @Test
  public void test8() {
    new LoginPage().Login(user)
            .createNewPP()
            .clearFieldDelete()
            .sendINN("asdfasdf")
            .clickPaymentBudget();
    Assert.assertEquals("", CreatePP.innValue());
  }

  @Title("Ввести в поле ИНН > 12 цифр")
  @Test
  public void test9() {
    new LoginPage().Login(user)
            .createNewPP()
            .clearFieldDelete()
            .sendINN("5635652865761");
    Assert.assertEquals("563565286576", CreatePP.innValue());
  }

}
