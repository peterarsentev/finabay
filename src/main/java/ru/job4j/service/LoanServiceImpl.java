package ru.job4j.service;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.domain.Loan;
import ru.job4j.domain.Person;
import ru.job4j.repository.LoanRepository;

import java.util.List;

/**
 * //TODO add comments
 *
 * @author parsentev
 * @since 21.09.2016
 */
@Service
public class LoanServiceImpl implements LoanService {
    private final LoanRepository repository;

    @Autowired
    public LoanServiceImpl(final LoanRepository repository) {
        this.repository = repository;
    }

    @Override
    public Loan apply(final Loan loan) {
        return this.repository.save(loan);
    }

    @Override
    public List<Loan> getAll() {
        return Lists.newArrayList(this.repository.findAll());
    }

    @Override
    public List<Loan> getByPerson(int personId) {
        return this.repository.findByPerson(new Person(personId));
    }
}
