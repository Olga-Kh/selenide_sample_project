import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class LoginToJiraTest {
  LoginPage loginPage;

  @BeforeMethod
  public void setUp() {
    Configuration.browser = "chrome";
    loginPage = new LoginPage();
  }

  @DataProvider(name = "Logins")
  public Object[][] createData() {
    return new Object[][]{
            {"OlgaKhobina", "wrongPassword"},
            {"wrongUserName", "OlgaKhobina"},
    };
  }

  @Test(dataProvider = "Logins")
  public void unsuccessfulLoginTest(String name, String password) throws InterruptedException {
    loginPage.navigateTo();
    loginPage.enterUserName(name);
    loginPage.enterPassword(password);
    loginPage.clickLoginButton();
    loginPage.isErrorMessageDisplayed();
  }

  @Test
  public void successfulLoginTest() {
    loginPage.navigateTo();
    loginPage.enterUserName("OlgaKhobina");
    loginPage.enterPassword("OlgaKhobina");
    loginPage.clickLoginButton();
    loginPage.isUserIconPresent();
    closeWebDriver();
  }
}