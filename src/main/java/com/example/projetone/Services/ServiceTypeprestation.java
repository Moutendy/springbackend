package com.example.projetone.Services;

import com.example.projetone.Dao.ITypeprestation;
import com.example.projetone.Entite.Type;
import com.example.projetone.Entite.Typeprestation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceTypeprestation
{
    @Autowired
    ITypeprestation iTypeprestation;
    public List<Typeprestation> afficher()
    {
        return iTypeprestation.findAll();
    }

    public Optional<Typeprestation> afficherInfod(Long id)
    {
        return iTypeprestation.findById(id);
    }

    public void ajouter(Typeprestation typesprestation)
    {
        iTypeprestation.save(typesprestation);
    }

    public void supprimer(Long id)
    {
        iTypeprestation.deleteById(id);
    }

    public void modification(Typeprestation typesprestation)
    {
        if(iTypeprestation.existsById(typesprestation.getId()))
        {
            iTypeprestation.save(typesprestation);
        }

    }

}
