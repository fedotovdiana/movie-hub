package ru.itis.moviehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.moviehub.models.Checklist;
import ru.itis.moviehub.models.ChecklistFilm;
import ru.itis.moviehub.models.Film;
import ru.itis.moviehub.repositories.ChecklistFilmRepository;
import ru.itis.moviehub.repositories.ChecklistsRepository;
import ru.itis.moviehub.repositories.FilmsRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ChecklistsServiceImpl implements ChecklistsService {

    @Autowired
    ChecklistsRepository checklistsRepository;

    @Autowired
    ChecklistFilmRepository checklistFilmRepository;

    @Autowired
    FilmsRepository filmsRepository;

    @Override
    public List<Checklist> getChecklists(Long userId) {
        return checklistsRepository.findByUserId(userId);
    }

    @Override
    public Long createChecklist(String name, Long userId) {
        Checklist checklist = Checklist.builder().name(name).userId(userId).build();
        checklistsRepository.save(checklist);
        return checklist.getId();
    }

    @Override
    public void saveFilm(Long checklistId, Long filmId) {
        ChecklistFilm checklistFilm = ChecklistFilm.builder().id(checklistId).filmId(filmId).build();
        checklistFilmRepository.save(checklistFilm);
    }

    @Override
    public void addFilmToNew(String name, Long userId, Long filmId) {
        Long checklistId = createChecklist(name, userId);
        System.out.println(checklistId);
        saveFilm(checklistId, filmId);
    }

    @Override
    public void addFilmTo(String name, Long filmId) {
        Optional<Checklist> checklistOptional = checklistsRepository.findByName(name);
        if (checklistOptional.isPresent()) {
            Checklist checklist = checklistOptional.get();
            saveFilm(checklist.getId(), filmId);
        }
    }

    @Override
    public void deleteChecklist(Long id) {
        checklistsRepository.deleteById(id);
    }

    @Override
    public Checklist getChecklist(Long id) {
        Optional<Checklist> checklistOptional = checklistsRepository.findById(id);
        return checklistOptional.orElse(null);
    }

    @Override
    public List<Film> getFilms(Long id) {
        List<ChecklistFilm> checklistFilms = checklistFilmRepository.getAllById(id);
        List<Film> films = new LinkedList<>();
        for (ChecklistFilm ch : checklistFilms) {
            Film film = filmsRepository.getOne(ch.getFilmId());
            films.add(film);
        }
        return films;
    }

    @Override
    public void deleteFilmFrom(Long checklistId, Long filmId) {
        ChecklistFilm checklistFilm = ChecklistFilm.builder().id(checklistId).filmId(filmId).build();
        checklistFilmRepository.delete(checklistFilm);
    }
}
