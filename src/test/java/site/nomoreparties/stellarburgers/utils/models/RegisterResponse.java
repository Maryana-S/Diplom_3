package site.nomoreparties.stellarburgers.utils.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterResponse {

    private boolean success;

    private User user;

    private String accessToken;

    private String refreshToken;

}
