package site.nomoreparties.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private WebDriver driver;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }
    // Поле ввода 'Имя'
    private By nameInput = By.xpath(".//*[./*[text() = 'Имя']]/input");
    // Поле ввода 'Email'
    private By emailInput = By.xpath(".//*[./*[text() = 'Email']]/input");
    // Поле ввода 'Пароль'
    private By passwordInput = By.xpath(".//*[./*[text() = 'Пароль']]/input");
    // Кнопка 'Зарегистрироваться'
    private By registerButton = By.xpath(".//button[text() = 'Зарегистрироваться']");

    @Step("Ввод значения в поле 'Имя'")
    public void enterName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    @Step("Ввод значения в поле 'Email'")
    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    @Step("Ввод значения в поле 'Пароль'")
    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    @Step("Клик по кнопке 'Регистрация'")
    public void clickRegister() {
        driver.findElement(registerButton).click();
    }

    @Step("Заполнение формы регистрации и клик по кнопке 'Регистрация'")
    public void fillRegistrationForm(String name, String email, String password) {
        enterName(name);
        enterEmail(email);
        enterPassword(password);
        clickRegister();
    }
}
