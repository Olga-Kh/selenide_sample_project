package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
  private SelenideElement userNameInput = $(By.id("login-form-username"));
  private SelenideElement userPassInput = $(By.id("login-form-password"));
  private SelenideElement loginButton = $(By.id("login"));
  private SelenideElement userPic = $(By.id("header-details-user-fullname"));
  private SelenideElement errorMessage = $(By.id("usernameerror"));

  public void navigateTo() {
    open("https://jira.hillel.it/secure/Dashboard.jspa");
  }

  public void enterUserName(String name) {
    userNameInput.setValue(name);
  }

  public void enterPassword(String password) {
    userPassInput.setValue(password);
  }

  public void clickLoginButton() {
    loginButton.click();
  }

  public void isUserIconPresent() {
    userPic.shouldBe(Condition.visible);
  }

  public void isErrorMessageDisplayed() {
    errorMessage.shouldBe(Condition.visible);
  }
}