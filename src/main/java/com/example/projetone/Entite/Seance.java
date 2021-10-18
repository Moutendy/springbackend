package com.example.projetone.Entite;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Seance implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private Date dateSeance;

    public Pov getPov() {
        return pov;
    }

    public void setPov(Pov pov) {
        this.pov = pov;
    }

    @ManyToOne
    private Pov pov;

    public Date getDateSeance() {
        return dateSeance;
    }

    public void setDateSeance(Date dateSeance) {
        this.dateSeance = dateSeance;
    }

    public String getResumer() {
        return Resumer;
    }

    public void setResumer(String resumer) {
        Resumer = resumer;
    }

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

    private String Resumer;

   private String participant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
