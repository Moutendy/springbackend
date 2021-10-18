package com.example.projetone.Dao;

import com.example.projetone.Entite.Pov;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface POV extends JpaRepository<Pov,Long>
{
    //chercher les pov des clients
    @Query("select p from Pov p join p.client c Where c.id=:x")
    public List<Pov> chercherPov(@Param("x")Long mc);

}
