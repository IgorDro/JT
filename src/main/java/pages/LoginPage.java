package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;


public class LoginPage extends Page {


  @FindBy(xpath = "//input[contains(@placeholder,'Логин')]")
  private WebElement loginField;

  @FindBy(xpath = "//input[contains(@placeholder,'Пароль')]")
  private WebElement passwordField;

  @FindBy(xpath = "//button[contains(text(),'Войти')]")
  private WebElement submitButton;

  @Step("Аутентификация пользателем {0}")
  public HomePage Login(User user) {
    loginField.click();
    loginField.clear();
    loginField.sendKeys(user.getLogin());
    passwordField.click();
    passwordField.clear();
    passwordField.sendKeys(user.getPassword());
    new WebDriverWait(getDriver(),10).until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    return new HomePage();
  }
}
