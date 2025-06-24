package site.nomoreparties.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class ConstructorPage {

    private WebDriver driver;

    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }

    // Вкладка 'Булки'
    private By bunsTab = By.xpath(".//*[contains(@class, 'tab') and ./*[text() = 'Булки']]");
    // Вкладка 'Соусы'
    private By sousesTab = By.xpath(".//*[contains(@class, 'tab') and ./*[text() = 'Соусы']]");
    // Вкладка 'Начинки'
    private By fillingsTab = By.xpath(".//*[contains(@class, 'tab') and ./*[text() = 'Начинки']]");
    // Заголовок раздела 'Булки' в конструкторе
    private By bunsHeader =  By.xpath(".//*[contains(@class, 'menuContainer')]/*[text() = 'Булки']");
    // Заголовок раздела 'Соусы' в конструкторе
    private By sousesHeader =  By.xpath(".//*[contains(@class, 'menuContainer')]/*[text() = 'Соусы']");
    // Заголовок раздела 'Начинки' в конструкторе
    private By fillingsHeader =  By.xpath(".//*[contains(@class, 'menuContainer')]/*[text() = 'Начинки']");

    @Step("Клик по вкладке 'Булки'")
    public void clickBuns() {
        driver.findElement(bunsTab).click();
    }

    @Step("Клик по вкладке 'Соусы'")
    public void clickSouses() {
        driver.findElement(sousesTab).click();
    }

    @Step("Клик по вкладке 'Начинки'")
    public void clickFillings() {
        driver.findElement(fillingsTab).click();
    }

    @Step("Проверка, выбрана ли вкладка 'Соусы', по наличию в названии класа атрибута current")
    public boolean isSelectSouses() {
        boolean isSelected = false;
        String className = driver.findElement(sousesTab).getAttribute("class");
        if (className.contains("current")){
            isSelected = true;
        }
        return isSelected;
    }

    @Step("Проверка, выбрана ли вкладка 'Начинки', по наличию в названии класа атрибута current")
    public boolean isSelectFillings() {
        boolean isSelected = false;
        String className = driver.findElement(fillingsTab).getAttribute("class");
        if (className.contains("current")){
            isSelected = true;
        }
        return isSelected;
    }

    @Step("Выбрана ли вкладка 'Булки', по наличию в названии класа атрибута current")
    public boolean isSelectBuns() {
        boolean isSelected = false;
        String className = driver.findElement(bunsTab).getAttribute("class");
        if (className.contains("current")){
            isSelected = true;
        }
        return isSelected;
    }

    @Step("Отображается ли заголовок 'Булки' в теле конструктора")
    public boolean isVisibleBuns() {
        return driver.findElement(bunsHeader).isDisplayed();
    }

    @Step("Отображается ли заголовок 'Соусы' в теле конструктора")
    public boolean isVisibleSouses() {
        return driver.findElement(sousesHeader).isDisplayed();
    }

    @Step("Отображается ли заголовок 'Начинки' в теле конструктора")
    public boolean isVisibleFillings() {
        return driver.findElement(fillingsHeader).isDisplayed();
    }

    @Step("Получить точку с расположением заголовка 'Булки' в конструкторе")
    public Point getBunsPoint() {
        int offset = 40;
        Point point = driver.findElement(bunsHeader).getLocation();
        point.y = point.getY() - offset;
        return point;
    }

    @Step("Проверка, что заголовок 'Соусы' находится под панелью с вкладками")
    public boolean isSousesInTop(Point topHeaderLocation) throws InterruptedException {
        Thread.sleep(3000); // Ожидание прокрутки до содержимого выбранной вкладки
        Point sousesLocation = driver.findElement(sousesHeader).getLocation();
        return topHeaderLocation.equals(sousesLocation);
    }

    @Step("Проверка, что заголовок 'Начинки' находится под панелью с вкладками")
    public boolean isFillingsInTop(Point topHeaderLocation) throws InterruptedException {
        Thread.sleep(3000); // Ожидание прокрутки до содержимого выбранной вкладки
        Point fillingLocation = driver.findElement(fillingsHeader).getLocation();
        return topHeaderLocation.equals(fillingLocation);
    }

    @Step("Проверка, что заголовок 'Булки' находится под панелью с вкладками")
    public boolean isBunsInTop(Point topHeaderLocation) throws InterruptedException {
        Thread.sleep(3000); // Ожидание прокрутки до содержимого выбранной вкладки
        Point bunsLocation = driver.findElement(bunsHeader).getLocation();
        return topHeaderLocation.equals(bunsLocation);
    }

}
