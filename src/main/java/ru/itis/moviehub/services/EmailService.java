package ru.itis.moviehub.services;

public interface EmailService {
    void sendMail(String subject, String name, String text, String login);
}
