import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CreateIssuePage;
import pages.LoginPage;

public class CreateIssue {

  LoginPage loginPage = null;
  CreateIssuePage createIssue = null;

  @BeforeMethod
  public void setUp() {
    Configuration.browser = "chrome";
    loginPage = new LoginPage();
    createIssue = new CreateIssuePage();
  }

  @Test
  public void successfulCreateTicket() {
    loginPage.navigateTo();
    loginPage.enterUserName("OlgaKhobina");
    loginPage.enterPassword("OlgaKhobina");
    loginPage.clickLoginButton();
    loginPage.isUserIconPresent();

    createIssue.clickIssueCreate();
    createIssue.isProjectFieldDisplayed();
    createIssue.clickProjectField();
    createIssue.inputProjectField("Webinar (WEBINAR)");
    createIssue.leaveProjectField();

    createIssue.isIssueTypeFieldClickable();
    createIssue.clickIssueType();
    createIssue.inputIssueType("Test");
    createIssue.leaveIssueType();

    createIssue.isSummaryFieldVisible();
    createIssue.inputSummary("Summary");

    createIssue.isReporterFieldVisible();
    createIssue.clearReporterField();
    createIssue.inputReporter("OlgaKhobina");
    createIssue.leaveReporterField();

    createIssue.clickTextTab();
    createIssue.clickDescriptionField();
    createIssue.inputDescription("Some description");

    createIssue.clickSubmitIssue();
    createIssue.isSuccessPopupDisplayed();
  }
}