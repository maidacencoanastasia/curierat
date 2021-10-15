package com.curierat.curier.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "comenzi")
public class Comanda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String addresa_destinatorului;
    private String adresa_expidetor;
    @ToString.Exclude
    @OneToMany(mappedBy = "status")
    private List<Status> status;


}
