package ru.job4j.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.domain.Person;

/**
 * //TODO add comments
 *
 * @author parsentev
 * @since 21.09.2016
 */
public interface PersonRepository extends CrudRepository<Person, Integer> {
}
