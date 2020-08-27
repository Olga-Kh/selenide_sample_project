package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AddCommentPage {

  private SelenideElement commentIssue = $(By.id("comment-issue"));
  private SelenideElement comment = $(By.id("comment"));
  private SelenideElement submitComment = $(By.id("issue-comment-add-submit"));
  private SelenideElement lastComment = $(By.xpath("//div[@id='issue_actions_container']//div[last()]//p"));
  private SelenideElement deleteIcon = $(By.xpath("//div[@id='issue_actions_container']//div[last()]//div[@class='action-links']//a[last()]"));
  private SelenideElement deleteButton = $(By.id("comment-delete-submit"));
  private SelenideElement noCommentsMessage = $(By.xpath("//div[@class='message-container']"));

    public void navigateToTicket() {
    open("https://jira.hillel.it/browse/WEBINAR-12197");
  }

  public void clickCommentIssue() {
    commentIssue.click();
  }

  public void isCommentFieldclickable() {
    comment.shouldBe(Condition.visible);
  }

  public void clickCommentField() {
    comment.click();
  }

  public void inputCommentField(String commentText) {
    comment.setValue(commentText);
  }

  public void isSubmitCommentClickable() {
    submitComment.shouldBe(Condition.visible);
  }

  public void clickSubmitComment() {
    submitComment.click();
  }

  public void isCommentAdded() {
    lastComment.shouldBe(Condition.visible);
  }

  public boolean commentContainsText(String text) {
    String lastCommentText = lastComment.getText();
    return lastCommentText.contains(text);
  }

  public void clickDeleteIcon () {
    deleteIcon.click();
  }

  public void isDeleteButtonClickable() {
    deleteButton.shouldBe(Condition.visible);
  }

  public void clickDeleteButton () {
    deleteButton.click();
  }

  public void isNoCommentsMessageDisplayed() {
    noCommentsMessage.shouldBe(Condition.visible);
  }

  public boolean isNoCommentsTextDisplayed(String text) {
    String emptyComments = noCommentsMessage.getText();
    return emptyComments.contains(text);
  }
}