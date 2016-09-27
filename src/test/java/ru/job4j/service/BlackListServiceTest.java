package ru.job4j.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.job4j.domain.BlackList;
import ru.job4j.domain.Person;
import ru.job4j.repository.BlackListRepository;
import ru.job4j.repository.PersonRepository;

import static org.junit.Assert.*;

/**
 * @author parsentev
 * @since 21.09.2016
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BlackListServiceTest {

    @Autowired
    private PersonRepository persons;

    @Autowired
    private BlackListRepository blacklists;

    @Autowired
    private BlackListService service;

    @Test
    public void whenPersonInBlackListThenReturnTrue() {
        Person person = this.persons.save(new Person("Petr", "Arsentev"));
        this.blacklists.save(new BlackList(person));
        boolean result = this.service.isBlackListPerson(person.getId());
        assertTrue(result);
    }

    @Test
    public void whenBlackListEmptyThenAnyPersonNotIn() {
        Person person = this.persons.save(new Person("Petr", "Arsentev"));
        boolean result = this.service.isBlackListPerson(person.getId());
        assertFalse(result);
    }
}