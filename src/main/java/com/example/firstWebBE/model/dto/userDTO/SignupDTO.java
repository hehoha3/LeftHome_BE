package com.example.firstWebBE.model.dto.userDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignupDTO {
    private String username;

    private String email;

    private String password;

    private String password2;
}
