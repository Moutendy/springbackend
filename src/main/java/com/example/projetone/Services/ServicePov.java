package com.example.projetone.Services;

import com.example.projetone.Dao.POV;
import com.example.projetone.Entite.Appliance;
import com.example.projetone.Entite.Pov;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicePov
{
    @Autowired
    POV pov;


    public List<Pov> afficher()
    {
        return pov.findAll();
    }

    public Optional<Pov> afficherInfod(Long id)
    {
        return pov.findById(id);
    }

    public void ajouter(Pov povs)
    {
        pov.save(povs);
    }

    public void supprimer(Long id)
    {
        pov.deleteById(id);
    }

    public void modification(Pov povs)
    {
        if(pov.existsById(povs.getId()))
        {
            pov.save(povs);
        }

    }

    public List<Pov>chercherPovdesclient(Long idclient)
    {
        List<Pov> list = pov.chercherPov(idclient);
        return list;
    }
}
