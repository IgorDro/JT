package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CreatePP extends Page {
  @FindBy (xpath = "//input[contains(@placeholder,'ИНН/КИО')]")
  private static WebElement inn;

  @FindBy (xpath = "//div[@class = 'fieldGroup fieldGroup_collapsable fieldGroup_closed']")
  private WebElement paymentBudget;

  @FindBy (xpath = "//button[contains(text(),'Пок. ст.')]")
  private WebElement indicatorsStatusPP;

  @FindBy (xpath = "//.//div[text()='Сохранить']")
  private WebElement savePP;

  //Кликаем по полю ИНН\КИО
  public CreatePP clickINN () {
    inn.click();
    return this;
  }

  //Очищаем поле ИНН\КИО
  public CreatePP clearINN() {
    inn.clear();
    return this;
  }

  //Вставляем значение в поле ИНН\КИО
  public CreatePP sendINN(String innNumber) {
    inn.sendKeys(innNumber);
    return this;
  }

  //Вставка горячих клавиш
  public CreatePP sendHotKey(Keys hotkey){
    inn.sendKeys(hotkey);
    return this;
  }

  //Очищаем поле ИНН/КИО
  public CreatePP clearFieldDelete() {
    inn.click();
    inn.sendKeys(Keys.CONTROL, "a");
    inn.sendKeys(Keys.DELETE);
    return this;
  }

  //Получение значения в поле ИНН\КИО
  public static String innValue() {
    String innValue = inn.getAttribute("value");
    return innValue;
  }

  //Раскрываем блок "Платеж в бюджет РФ"
  public CreatePP clickPaymentBudget() {
    paymentBudget.click();
    return this;
  }

  //Открываем форму показатели статуса
  public IndicatorsStatusPP clickIndicatorsStatusPP() {
    indicatorsStatusPP.click();
    return new IndicatorsStatusPP();
  }
  //Жмем "Сохранить"
  public CreatePP clickSavePP() {
    savePP.click();
    return this;
  }

  //Проверка срабатывания контроля, окно с контролем на которм сработал контроль
  public static boolean flag(String xpathExpression) {
    boolean flag = true;
    try{
      WebElement controlINN = getDriver().findElement((By.xpath(xpathExpression)));
      controlINN.isDisplayed();
    }
    catch (Exception ex){
      flag = false;
    }
    return flag;
  }
}
