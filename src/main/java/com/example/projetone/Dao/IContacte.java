package com.example.projetone.Dao;

import com.example.projetone.Entite.Contact;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IContacte extends JpaRepository<Contact,Long> {
}
