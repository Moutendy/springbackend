package com.example.projetone.Dao;

import com.example.projetone.Entite.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISeance extends JpaRepository<Seance,Long> {
}
