package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

@Entity
public class Pincode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pincode;
    private Integer count;

    public Long getId() {
        return id;
    }

    public String getCode() {
        return pincode;
    }

    public Integer getCount() {
        return count;
    }
}
