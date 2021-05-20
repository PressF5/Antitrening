package ru.antitreningi.page.login;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.antitreningi.configurations.BasePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage<LoginPage> {

    @Step("Клик по кнопке \"Войти\" на главной странице сайта.")
    public LoginPage clickButtonSignIn() {
        $(By.xpath("//div/button[@data-modal='#signin']")).click();
        return this;
    }

    @Step("Ввод {type}.")
    public LoginPage enterLoginOrPassword(String type, String loginOrPassword) {
        $(By.xpath("//input[@name='" + type + "']")).setValue(loginOrPassword);
        return this;
    }

    @Step("Клик по кнопке \"Войти\" в форме логина.")
    public LoginPage clickButtonSignInForm() {
        $(By.xpath("//button[@type='submit'][contains(text(),'Войти')]")).click();
        return this;
    }

    @Step("Проверка ошибки при вводе некоректного логина и пароля.")
    public LoginPage checkLoginAndPasswordError() {
        $(By.xpath("//div[@class='responseError']")).shouldHave(text("Неверный логин или пароль"));
        return this;
    }
}