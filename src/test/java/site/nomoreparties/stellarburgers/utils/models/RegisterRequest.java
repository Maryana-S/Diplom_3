package site.nomoreparties.stellarburgers.utils.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String email;

    private String password;

    private String name;

}
