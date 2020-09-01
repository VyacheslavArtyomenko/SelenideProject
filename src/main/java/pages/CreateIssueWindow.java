package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Selenide.$;

public class CreateIssueWindow {

    private By projectField = By.id("project-field");
    private By issueTypeField = By.id("issuetype-field");
    private By summaryField = By.id("summary");
    private By reporterField = By.id("reporter-field");
    private By createIssueButton = By.id("create-issue-submit");

    public void clearProjectField() {
        $(projectField).clear();
    }

    public void enterProjectField(String text) {
       $(projectField).sendKeys(text);
    }

    public void pressTabAfterProjectField() {
        $(projectField).sendKeys(Keys.TAB);
    }

    public void clearIssueTypeField() {
       $(issueTypeField).clear();
    }

    public void enterIssueTypeField(String text) {
       $(issueTypeField).sendKeys(text);
    }

    public void pressTabAfterIssueTypeField() {
        $(issueTypeField).sendKeys(Keys.TAB);
    }

    public void enterSummary(String text) {
       $(summaryField).sendKeys(text);
    }

    public void clearReporterField() {
        $(reporterField).clear();
    }

    public void enterReporterField(String text) {
        $(reporterField).sendKeys(text);
    }

    public void pressCreateIssueButton() {
        $(createIssueButton).click();
    }
}
