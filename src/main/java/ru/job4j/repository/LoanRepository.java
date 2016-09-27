package ru.job4j.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.domain.Loan;
import ru.job4j.domain.Person;

import java.util.List;

/**
 * //TODO add comments
 *
 * @author parsentev
 * @since 21.09.2016
 */
public interface LoanRepository extends CrudRepository<Loan, Integer> {
    List<Loan> findByPerson(Person person);
}
