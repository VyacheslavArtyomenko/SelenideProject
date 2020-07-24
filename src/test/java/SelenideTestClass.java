import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTestClass {

    @BeforeMethod
    public void setUp(){
        Configuration.browser = "Chrome";
    }

    @Test
    public void loginTest(){
        open("https://jira.hillel.it/secure/Dashboard.jspa");
        $(By.id("login-form-username")).setValue("VyacheslavArtyomenko");
        $(By.id("login-form-password")).setValue("VyacheslavArtyomenko");
        $(By.xpath("//div[@class = 'buttons']//input[contains(@id, 'login')]")).click();

        $(By.id("header-details-user-fullname")).shouldBe(Condition.visible);
    }

}
