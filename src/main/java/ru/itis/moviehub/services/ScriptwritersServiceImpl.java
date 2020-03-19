package ru.itis.moviehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.moviehub.models.Scriptwriter;
import ru.itis.moviehub.repositories.ScriptwritersRepository;

import java.util.List;

@Service
public class ScriptwritersServiceImpl implements ScriptwritersService {

    @Autowired
    ScriptwritersRepository scriptwritersRepository;

    @Override
    public List<Scriptwriter> getScriptwriters() {
        return scriptwritersRepository.findAll();
    }

    @Override
    public Scriptwriter getConcreteScriptwriter(Integer scriptwriterId) {
        return scriptwritersRepository.getOne(scriptwriterId);
    }
}
