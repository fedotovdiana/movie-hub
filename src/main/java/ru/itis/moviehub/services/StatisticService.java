package ru.itis.moviehub.services;

import ru.itis.moviehub.models.User;

public interface StatisticService {
    void save(User user, Integer checklistNumber);
}
