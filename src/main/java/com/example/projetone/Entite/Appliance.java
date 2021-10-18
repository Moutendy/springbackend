package com.example.projetone.Entite;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Appliance implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    public String Libelle;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @ManyToOne
    private Type type;


    public String getLibelle() {
        return Libelle;
    }

    public void setLibelle(String libelle) {
        Libelle = libelle;
    }



    public String getDBiD() {
        return DBiD;
    }

    public void setDBiD(String DBiD) {
        this.DBiD = DBiD;
    }

    public boolean isDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    public String DBiD;
    public String reference;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public boolean disponibilite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
