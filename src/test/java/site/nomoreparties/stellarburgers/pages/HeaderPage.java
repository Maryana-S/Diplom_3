package site.nomoreparties.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class HeaderPage {

    private WebDriver driver;

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Кнопка 'Личный Кабинет'
    private By personalAccountButton = By.xpath(".//*[./*[text() = 'Личный Кабинет']]");

    @Step("Клик по кнопке 'Личный Кабинет'")
    public void clickPersonalAccount() {
        driver.findElement(personalAccountButton).click();
    }

}
