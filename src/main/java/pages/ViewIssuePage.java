package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ViewIssuePage {
  private SelenideElement issuesDropdown = $(By.id("find_link"));
  private SelenideElement firstIssueInDropdown = $(By.xpath("//div[@id='issues_history_main']//ul/li[1]"));
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
    firstIssueInDropdown.shouldBe(Condition.exist);
  }

  public boolean isTicketNumberInUrl() {
    String number = ticketNumber.getText();


    /////UNTIL HERE
    return driver.getCurrentUrl().contains(number);
  }
}
