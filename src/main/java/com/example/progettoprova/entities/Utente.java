package com.example.progettoprova.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Utente {
    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL)
    private List<Annuncio> annunci=new ArrayList<>();

    @OneToMany(mappedBy = "utente",cascade = CascadeType.ALL)
    private List<Recensione> recensioni= new ArrayList<>();

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
