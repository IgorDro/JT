package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PP extends Page {
  @FindBy (xpath = "//div[contains(@class,'MenuFilters__menuFiltersItem--2Wlau')]//button[contains(.,'Исполнены')]//ancestor::div[contains(@class,'MenuFilters__menuFiltersItem--2Wlau')]")
  private WebElement groupingDone;

  @FindBy (xpath = "//div[contains(@class,'table__row')]//span[contains(.,'1109')]//ancestor::div[contains(@class,'table__row')]")
  public WebElement ppDone;

  @FindBy (xpath = "//span[contains(.,'Информация из банка')]")
  private WebElement infoBank;


  // Выбор групировки "Исполнены"
  public void clickGroupingDone() {
    new WebDriverWait(getDriver(),10).until(ExpectedConditions.elementToBeClickable(groupingDone)).click();
  }

  //Переход к документам с групированным по "Исполнены"
  public void clickPPDone() {
    new WebDriverWait(getDriver(),10).until(ExpectedConditions.elementToBeClickable(ppDone)).click();
  }

  //Двойной клик
  public void DoubleClick(WebElement ppDone) {
    Actions builder = new Actions(getDriver());
    builder.doubleClick(ppDone).build().perform();
  }

  //Переход к Информации из банка
  public InfoBank clickInfoBank() {
    new WebDriverWait(getDriver(),10).until(ExpectedConditions.elementToBeClickable(infoBank)).click();
    return new InfoBank();
  }

}
