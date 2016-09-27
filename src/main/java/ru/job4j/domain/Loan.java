package ru.job4j.domain;

import javax.persistence.*;

/**
 * apply for loan (loan amount, term, name, surname and personal id must be provided)
 *
 * @author Petr Arsentev parsentev@yandex.ru
 * @since 21.09.2016
 */
@Entity(name = "loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String term;
    private double amount;

    @ManyToOne
    @JoinColumn(name="country_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name="person_id")
    private Person person;

    public Loan() {
    }

    public Loan(String term, double amount, Country country, Person person) {
        this();
        this.term = term;
        this.amount = amount;
        this.country = country;
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Loan loan = (Loan) o;

        return id == loan.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
