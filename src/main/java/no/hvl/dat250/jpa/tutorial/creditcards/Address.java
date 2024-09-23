package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private Integer number;

    @ManyToMany
    private List<Customer> owners;

    public String getStreet() {
        return street;
    }

    public Integer getNumber() {
        return number;
    }

    public Collection<Customer> getOwners() {
        return owners;
    }
}
