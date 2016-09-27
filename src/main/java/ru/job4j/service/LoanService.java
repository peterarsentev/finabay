package ru.job4j.service;

import ru.job4j.domain.Loan;

import java.util.List;

/**
 * Application must expose REST API endpoints for the following functionality:
 * apply for loan (loan amount, term, name, surname and personal id must be provided)
 * list all approved loans
 * list all approved loans by user
 * Service must perform loan application validation according to the following rules and reject application if:
 * Application comes from blacklisted personal id
 * N application / second are received from a single country (essentially we want to limit number of loan applications coming from a country in a given timeframe)
 * Service must perform origin country resolution using a web service (you should choose one) and store country code together with the loan application. Because network is unreliable and services tend to fail, let's agree on default country code - "lv".
 *
 * @author parsentev
 * @since 21.09.2016
 */
public interface LoanService {
    Loan apply(Loan loan);

    List<Loan> getAll();

    List<Loan> getByPerson(int personId);
}
