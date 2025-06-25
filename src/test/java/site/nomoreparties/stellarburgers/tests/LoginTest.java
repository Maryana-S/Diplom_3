package site.nomoreparties.stellarburgers.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import net.bytebuddy.utility.RandomString;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.*;
import site.nomoreparties.stellarburgers.utils.Requests;


import static org.junit.Assert.assertTrue;
import static site.nomoreparties.stellarburgers.utils.Requests.getAccessToken;
import static site.nomoreparties.stellarburgers.utils.Url.*;

public class LoginTest extends BaseTest {

    String name;
    String email;
    String password;
    String accessToken;

    @Before
    @Step("Инициализация параметров name, emil, password; регистрация пользователя в сисиеме")
    public void initParams() {
        name = RandomString.make(10);
        email = RandomString.make(7) + "@ya.ru";
        password = "pass" + RandomString.make(9);

        accessToken = getAccessToken(email, password, name);
    }

    @Test()
    @DisplayName("Успешный вход в систему с главной страницы сайта")
    @Description("Переход в форму входа в личный кабинет через кнопку 'Войти в аккаунт' на главной странице")
    public void successLoginFromMainPageTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLogin();
        new LoginPage(driver).fillLoginForm(email, password);

        assertTrue("На главной странице не отображается кнопка 'Создать заказ'", mainPage.isVisibleCreateOrderButton());

        new HeaderPage(driver).clickPersonalAccount();
        new PersonalAccountPage(driver).checkNameAndLogin(name, email);
    }

    @Test()
    @DisplayName("Успешный вход в систему через кнопку 'Личный кабинет' в хедере")
    @Description("Переход в форму входа в личный кабинет через кнопку 'Личный кабинет' в хедере")
    public void successLoginFromPersonalAccountTest() {
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickPersonalAccount();
        new LoginPage(driver).fillLoginForm(email, password);

        assertTrue("На главной странице не отображается кнопка 'Создать заказ'", new MainPage(driver).isVisibleCreateOrderButton());

        headerPage.clickPersonalAccount();
        new PersonalAccountPage(driver).checkNameAndLogin(name, email);
    }

    @Test()
    @DisplayName("Успешный вход в систему через кнопку 'Войти' под формой регистрации")
    @Description("Переход в форму входа в личный кабинет через кнопку 'Войти' под формой регистрации")
    public void successLoginFromRegistrationFormTest() {
        driver.get(REGISTER_URL);
        new RegistrationPage(driver).clickLogin();
        new LoginPage(driver).fillLoginForm(email, password);

        assertTrue("На главной странице не отображается кнопка 'Создать заказ'", new MainPage(driver).isVisibleCreateOrderButton());

        new HeaderPage(driver).clickPersonalAccount();
        new PersonalAccountPage(driver).checkNameAndLogin(name, email);
    }

    @Test()
    @DisplayName("Успешный вход в систему через кнопку 'Восстановить пароль' под формой входа")
    @Description("Вход в систему через кнопку 'Восстановить пароль' под формой входа")
    public void successLoginFromResetPasswordTest() {
        driver.get(RESET_PASSWORD_URL);
        new ResetPasswordPage(driver).clickLogin();
        new LoginPage(driver).fillLoginForm(email, password);

        assertTrue("На главной странице не отображается кнопка 'Создать заказ'", new MainPage(driver).isVisibleCreateOrderButton());

        new HeaderPage(driver).clickPersonalAccount();
        new PersonalAccountPage(driver).checkNameAndLogin(name, email);
    }

    @After
    @Step("Удаление созданного пользователя")
    public void deleteUser() {
        Requests.deleteUser(accessToken);
    }
}
