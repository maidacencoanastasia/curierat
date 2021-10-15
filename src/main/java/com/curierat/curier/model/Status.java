package com.curierat.curier.model;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String status;
    private Date data;
    @ManyToOne
    @JoinColumn(name = "comenzi_id")
    private Comanda comanda;
}
