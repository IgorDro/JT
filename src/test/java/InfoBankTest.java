import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import static pages.Page.getDriver;

//Автотесты для https://jiraeu.epam.com/browse/VTBDBOTLAB-339

public class InfoBankTest {
  User user = new User("1111111111", "1111111111");

  @BeforeMethod
  public void setUp() {
    getDriver().get("http://stand.vtb.jtcc.ru:16006/");
  }

  @Test
  public void Test1() {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = loginPage.Login(user);
    PP pp = homePage.openPagePP();
    pp.clickGroupingDone();
    pp.clickPPDone();
    pp.DoubleClick(pp.ppDone);
    InfoBank infoBank = pp.clickInfoBank();

    Assert.assertEquals("02.09.2017",infoBank.getValueReceivingDocument("//input[@value = '02.09.2017']"));
    Assert.assertEquals("03.09.2017", infoBank.getValueExecutionDocument("//input[@value = '03.09.2017']"));
    Assert.assertEquals("kate", infoBank.getValueMessageFromBank("//textarea"));
    Assert.assertEquals("Ф. ОПЕРУ БАНКА ВТБ (ПАО) В САНКТ-ПЕТЕРБУРГЕ", infoBank.getValueDepartmentReceivedDocument("//input[@value = 'Ф. ОПЕРУ БАНКА ВТБ (ПАО) В САНКТ-ПЕТЕРБУРГЕ']"));

  }
}
