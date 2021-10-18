package com.example.projetone.Controller;

import com.example.projetone.Entite.Type;
import com.example.projetone.Entite.Typeprestation;
import com.example.projetone.Services.ServiceTypeprestation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/apitypeprestation")
@RestController
public class ControllerTypeprestation
{
    @Autowired
    ServiceTypeprestation serviceTypeprestation;

    @PostMapping(path = "/ajouterTypeprestation")
    public void ajouter(@RequestBody Typeprestation typeprestation)
    {
        serviceTypeprestation.ajouter(typeprestation);
    }

    @GetMapping(path = "/afficherTypeprestation")
    public List<Typeprestation> afficher()
    {

        return serviceTypeprestation.afficher();
    }

    @GetMapping(path = "afficherTypeprestation/{id}")
    public Optional<Typeprestation> affiche(@PathVariable Long id)
    {

        return serviceTypeprestation.afficherInfod(id);
    }

    @GetMapping(path = "deleteTypeprestation/{id}")
    public void suppression(@PathVariable Long id)
    {

        serviceTypeprestation.supprimer(id);
    }

    @PatchMapping(path = "modificationTypeprestation/{id}")
    public void modification(@RequestBody Typeprestation typeprestation, @PathVariable Long id)
    {


        if(id!=0)
        {
            typeprestation.setId(id);
            serviceTypeprestation.modification(typeprestation);

        }else
        {

        }
    }
}
