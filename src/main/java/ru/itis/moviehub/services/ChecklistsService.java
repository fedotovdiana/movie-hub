package ru.itis.moviehub.services;

import ru.itis.moviehub.models.Checklist;
import ru.itis.moviehub.models.User;

import java.util.List;

public interface ChecklistsService {
    List<Checklist> getChecklists(User user);
}
