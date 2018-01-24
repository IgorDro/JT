package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page {

  @FindBy(xpath = "//div[contains(text(),'Создать ПП')]")
  private WebElement createPP;

  @FindBy(xpath = "//a[contains(text(),'Расчеты в рублях')]")
  private WebElement pp;

  public void createNewPP() {
    createPP.click();
  }

  public void openPagePP() {
    pp.click();
  }
}
