package site.nomoreparties.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Заголовок формы 'Вход'
    private By loginFormHeader = By.xpath(".//*[text() = 'Вход']");
    // Поле ввода Email
    private By emailInput = By.xpath(".//*[./*[text() = 'Email']]/input");
    // Поле ввода Пароль
    private By passwordInput = By.xpath(".//*[./*[text() = 'Пароль']]/input");
    // Кнопка 'Войти'
    private By loginButton = By.xpath(".//button[text() = 'Войти']");
    // Кнопка 'Войти' под формой
    private By recoverPasswordButton = By.xpath(".//*[@href = '/forgot-password']");

    @Step("Ввод значения в поле 'Email'")
    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    @Step("Ввод значения в поле 'Пароль'")
    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    @Step("Клик по кнопке 'Войти'")
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    @Step("Заполнение формы входа и клик по кнопке 'Войти'")
    public void fillLoginForm(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }

    @Step("Проверка отображения заголовка формы 'Вход'")
    public boolean isVisibleLoginFormHeader() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(loginFormHeader));
        return driver.findElement(loginFormHeader).isDisplayed();
    }
}
