package ru.itis.moviehub.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
public class SignUpForm {
    @Size(min = 4, max = 12, message = "{errors.short.name}")
    private String name;
    @Email(message = "{errors.incorrect.login}")
    private String login;
    private String password;
    private String photo;
}