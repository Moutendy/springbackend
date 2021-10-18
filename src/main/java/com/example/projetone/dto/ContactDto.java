package com.example.projetone.dto;

import com.example.projetone.Entite.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {

    private Long id;
    private String nom;
    private String prenom;
    private String telephone;
    private String fonction;
    private String email;

    private Client client;
}
