package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class HomePage extends Page {

  @FindBy(xpath = "//div[contains(text(),'Создать ПП')]")
  private WebElement createPP;

  @FindBy(xpath = "//a[contains(text(),'Расчеты в рублях')]")
  private WebElement pp;

  @Step("Создать ПП")
  public CreatePP createNewPP() {
    new WebDriverWait(getDriver(),10).until(ExpectedConditions.elementToBeClickable(createPP)).click();
    return new CreatePP();
  }

  @Step("Переход в 'Расчеты в рублях'")
  public ScrollerPP openPagePP() {
    new WebDriverWait(getDriver(),10).until(ExpectedConditions.elementToBeClickable(pp)).click();
    return new ScrollerPP();
  }
}
