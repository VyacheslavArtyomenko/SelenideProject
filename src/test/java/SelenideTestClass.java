import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CreateIssueWindow;
import pages.HomePage;
import pages.JiraTicketPage;
import pages.LoginPage;

public class SelenideTestClass {
    private LoginPage loginPage;
    private HomePage homePage;
    private JiraTicketPage jiraTicketPage;
    private CreateIssueWindow createIssueWindow;

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "Chrome";
        loginPage = new LoginPage();
        homePage = new HomePage();
        jiraTicketPage = new JiraTicketPage();
        createIssueWindow = new CreateIssueWindow();
    }

    @Test
    public void loginTest() {
        homePage.navigateToHomePage();
        loginPage.enterUserName("VyacheslavArtyomenko");
        loginPage.enterPassword("VyacheslavArtyomenko");
        loginPage.clickLoginButton();

        homePage.isUserIconDisplayed();
    }

    @Test
    public void viewJiraTicket() {
        jiraTicketPage.navigateToJiraTicketPage();
        loginPage.enterUserName("VyacheslavArtyomenko");
        loginPage.enterPassword("VyacheslavArtyomenko");
        loginPage.clickLoginButton();

        jiraTicketPage.isIssueTypePresent();
        jiraTicketPage.isTitleIs("[WEBINAR-9060] Updated - Hillel IT School JIRA");
    }

    @Test
    public void createIssue() {
        homePage.navigateToHomePage();
        loginPage.enterUserName("VyacheslavArtyomenko");
        loginPage.enterPassword("VyacheslavArtyomenko");
        loginPage.clickLoginButton();

        homePage.clickCreateIssue();

        createIssueWindow.clearProjectField();
        createIssueWindow.enterProjectField("Webinar");
        createIssueWindow.pressTabAfterProjectField();

        createIssueWindow.clearIssueTypeField();
        createIssueWindow.enterIssueTypeField("Task");
        createIssueWindow.pressTabAfterIssueTypeField();

        createIssueWindow.enterSummary("One more test summary");
        createIssueWindow.clearReporterField();
        createIssueWindow.enterReporterField("VyacheslavArtyomenko");

        createIssueWindow.pressCreateIssueButton();
        homePage.isIssueCreated();
    }

    @Test
    public void addComment() {
        jiraTicketPage.navigateToJiraTicketPage();
        loginPage.enterUserName("VyacheslavArtyomenko");
        loginPage.enterPassword("VyacheslavArtyomenko");
        loginPage.clickLoginButton();

        jiraTicketPage.clickCommentButton();
        jiraTicketPage.sendTextToCommentField("Test comment");
        jiraTicketPage.clickAddCommentButton();

        jiraTicketPage.isTicketCreated();

        jiraTicketPage.clickOnDeleteLastComment();
        jiraTicketPage.clickDeleteDialogButton();
int i;
        Assert.assertTrue(jiraTicketPage.isLastCommentDeleted());
    }

    @AfterMethod
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}
