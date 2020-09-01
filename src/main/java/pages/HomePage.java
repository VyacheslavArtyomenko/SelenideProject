package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {

    private By createIssueButton = By.id("create_link");
    private By tempWindowIssueCreated = By.xpath("//*[contains(@class,'aui-will-close')]");
    private By tempWindow = By.xpath("//*[contains(@class,'aui-will-close')]");
    private By userIcon = By.id("header-details-user-fullname");

    public void navigateToHomePage() {
        open("https://jira.hillel.it/secure/Dashboard.jspa");
    }

    public void isUserIconDisplayed() {
        $(userIcon).shouldBe(Condition.visible);
    }

    public void clickCreateIssue() {
        $(By.id("find_link")).shouldBe(Condition.visible);
        $(createIssueButton).click();
    }

    public void isIssueCreated() {
        $(tempWindowIssueCreated).shouldBe(Condition.visible);
        $(tempWindow).shouldHave(Condition.text("WEBINAR"));
    }
}
