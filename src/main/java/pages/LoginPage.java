package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private By userNameInput = By.id("login-form-username");
    private By passwordInput= By.id("login-form-password");
    private By loginButton = By.xpath("//div[@class = 'buttons']//input[contains(@id, 'login')]");

    public void enterUserName(String name) {
        $(userNameInput).sendKeys(name);
    }

    public void enterPassword(String password) {
        $(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        $(loginButton).click();
    }

}
