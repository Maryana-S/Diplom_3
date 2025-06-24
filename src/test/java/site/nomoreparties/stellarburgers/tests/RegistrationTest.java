package site.nomoreparties.stellarburgers.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import net.bytebuddy.utility.RandomString;
import org.junit.Before;
import org.junit.Test;

import site.nomoreparties.stellarburgers.pages.LoginPage;
import site.nomoreparties.stellarburgers.pages.RegistrationPage;

import static org.junit.Assert.assertTrue;
import static site.nomoreparties.stellarburgers.utils.Url.REGISTER_URL;

public class RegistrationTest extends BaseTest {

    String name;
    String email;
    String password;

    @Before
    public void openRegistrationPageAndInitParams() {
        driver.get(REGISTER_URL);

        name = RandomString.make(10);
        email = RandomString.make(5) + "@ya.ru";
        password = "pass" + RandomString.make(9);
    }

    @Test
    @DisplayName("Успещная регистрация пользователя в системе с корректными значениями имя, email, пароль")
    @Description("Переход на страницу /register, вввод корректных значений во все поля формы, успешный переход на страницу 'Вход'")
    public void registrationAllCorrectParamSuccessTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillRegistrationForm(name, email, password);

        LoginPage loginPage = new LoginPage(driver);
        assertTrue("Не отображается заголовок формы входа 'Войти'", loginPage.isVisibleLoginFormHeader());
    }

    @Test
    @DisplayName("Ошибка регистрации пользователя при вводе пароля длинной менее 6 символов")
    @Description("Переход на страницу /register, вввод некорректного значения в поле формы 'Пароль', отображение ошибки")
    public void registrationTest() {
        password = "badps";
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillRegistrationForm(name, email, password);

        assertTrue("Не отображается текст сообщения 'Некорректный пароль'", registrationPage.isVisibleIncorrectPassword());
    }

}
