package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends Page {

  @FindBy(xpath = "//div[contains(text(),'Создать ПП')]")
  private WebElement createPP;

  @FindBy(xpath = "//a[contains(text(),'Расчеты в рублях')]")
  private WebElement pp;

  public CreatePP createNewPP() {
    new WebDriverWait(getDriver(),10).until(ExpectedConditions.elementToBeClickable(createPP)).click();
    return new CreatePP();
  }

  public PP openPagePP() {
    new WebDriverWait(getDriver(),10).until(ExpectedConditions.elementToBeClickable(pp)).click();
    return new PP();
  }
}
