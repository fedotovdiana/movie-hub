package ru.itis.moviehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.moviehub.models.Scriptwriter;
import ru.itis.moviehub.models.ScriptwriterFilm;
import ru.itis.moviehub.repositories.ScriptwriterFilmsRepository;
import ru.itis.moviehub.repositories.ScriptwritersRepository;

import java.util.LinkedList;
import java.util.List;

@Service
public class ScriptwritersServiceImpl implements ScriptwritersService {

    @Autowired
    ScriptwritersRepository scriptwritersRepository;

    @Autowired
    ScriptwriterFilmsRepository scriptwriterFilmsRepository;

    @Override
    public List<Scriptwriter> getScriptwriters() {
        return scriptwritersRepository.findAll();
    }

    @Override
    public Scriptwriter getConcreteScriptwriter(Long scriptwriterId) {
        return scriptwritersRepository.getOne(scriptwriterId);
    }

    @Override
    public List<Scriptwriter> getScriptwritersByFilm(Long filmId) {
        List<ScriptwriterFilm> scriptwriterFilms =
                scriptwriterFilmsRepository.getScriptwriterFilmByFilmId(filmId);
        List<Scriptwriter> scriptwriters = new LinkedList<>();
        for (ScriptwriterFilm sf : scriptwriterFilms) {
            Scriptwriter scriptwriter = scriptwritersRepository.getOne(sf.getId());
            scriptwriters.add(scriptwriter);
        }
        return scriptwriters;
    }
}
