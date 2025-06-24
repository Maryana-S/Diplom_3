package site.nomoreparties.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResetPasswordPage {

    private WebDriver driver;

    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    // Кнопка 'Войти' под формой восстановления пароля
    private By loginButton = By.xpath(".//*[@href = '/login']");

    @Step("Клик по кнопке 'Войти' под формой восстановления пароля")
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
}
