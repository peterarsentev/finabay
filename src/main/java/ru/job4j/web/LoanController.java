package ru.job4j.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.job4j.domain.Loan;
import ru.job4j.service.BlackListService;
import ru.job4j.service.LoanService;
import ru.job4j.web.forms.Error;
import ru.job4j.web.forms.Result;
import ru.job4j.web.forms.Success;

import java.util.List;

/**
 *
 * @author Petr Arsentev parsentev@yandex.ru
 * @since 21.09.2016
 */

@RestController
public class LoanController {

    private final LoanService loans;

    private final BlackListService blacklists;

    @Autowired
    public LoanController(final LoanService loans, final BlackListService blacklists) {
        this.loans = loans;
        this.blacklists = blacklists;
    }

    @PostMapping("/")
    public Result apply(@RequestBody Loan loan) {
        final Result result;
        if (!this.blacklists.isBlackListPerson(loan.getPerson().getId())) {
            result = new Success<Loan>(
                    this.loans.apply(loan)
            );
        } else {
            result = new Error(String.format("User %s in blacklist", loan.getPerson().getId()));
        }
        return result;
    }

    @GetMapping("/")
    public List<Loan> getAll() {
        return this.loans.getAll();
    }

    @GetMapping("/{personId}")
    public List<Loan> findByPersonId(@PathVariable int personId) {
        return this.loans.getByPerson(personId);
    }
}
