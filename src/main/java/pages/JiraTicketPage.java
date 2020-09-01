package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;

public class JiraTicketPage {

    private By commentButton = By.id("footer-comment-button");
    private By commentField = By.id("comment");
    private By addCommentButton = By.id("issue-comment-add-submit");
    private By deleteDialogButton = By.id("comment-delete-submit");
    private By nowElements = By.xpath("//div[@class='issuePanelWrapper']//time[contains(text(),'Now')]");

    public void navigateToJiraTicketPage() {
        open("https://jira.hillel.it/browse/WEBINAR-9060");
    }

    public void isTitleIs(String title) {
        $("title").shouldHave(attribute("text", title));
    }

    public void clickCommentButton() {
        $(commentButton).click();
    }

    public void sendTextToCommentField(String text) {
        $(commentField).sendKeys(text);
    }

    public void clickAddCommentButton() {
        $(addCommentButton).click();
    }

    public void isTicketCreated() {
        $(nowElements).shouldHave(Condition.text("Now"));
    }

    private SelenideElement findLastComment() {
        ElementsCollection elements = $$(By.xpath("//a[contains(@id, 'delete')]"));
        return elements.get(elements.size() - 1);
    }

    public void clickOnDeleteLastComment() {
        findLastComment().click();
    }

    public void clickDeleteDialogButton() {
        $(deleteDialogButton).click();
    }

    public void isIssueTypePresent() {
        $(By.id("type-val")).shouldBe(Condition.visible);
    }

    public boolean isLastCommentDeleted() {
        for (int i = 0; i < 10; i++) {
            System.out.println($$(nowElements).size()); // for log information, counts a little with delay
            if ($$(nowElements).size() == 0)
                return true;
        }
        return false;
    }
}
