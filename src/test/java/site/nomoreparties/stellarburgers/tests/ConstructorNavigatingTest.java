package site.nomoreparties.stellarburgers.tests;

import io.qameta.allure.Description;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.Point;
import site.nomoreparties.stellarburgers.pages.ConstructorPage;

import static org.junit.Assert.assertTrue;

public class ConstructorNavigatingTest extends BaseTest {

    @Test
    @DisplayName("Успешный переход во вкладку 'Соусы' в конструкторе")
    @Description("Проверка перехода во вкладку 'Соусы' в конструкторе: в названии класса активной вкладки имеется значение current, заголовок 'Соусы' отображается под панелью вкладок")
    public void moveToSouseTabSuccessTest() throws InterruptedException {
        ConstructorPage constructorPage = new ConstructorPage(driver);
        Point bunsLocation = constructorPage.getBunsPoint();
        constructorPage.clickSouses();
        assertTrue("Вкладка 'Соусы' не выбрана", constructorPage.isSelectSouses());
        assertTrue("Заголовок 'Соусы' расположен не под панелью с вкладками", constructorPage.isSousesInTop(bunsLocation));
    }

    @Test
    @DisplayName("Успешный переход во вкладку 'Начинки' в конструкторе")
    @Description("Проверка перехода во вкладку 'Начинки' в конструкторе: в названии класса активной вкладки имеется значение current, заголовок 'Начинки' отображается под панелью вкладок")
    public void moveToFillingsTabSuccessTest() throws InterruptedException {
        ConstructorPage constructorPage = new ConstructorPage(driver);
        Point bunsLocation = constructorPage.getBunsPoint();
        constructorPage.clickFillings();
        assertTrue("Вкладка 'Начинки' не выбрана", constructorPage.isSelectFillings());
        assertTrue("Заголовок 'Начинки' расположен не под панелью с вкладками", constructorPage.isFillingsInTop(bunsLocation));
    }

    @Test
    @DisplayName("Успешный переход во вкладку 'Булки' в конструкторе")
    @Description("Проверка перехода во вкладку 'Булки' в конструкторе: в названии класса активной вкладки имеется значение current, заголовок 'Булки' отображается под панелью вкладок")
    public void moveToBunsTabSuccessTest() throws InterruptedException {
        ConstructorPage constructorPage = new ConstructorPage(driver);
        Point bunsStartedLocation = constructorPage.getBunsPoint();
        constructorPage.clickFillings();
        constructorPage.clickBuns();
        assertTrue("Вкладка 'Булки' не выбрана", constructorPage.isSelectBuns());
        assertTrue("Заголовок 'Булки' расположен не под панелью с вкладками", constructorPage.isBunsInTop(bunsStartedLocation));
    }
}
