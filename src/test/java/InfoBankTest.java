import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import static pages.Page.getDriver;
import static pages.ScrollerPP.ppDone;

//Автотесты для https://jiraeu.epam.com/browse/VTBDBOTLAB-339

public class InfoBankTest {
  User user = new User("1111111111", "1111111111");

  @BeforeMethod
  public void setUp() {
    getDriver().get("http://stand.vtb.jtcc.ru:16006/");
  }

  @Test
  public void Test1() {
    new LoginPage().Login(user)
            .openPagePP()
            .clickGroupingDone()
            .clickPPDone()
            .DoubleClick(ppDone)
            .clickInfoBank();

    Assert.assertEquals("02.09.2017",InfoBank.getValueReceivingDocument("//input[@value = '02.09.2017']"));
    Assert.assertEquals("03.09.2017", InfoBank.getValueExecutionDocument("//input[@value = '03.09.2017']"));
    Assert.assertEquals("kate", InfoBank.getValueMessageFromBank("//textarea"));
    Assert.assertEquals("Ф. ОПЕРУ БАНКА ВТБ (ПАО) В САНКТ-ПЕТЕРБУРГЕ", InfoBank.getValueDepartmentReceivedDocument("//input[@value = 'Ф. ОПЕРУ БАНКА ВТБ (ПАО) В САНКТ-ПЕТЕРБУРГЕ']"));

  }
}
