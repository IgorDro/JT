package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PP extends Page {
  @FindBy (xpath = "//div[contains(@class,'MenuFilters__menuFiltersItem--2Wlau')]//button[contains(.,'Исполнены')]//ancestor::div[contains(@class,'MenuFilters__menuFiltersItem--2Wlau')]")
  private WebElement groupingDone;

  @FindBy (xpath = "//div[contains(@class,'table__row')]//span[contains(.,'1109')]//ancestor::div[contains(@class,'table__row')]")
  public WebElement ppDone;

  @FindBy (xpath = "//span[contains(.,'Информация из банка')]")
  private WebElement infoBank;


  public void clickGroupingDone() {
    groupingDone.click();
  }

    public void clickPPDone() {
    ppDone.click();
  }

  public void DoubleClick(WebElement ppDone) {
    Actions builder = new Actions(getDriver());
    builder.doubleClick(ppDone).build().perform();
  }

  public void clickInfoBank() {
    infoBank.click();
  }

}
