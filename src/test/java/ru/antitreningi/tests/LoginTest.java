package ru.antitreningi.tests;

import static com.codeborne.selenide.Selenide.open;

import org.testng.annotations.Test;
import ru.antitreningi.configurations.BaseTest;
import ru.antitreningi.page.login.LoginPage;

public class LoginTest extends BaseTest {

    private LoginPage enterLogin(String login) {
        LoginPage loginPage = open("", LoginPage.class);
        loginPage.checkTitle("АнтиТренинги - платформа для вашей онлайн-школы").
                clickOnButton("login").
                enterLoginOrPassword(login).
                clickOnButton("submit");
        return loginPage;
    }

    @Test
    public void validLoginAndPassword() {
        enterLogin("bogdantkachenko.dn@gmail.com").
                enterLoginOrPassword("Qwerty123").
                clickOnButton("submit").
                checkTitle("Все курсы");
    }

    @Test
    public void invalidLoginAndPassword() {
        enterLogin("bogdantkachenko.dn@gmail.com123").
                checkLoginOrPasswordError("Неправильный E-mail").
                enterLoginOrPassword("bogdantkachenko.dn@gmail.com").
                clickOnButton("submit").
                enterLoginOrPassword("Qwerty1234").
                clickOnButton("submit").
                checkLoginOrPasswordError("Неправильный пароль");
    }
}