package ru.job4j.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.domain.Person;
import ru.job4j.repository.BlackListRepository;

/**
 * //TODO add comments
 *
 * @author parsentev
 * @since 21.09.2016
 */
@Service
public class BlackListServiceImpl implements BlackListService {
    private final BlackListRepository repository;

    @Autowired
    public BlackListServiceImpl(final BlackListRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean isBlackListPerson(int personId) {
        return this.repository.findByPerson(new Person(personId)) != null;
    }
}
