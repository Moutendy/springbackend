package com.example.projetone.Controller;

import com.example.projetone.Entite.Appliance;
import com.example.projetone.Entite.Pov;
import com.example.projetone.Entite.Seance;
import com.example.projetone.Services.ServiceSeance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/apiseance")
@RestController
public class ControllerSeance
{
    @Autowired
    ServiceSeance serviceSeance;



    @PostMapping(path = "/ajouterSeance")
    public void ajouter(@RequestBody Seance seance)
    {

        serviceSeance.ajouter(seance);
    }

    @GetMapping(path = "/afficherSeance")
    public List<Seance> afficher()
    {

        return serviceSeance.afficher();
    }

    @GetMapping(path = "afficherSeance/{id}")
    public Optional<Seance> affiche(@PathVariable Long id)
    {

        return serviceSeance.afficherInfod(id);
    }

    @GetMapping(path = "deleteSeance/{id}")
    public void suppression(@PathVariable Long id)
    {

        serviceSeance.supprimer(id);
    }

    @PatchMapping(path = "modificationSeance/{id}")
    public void modification(@RequestBody Seance seance, @PathVariable Long id)
    {
        if(id!=0)
        {
            seance.setId(id);
            serviceSeance.modification(seance);
        }
    }
}
