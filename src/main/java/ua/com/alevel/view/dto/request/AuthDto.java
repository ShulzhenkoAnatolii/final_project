package ua.com.alevel.view.dto.request;

import lombok.Data;

@Data
public class AuthDto {

    private String email;
    private String password;
    private String passwordConfirm;
}
