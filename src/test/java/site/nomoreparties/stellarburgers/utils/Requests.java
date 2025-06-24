package site.nomoreparties.stellarburgers.utils;

import io.qameta.allure.Step;
import site.nomoreparties.stellarburgers.utils.models.RegisterRequest;
import site.nomoreparties.stellarburgers.utils.models.RegisterResponse;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static site.nomoreparties.stellarburgers.utils.Url.MAIN_URL;

public class Requests {

    @Step("Отправка POST запроса на эндпоинт /api/auth/register. Регистрация пользователя, получение accessToken")
    public static String getAccessToken(String name, String email, String password) {
        RegisterRequest registerRequest = new RegisterRequest(name, email, password);
        return given()
                .header("Content-type", "application/json")
                .body(registerRequest)
                .when()
                .post(MAIN_URL + "/api/auth/register")
                .then()
                .statusCode(SC_OK)
                .extract()
                .as(RegisterResponse.class).getAccessToken();
    }

    @Step("Отправка DELETE запроса на эндпоинт /api/auth/user. Удаление пользователя")
    public static void deleteUser(String accessToken) {
        given()
                .header("Authorization", accessToken)
                .when()
                .log().all()
                .delete(MAIN_URL + "/api/auth/user");
    }
}
