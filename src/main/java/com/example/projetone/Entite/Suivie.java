package com.example.projetone.Entite;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Suivie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    private Pov pov;

    @ManyToOne
    private Typeprestation typeprestation;

    public Typeprestation getTypeprestation() {
        return typeprestation;
    }

    public void setTypeprestation(Typeprestation typeprestation) {
        this.typeprestation = typeprestation;
    }

    private String compteRendu;
    private boolean offreCommerciale;
    private double montant;

    public Pov getPov() {
        return pov;
    }

    public void setPov(Pov pov) {
        this.pov = pov;
    }

    public String getCompteRendu() {
        return compteRendu;
    }

    public void setCompteRendu(String compteRendu) {
        this.compteRendu = compteRendu;
    }

    public boolean isOffreCommerciale() {
        return offreCommerciale;
    }

    public void setOffreCommerciale(boolean offreCommerciale) {
        this.offreCommerciale = offreCommerciale;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
