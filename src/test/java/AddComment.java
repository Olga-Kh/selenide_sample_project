import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddCommentPage;
import pages.CreateIssuePage;
import pages.LoginPage;

public class AddComment {
  LoginPage loginPage = null;
  CreateIssuePage createIssue = null;
  AddCommentPage addComment = null;

  @BeforeMethod
  public void setUp(){
    Configuration.browser = "chrome";
    loginPage = new LoginPage();
    createIssue = new CreateIssuePage();
    addComment = new AddCommentPage();
  }

  @Test
  public void addCommentToTicket() {
    loginPage.navigateTo();
    loginPage.enterUserName("OlgaKhobina");
    loginPage.enterPassword("OlgaKhobina");
    loginPage.clickLoginButton();
    loginPage.isUserIconPresent();

    addComment.navigateToTicket();
    addComment.clickCommentIssue();

    addComment.isCommentFieldclickable();
    addComment.clickCommentField();
    addComment.inputCommentField("Very important comment");
    addComment.isSubmitCommentClickable();
    addComment.clickSubmitComment();

    addComment.isCommentAdded();
    addComment.commentContainsText("Very important comment");

    addComment.clickDeleteIcon();
    addComment.isDeleteButtonClickable();
    addComment.clickDeleteButton();

    addComment.isNoCommentsMessageDisplayed();
    addComment.isNoCommentsTextDisplayed("There are no comments yet on this issue.");
  }
}