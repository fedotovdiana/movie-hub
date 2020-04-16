package ru.itis.moviehub.services;

import ru.itis.moviehub.models.Scriptwriter;

import java.util.List;

public interface ScriptwritersService {
    List<Scriptwriter> getScriptwriters();

    Scriptwriter getConcreteScriptwriter(Long scriptwriterId);

    List<Scriptwriter> getScriptwritersByFilm(Long filmId);
}
