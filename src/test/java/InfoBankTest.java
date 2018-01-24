import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

import static pages.Page.getDriver;

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
    homePage.openPagePP();
    PP pp = new PP();
    try {
      TimeUnit.SECONDS.sleep(3);
    } catch (Exception ex) {
      ex.getStackTrace();
    }

    pp.clickGroupingDone();
    pp.clickPPDone();
    pp.DoubleClick(pp.ppDone);
    pp.clickInfoBank();
    InfoBank infoBank = new InfoBank();

    Assert.assertEquals("02.09.2017",infoBank.getValueReceivingDocument());
    Assert.assertEquals("03.09.2017", infoBank.getValueExecutionDocument());
    Assert.assertEquals("kate", infoBank.getValueMessageFromBank());
    Assert.assertEquals("Ф. ОПЕРУ БАНКА ВТБ (ПАО) В САНКТ-ПЕТЕРБУРГЕ", infoBank.getValueDepartmentReceivedDocument());

  }
}
