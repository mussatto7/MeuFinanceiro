package com.devLucas.MeuFinanceiro.dto;

import com.devLucas.MeuFinanceiro.entity.User;
import com.devLucas.MeuFinanceiro.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.UUID;

@Getter
@Setter
public class UserDTO {

    private UUID id;

    @NotBlank
    private String username;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    @NotNull
    private Role role;

    public UserDTO() {
    }

    ;

    public UserDTO(User obj) {
        id = obj.getId();
        username = obj.getUsername();
        email = obj.getEmail();
        password = obj.getPassword();
        role = obj.getRole();
    }
}
