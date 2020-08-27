package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;

public class ViewIssuePage {
  private SelenideElement issuesDropdown = $(By.id("find_link"));
  private SelenideElement firstIssueInDropdown = $(By.xpath("//div[@id='issues_history_main']//ul/li[1]"));
  private SelenideElement issueType = $(By.id("type-val"));
  private SelenideElement ticketNumber = $(By.id("key-val"));

  public void openIssuesDropdown() {
    issuesDropdown.click();
  }

  public void isFirstIssueDisplayed() {
    firstIssueInDropdown.shouldBe(Condition.visible);
  }

  public void clickFirstIssue() {
    firstIssueInDropdown.click();
  }

  public void isIssueTypeDisplayed() {
    issueType.shouldBe(Condition.exist);
  }

  public boolean isTicketNumberInUrl() {
    String number = ticketNumber.getText();
    return url().contains(number);
  }
}
