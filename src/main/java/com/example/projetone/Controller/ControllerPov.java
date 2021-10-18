package com.example.projetone.Controller;

import com.example.projetone.Entite.Pov;
import com.example.projetone.Services.ServicePov;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/apipov")
@RestController
public class ControllerPov
{
    @Autowired
    ServicePov servicePov;

    @PostMapping(path = "/ajouterPov")
    public void ajouter(@RequestBody Pov pov)
    {
        servicePov.ajouter(pov);
    }

    @GetMapping(path = "/afficherPov")
    public List<Pov> afficher()
    {

        return servicePov.afficher();
    }

    @GetMapping(path = "afficherPov/{id}")
    public Optional<Pov> affiche(@PathVariable Long id)
    {

        return servicePov.afficherInfod(id);
    }

    @GetMapping(path = "deletePov/{id}")
    public void suppression(@PathVariable Long id)
    {

        servicePov.supprimer(id);
    }
    @PatchMapping(path = "modificationPov/{id}")
    public void modification(@RequestBody Pov pov,@PathVariable Long id)
    {
        if(id!=0)
        {
            pov.setId(id);
            servicePov.modification(pov);
        }
    }
    @GetMapping(path = "recherchePov/{id}")
    public List<Pov> recherchePov(@PathVariable Long id)
    {
     return servicePov.chercherPovdesclient(id);

    }
}
