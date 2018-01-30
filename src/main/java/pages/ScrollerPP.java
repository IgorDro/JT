package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class ScrollerPP extends Page {
  @FindBy (xpath = "//button[contains(.,'Исполнены')]")
  private WebElement groupingDone;

  @FindBy (xpath = "//div[contains(@class,'table__row')]//div[contains(.,'1109')]//ancestor::div[contains(@class,'table__row')]")
  public static WebElement ppDone;

  @FindBy(xpath = "//button[contains(.,'Информация из банка')]")
  private WebElement infoBank;


  @Step("Выбор групировки 'Исполнены'")
  public ScrollerPP clickGroupingDone() {
    new WebDriverWait(getDriver(),10).until(ExpectedConditions.elementToBeClickable(groupingDone)).click();
    return new ScrollerPP();
  }

  @Step("Переход к документам с групированным по 'Исполнены'")
  public ScrollerPP clickPPDone() {
    new WebDriverWait(getDriver(),10).until(ExpectedConditions.elementToBeClickable(ppDone)).click();
    return this;
  }

  @Step("Двойной клик")
  public ScrollerPP DoubleClick(WebElement ppDone) {
    Actions builder = new Actions(getDriver());
    builder.doubleClick(ppDone).build().perform();
    return this;
  }

  @Step("Переход к информации из банка")
  public ScrollerPP clickInfoBank() {
    new WebDriverWait(getDriver(),10).until(ExpectedConditions.elementToBeClickable(infoBank)).click();
    return this;
  }
}
