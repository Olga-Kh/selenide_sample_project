package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CreateIssuePage {
  private SelenideElement createButton = $(By.id("create_link"));
  private SelenideElement projectField = $(By.id("project-field"));
  private SelenideElement issueTypeField = $(By.id("issuetype-field"));
  private SelenideElement summaryInputField = $(By.id("summary"));
  private SelenideElement reporterField = $(By.id("reporter-field"));
  private SelenideElement textTab = $(By.xpath("(//div[@id='description-wiki-edit']//a[contains(text(),'Text')])"));
  private SelenideElement descriptionField = $(By.id("description"));
  private SelenideElement submitIssue = $(By.id("create-issue-submit"));
  private SelenideElement successPopup = $(By.className("aui-message-success"));

  public void clickIssueCreate() {
    createButton.click();
  }

  public void isProjectFieldDisplayed() {
    projectField.shouldBe(Condition.visible);
  }

  public void clickProjectField() {
    projectField.click();
  }

  public void inputProjectField(String project) {
    projectField.setValue(project);
  }

  public void leaveProjectField() {
    projectField.pressTab();
  }
  public void isIssueTypeFieldClickable() {
    issueTypeField.shouldBe(Condition.visible);
  }

  public void clickIssueType() {
    issueTypeField.click();
  }

  public void inputIssueType(String issue) {
    issueTypeField.setValue(issue);
  }

  public void leaveIssueType() {
    issueTypeField.pressTab();
  }

  public void isSummaryFieldVisible() {
    summaryInputField.shouldBe(Condition.visible);
  }

  public void inputSummary(String summary) {
    summaryInputField.setValue(summary);
  }

  public void isReporterFieldVisible() {
    reporterField.shouldBe(Condition.visible);
  }

  public void clearReporterField() {
    reporterField.clear();
  }

  public void inputReporter(String reporterName) {
    reporterField.setValue(reporterName);
  }

  public void leaveReporterField() {
    reporterField.pressTab();
  }

  public void clickTextTab() {
    textTab.click();
  }

  public void clickDescriptionField() {
    descriptionField.click();
  }

  public void inputDescription(String descrText) {
    descriptionField.sendKeys(descrText);
  }

  public void clickSubmitIssue() {
    submitIssue.click();
  }

  public void isSuccessPopupDisplayed() {
    successPopup.shouldBe(Condition.visible);
  }
}