package ru.antitreningi.page.login;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import ru.antitreningi.configurations.BasePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage<LoginPage> {

    private By buttonLogin = By.xpath("//button[@data-type='login']");
    private By fieldLoginOrPassword = By.xpath("//input");
    private By buttonSubmit = By.xpath("//button[@type='submit']");
    private By errorMessage = By.xpath("//span[@class='sc-hBURRC eRJZMx']");

    @Step("Клик по кнопке.")
    public LoginPage clickOnButton(String type) {
        if ("login".equals(type))
            $(buttonLogin).click();
        else if ("submit".equals(type)) $(buttonSubmit).click();
        return this;
    }

    @Step("Ввод логина или пароля.")
    public LoginPage enterLoginOrPassword(String loginOrPassword) {
        $(fieldLoginOrPassword).sendKeys(Keys.CONTROL + "a");
        $(fieldLoginOrPassword).sendKeys(Keys.DELETE);
        $(fieldLoginOrPassword).setValue(loginOrPassword);
        return this;
    }

    @Step("Проверка ошибки при вводе некоректного логина или пароля.")
    public LoginPage checkLoginOrPasswordError(String message) {
        $(errorMessage).shouldHave(text(message));
        return this;
    }
}