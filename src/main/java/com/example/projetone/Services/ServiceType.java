package com.example.projetone.Services;

import com.example.projetone.Dao.IType;
import com.example.projetone.Entite.Pov;
import com.example.projetone.Entite.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceType
{
    @Autowired
    IType type;

    public List<Type> afficher()
    {
        return type.findAll();
    }

    public Optional<Type> afficherInfod(Long id)
    {
        return type.findById(id);
    }

    public void ajouter(Type types)
    {
        type.save(types);
    }

    public void supprimer(Long id)
    {
        type.deleteById(id);
    }

    public void modification(Type types)
    {
        if(type.existsById(types.getId())) {
            type.save(types);
        }
    }
}
