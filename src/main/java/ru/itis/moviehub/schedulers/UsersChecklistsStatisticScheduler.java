package ru.itis.moviehub.schedulers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import ru.itis.moviehub.models.Checklist;
import ru.itis.moviehub.models.State;
import ru.itis.moviehub.models.User;
import ru.itis.moviehub.repositories.ChecklistsRepository;
import ru.itis.moviehub.repositories.UsersRepository;
import ru.itis.moviehub.services.StatisticService;

import javax.transaction.Transactional;
import java.util.List;

@Configuration
@EnableScheduling
@Slf4j
public class UsersChecklistsStatisticScheduler {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ChecklistsRepository checklistsRepository;

    @Autowired
    private StatisticService statisticsService;

    @Transactional
    @Scheduled(cron = "0 0 0 1 * ?")
    public void run() {
        List<User> confirmedUsers = usersRepository.findAllByState(State.NOT_CONFIRMED);
        for (User user : confirmedUsers) {
            List<Checklist> checklists = checklistsRepository.findByUserId(user.getId());
            statisticsService.save(user, checklists.size());
        }
    }
}
