import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ViewIssuePage;

public class ViewIssue {

  LoginPage loginPage;
  ViewIssuePage viewIssue;

  @BeforeMethod
  public void setUp() {
    Configuration.browser = "chrome";
    loginPage = new LoginPage();
    viewIssue = new ViewIssuePage();
  }

  @Test
  public void successfulViewTicket() {
    loginPage.navigateTo();
    loginPage.enterUserName("OlgaKhobina");
    loginPage.enterPassword("OlgaKhobina");
    loginPage.clickLoginButton();
    loginPage.isUserIconPresent();

    viewIssue.openIssuesDropdown();
    viewIssue.isFirstIssueDisplayed();
    viewIssue.clickFirstIssue();
    viewIssue.isIssueTypeDisplayed();
    viewIssue.isTicketNumberInUrl();
  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
}