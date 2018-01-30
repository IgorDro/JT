package pages;

public class User {
  private String login;
  private String password;

  public User(String login, String password) {
    this.login = login;
    this.password = password;
  }

  public void setLogin(String login) {
    this.login = login;
  }
  public String getLogin() {
    return login;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "Логин: " + login + " Пароль: " + password;
  }
}
