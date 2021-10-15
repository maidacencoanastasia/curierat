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

    public Status() {
        
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public Date getData() {
        return data;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public Status(int id, String status, Date data, Comanda comanda) {
        this.id = id;
        this.status = status;
        this.data = data;
        this.comanda = comanda;
    }
}
