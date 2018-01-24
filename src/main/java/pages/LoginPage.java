package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage extends Page {


  @FindBy(xpath = "//input[contains(@placeholder,'Логин')]")
  private WebElement loginField;

  @FindBy(xpath = "//input[contains(@placeholder,'Пароль')]")
  private WebElement passwordField;

  @FindBy(xpath = "//button[contains(text(),'Войти')]")
  private WebElement submitButton;


  public HomePage Login(User user) {
    loginField.click();
    loginField.clear();
    loginField.sendKeys(user.getLogin());
    passwordField.click();
    passwordField.clear();
    passwordField.sendKeys(user.getPassword());
    submitButton.click();
    return new HomePage();

  }
}
