package ru.itis.moviehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.moviehub.models.Statistic;
import ru.itis.moviehub.models.User;
import ru.itis.moviehub.repositories.StatisticRepository;

@Service
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    private StatisticRepository statisticRepository;

    @Override
    public void save(User user, Integer checklistNumber) {
        Statistic statistic = Statistic.builder().user(user).checklistNumber(checklistNumber).build();
        statisticRepository.save(statistic);
    }
}
