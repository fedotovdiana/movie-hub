package ru.itis.moviehub.dto;

import lombok.Data;

@Data
public class SignUpDto {
    private String name;
    private String login;
    private String password;
}