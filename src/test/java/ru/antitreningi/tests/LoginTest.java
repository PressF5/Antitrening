package ru.antitreningi.tests;

import static com.codeborne.selenide.Selenide.open;

import org.testng.annotations.Test;
import ru.antitreningi.configurations.BaseTest;
import ru.antitreningi.page.login.LoginPage;

public class LoginTest extends BaseTest {

    private LoginPage enterLoginAndPassword(String login, String password) {
        LoginPage loginPage = open("", LoginPage.class);
        loginPage.checkTitle("АнтиТренинги - платформа для вашей онлайн-школы").
                clickButtonSignIn().
                enterLoginOrPassword("login", login).
                enterLoginOrPassword("password", password).
                clickButtonSignInForm();
        return loginPage;
    }

    @Test
    public void validLoginAndPassword() {
        enterLoginAndPassword("bogdantkachenko.dn@gmail.com", "Qwerty123").checkTitle("Все курсы");
    }

    @Test
    public void invalidLoginAndPassword() {
        enterLoginAndPassword("bogdantkachenko.dn@gmail.com123", "Qwerty1234").checkLoginAndPasswordError();
    }
}