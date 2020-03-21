package ru.itis.moviehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.moviehub.models.Checklist;
import ru.itis.moviehub.models.User;
import ru.itis.moviehub.repositories.ChecklistsRepository;

import java.util.List;

@Service
public class ChecklistsServiceImpl implements ChecklistsService {

    @Autowired
    ChecklistsRepository checklistsRepository;

    @Override
    public List<Checklist> getChecklists(User user) {
        return checklistsRepository.findByUserId(user);
    }
}
