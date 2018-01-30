package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;


public class CreatePP extends Page {
  @FindBy (xpath = "//input[contains(@placeholder,'ИНН/КИО')]")
  private static WebElement inn;

  @FindBy (xpath = "//div[@class = 'fieldGroup fieldGroup_collapsable fieldGroup_closed']")
  private WebElement paymentBudget;

  @FindBy (xpath = "//button[contains(text(),'Пок. ст.')]")
  private WebElement indicatorsStatusPP;

  @FindBy (xpath = "//.//div[text()='Сохранить']")
  private WebElement savePP;

  @Step ("Кликаем по полю ИНН\\КИО")
  public CreatePP clickINN () {
    inn.click();
    return this;
  }

  @Step("Очищаем поле ИНН\\КИО")
  public CreatePP clearINN() {
    inn.clear();
    return this;
  }

  @Step("Вставляем значение в поле ИНН\\КИО")
  public CreatePP sendINN(String innNumber) {
    inn.sendKeys(innNumber);
    return this;
  }

  @Step("Вставка горячих клавиш")
  public CreatePP sendHotKey(Keys hotkey){
    inn.sendKeys(hotkey);
    return this;
  }

  @Step("Очищаем поле ИНН/КИО")
  public CreatePP clearFieldDelete() {
    inn.click();
    inn.sendKeys(Keys.CONTROL, "a");
    inn.sendKeys(Keys.DELETE);
    return this;
  }

  @Step("Получение значения в поле ИНН\\КИО")
  public static String innValue() {
    String innValue = inn.getAttribute("value");
    return innValue;
  }

  @Step("Раскрываем блок 'Платеж в бюджет РФ'")
  public CreatePP clickPaymentBudget() {
    paymentBudget.click();
    return this;
  }

  @Step("Открываем форму показатели статуса")
  public IndicatorsStatusPP clickIndicatorsStatusPP() {
    indicatorsStatusPP.click();
    return new IndicatorsStatusPP();
  }
  @Step("Жмем 'Сохранить'")
  public CreatePP clickSavePP() {
    savePP.click();
    return this;
  }

  @Step("Проверка срабатывания контроля, окно с контролем на которм сработал контроль")
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
