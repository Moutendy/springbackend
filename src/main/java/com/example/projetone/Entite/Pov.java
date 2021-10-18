package com.example.projetone.Entite;



import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Pov implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    @ManyToOne
    private Client client;

    @ManyToOne
    private Appliance appliance;

    private String description;
    private String ingenieurCybersecurite;
    private String analyseCybersecurite;
    private String LIBELLE;
    private String Compte;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Appliance getAppliance() {
        return appliance;
    }

    public void setAppliance(Appliance appliance) {
        this.appliance = appliance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngenieurCybersecurite() {
        return ingenieurCybersecurite;
    }

    public void setIngenieurCybersecurite(String ingenieurCybersecurite)
    {
        this.ingenieurCybersecurite = ingenieurCybersecurite;
    }

    public String getAnalyseCybersecurite() {
        return analyseCybersecurite;
    }

    public void setAnalyseCybersecurite(String analyseCybersecurite) {
        this.analyseCybersecurite = analyseCybersecurite;
    }

    public String getLIBELLE() {
        return LIBELLE;
    }

    public void setLIBELLE(String LIBELLE) {
        this.LIBELLE = LIBELLE;
    }

    public String getCompte() {
        return Compte;
    }

    public void setCompte(String compte) {
         this.Compte = compte;
    }

    public Date getDatededebut() {
        return datededebut;
    }

    public void setDatededebut(Date datededebut) {
        this.datededebut = datededebut;
    }

    public Date getDatedefin() {
        return datedefin;
    }

    public void setDatedefin(Date datedefin) {
        this.datedefin = datedefin;
    }

    private Date datededebut;

    private Date datedefin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
