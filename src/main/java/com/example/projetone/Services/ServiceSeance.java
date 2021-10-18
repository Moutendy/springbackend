package com.example.projetone.Services;

import com.example.projetone.Dao.ISeance;
import com.example.projetone.Entite.Pov;
import com.example.projetone.Entite.Seance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceSeance
{
    @Autowired
    ISeance seance;
    public List<Seance> afficher()
    {
        return seance.findAll();
    }

    public Optional<Seance> afficherInfod(Long id)
    {
        return seance.findById(id);
    }

    public void ajouter(Seance seances)
    {
        seance.save(seances);
    }

    public void supprimer(Long id)
    {
        seance.deleteById(id);
    }

    public void modification(Seance seances)
    {
        if(seance.existsById(seances.getId()))
        {
            seance.save(seances);
        }

    }
}
