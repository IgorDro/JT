package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CreatePP extends Page {
  @FindBy (xpath = "//input[contains(@placeholder,'ИНН/КИО')]")
  private WebElement inn;

  @FindBy (xpath = "//div[@class = 'fieldGroup fieldGroup_collapsable fieldGroup_closed']")
  private WebElement paymentBudget;

  @FindBy (xpath = "//button[contains(text(),'Пок. ст.')]")
  private WebElement indicatorsStatusPP;

  @FindBy (xpath = "//.//div[text()='Сохранить']")
  private WebElement savePP;

//  @FindBy(xpath = "//div[contains(text(), 'Поле инн плательщика обязательно для заполнения')]")
//  private WebElement controlINN;

//  @FindBy(xpath = "//div[contains(text(), 'ИНН плательщика не прошел проверку контрольного числа')]")
//  private WebElement controlINN1;

  //Кликаем по полю ИНН\КИО
  public void clickINN () {
    inn.click();
  }

  //Очищаем поле ИНН\КИО
  public void clearINN() {
    inn.clear();
  }

  //Вставляем значение в поле ИНН\КИО
  public void sendINN(String innNumber) {
    inn.sendKeys(innNumber);
  }

  public void sendHotKey(Keys hotkey){
    inn.sendKeys(hotkey);
  }

  public void sendChordKeys(CharSequence[] charSequences) {
    inn.sendKeys(Keys.chord(charSequences));
  }

  //Получение значения в поле ИНН\КИО
  public String innValue() {
    String innValue = inn.getAttribute("value");
    return innValue;
  }

  //Раскрываем блок "Платеж в бюджет РФ"
  public void clickPaymentBudget() {
    paymentBudget.click();
  }

  //Открываем форму показатели статуса
  public void clickIndicatorsStatusPP() {
    indicatorsStatusPP.click();
  }
  //Жмем "Сохранить"
  public void clickSavePP() {
    savePP.click();
  }

  public boolean flag(String xpathExpression) {
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
