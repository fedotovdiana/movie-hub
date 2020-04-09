package ru.itis.moviehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.moviehub.models.Dislike;
import ru.itis.moviehub.models.Film;
import ru.itis.moviehub.models.Like;
import ru.itis.moviehub.models.User;
import ru.itis.moviehub.repositories.DislikesRepository;
import ru.itis.moviehub.repositories.LikesRepository;

@Service
public class LikesServiceImpl implements LikesService {

    @Autowired
    LikesRepository likesRepository;

    @Autowired
    DislikesRepository dislikesRepository;

    @Override
    public Long getLikes(Integer filmId) {
        return likesRepository.countByFilmId(filmId);
    }

    @Override
    public Long getDislikes(Integer filmId) {
        return dislikesRepository.countByFilmId(filmId);
    }

    @Override
    public void addLike(User user, Film film) {
        Like like = Like.builder().user(user).film(film).build();
        likesRepository.save(like);
    }

    @Override
    public void addDislike(User user, Film film) {
        Dislike dislike = Dislike.builder().user(user).film(film).build();
        dislikesRepository.save(dislike);
    }
}
