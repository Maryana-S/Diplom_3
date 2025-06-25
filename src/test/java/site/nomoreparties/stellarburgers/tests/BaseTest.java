package site.nomoreparties.stellarburgers.tests;

import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static site.nomoreparties.stellarburgers.utils.Url.MAIN_URL;

public class BaseTest {

    public WebDriver driver;

    @Before
    @Step("Открытие в браузере главной страницы сайта Stellar Burgers")
    public void openMainPage() {
        String driverPath = System.getProperty("driver.path", "");
        if (!driverPath.isEmpty()) {
            System.setProperty("webdriver.chrome.driver", driverPath);
        }
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(MAIN_URL);
    }

    @After
    @Step("Закрытие браузера")
    public void tearDown() {
        driver.quit();
    }

}
