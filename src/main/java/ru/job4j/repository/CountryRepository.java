package ru.job4j.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.domain.Country;

/**
 * //TODO add comments
 *
 * @author parsentev
 * @since 21.09.2016
 */
public interface CountryRepository extends CrudRepository<Country, Integer> {
}
