package com.example.projetone.Services;

import com.example.projetone.Dao.ISuivie;
import com.example.projetone.Entite.Seance;
import com.example.projetone.Entite.Suivie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceSuivie
{
    @Autowired
    ISuivie iSuivie;
    public List<Suivie> afficher()
    {
        return iSuivie.findAll();
    }

    public Optional<Suivie> afficherInfod(Long id)
    {
        return iSuivie.findById(id);
    }

    public void ajouter(Suivie suivis)
    {
        iSuivie.save(suivis);
    }

    public void supprimer(Long id)
    {
        iSuivie.deleteById(id);
    }

    public void modification(Suivie suivie)
    {
        if(iSuivie.existsById(suivie.getId()))
        {
            iSuivie.save(suivie);
        }

    }
}
