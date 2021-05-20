package ru.antitreningi.configurations;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.ByteArrayInputStream;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class BasePage<T extends BasePage<T>> {

    @Step("Проверка титула страницы.")
    public T checkTitle(String title) {
        try {
            Wait().withTimeout(Duration.ofSeconds(10)).until(ExpectedConditions.titleIs(title));
        } catch (TimeoutException e) {
            Allure.addAttachment("Screenshot.", new ByteArrayInputStream(Selenide.screenshot(OutputType.BYTES)));
            throw e;
        }
        return (T) this;
    }
}
