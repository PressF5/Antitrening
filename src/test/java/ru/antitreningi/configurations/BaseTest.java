package ru.antitreningi.configurations;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    public static void setUp() {
        Configuration.baseUrl = "https://antitreningi.ru";
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = "chrome";
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(capabilityName: "enableVNC", value: true);
//        capabilities.setCapability(capabilityName: "enableVideo", value: true);
//        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }
}
