package ru.itis.moviehub.services;

import ru.itis.moviehub.models.Checklist;
import ru.itis.moviehub.models.Film;

import java.util.List;

public interface ChecklistsService {
    List<Checklist> getChecklists(Long userId);

    Long createChecklist(String name, Long userId);

    void saveFilm(Long checklistId, Long filmId);

    void addFilmToNew(String name, Long userId, Long filmId);

    void addFilmTo(String name, Long filmId);

    void deleteChecklist(Long id);

    Checklist getChecklist(Long id);

    List<Film> getFilms(Long id);

    void deleteFilmFrom(Long filmIid, Long checklistId);
}
