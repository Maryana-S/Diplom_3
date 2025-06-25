package site.nomoreparties.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Кнопка 'Войти в аккаунт'
    private By loginButton = By.xpath(".//button[text() = 'Войти в аккаунт']");
    // Кнопка 'Оформить заказ'
    private By createOrderButton = By.xpath(".//button[text() = 'Оформить заказ']");

    @Step("Клик по кнопке 'Войти в аккаунт'")
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    @Step("Проверка отображения кнопки 'Оформить заказ'")
    public boolean isVisibleCreateOrderButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(createOrderButton));
        return driver.findElement(createOrderButton).isDisplayed();
    }
}
