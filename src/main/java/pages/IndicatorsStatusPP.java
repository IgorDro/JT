package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class IndicatorsStatusPP extends Page {

  @FindBy(xpath = "//div[contains(text(),'Применить')]")
  private WebElement buttonApply;

  @FindBy(xpath = "//button[contains(., 'Все')]")
  private WebElement pagingAll;

  //Выбор строки из списка
  public void clickRow(String rowNumber) {
    List<WebElement> rows = getDriver().findElements(By.xpath("//div[contains(@class,'table__row')]"));
    boolean find = false;
    for (WebElement row : rows) {
      try {
        row.findElement(By.xpath(".//div[contains(.,'" + rowNumber + "')]//ancestor::div[contains(@class,'table__row')]"));
        find = true;
      } catch (Exception ex) {
      }
      if (find) {
        row.click();
        break;
      }
    }
  }

  //Кнопка "Применить"
  public void clickButtonApply() {
    buttonApply.click();
  }

  //Кнопка "Все"
  public void clickPagingAll() {
    pagingAll.click();
    new WebDriverWait(getDriver(), 10).until(ExpectedConditions.attributeContains(pagingAll, "class", "Active"));
  }
}
