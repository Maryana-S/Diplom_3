package site.nomoreparties.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class PersonalAccountPage {

    private WebDriver driver;

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    // Поле 'Имя'
    private By nameInput = By.xpath(".//*[./*[text() = 'Имя']]/input");
    // Поле 'Логин'
    private By loginInput = By.xpath(".//*[./*[text() = 'Логин']]/input");

    @Step("Получение значения поля 'Имя'")
    public String getName() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(nameInput));
        return driver.findElement(nameInput).getAttribute("value");
    }

    @Step("Получение значения поля 'Логин'")
    public String getLogin() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(loginInput));
        return driver.findElement(loginInput).getAttribute("value");
    }

    @Step("Проверка соответствия имени и логина пользователя в личном кабинете введённым значениям")
    public void checkNameAndLogin(String name, String login) {
        assertEquals("Имя в личном кабинете не соответствует имени пользователя", name, getName());
        assertEquals("Логин в личном кабинете не соответствует email пользователя", login.toLowerCase(), getLogin());
    }

}
