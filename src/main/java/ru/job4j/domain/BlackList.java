package ru.job4j.domain;

import javax.persistence.*;

/**
 * //TODO add comments
 *
 * @author parsentev
 * @since 21.09.2016
 */
@Entity(name = "blacklist")
public class BlackList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="person_id")
    private Person person;

    public BlackList() {
    }

    public BlackList(Person person) {
        this();
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

        BlackList blackList = (BlackList) o;

        return id == blackList.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
