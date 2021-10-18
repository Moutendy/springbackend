package com.example.projetone.Controller;

import com.example.projetone.Entite.Suivie;

import com.example.projetone.Services.ServiceSuivie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/apisuivie")
@RestController
public class ControllerSuivie {

    @Autowired
    ServiceSuivie serviceSuivie;

    @PostMapping(path = "/ajoutersuivie")
    public void ajouter(@RequestBody Suivie suivie)
    {
        System.err.println("le suivie :"+suivie.getMontant());
        serviceSuivie.ajouter(suivie);
    }

    @GetMapping(path = "/affichersuivie")
    public List<Suivie> afficher()
    {

    return serviceSuivie.afficher();
    }

    @GetMapping(path = "affichersuivi/{id}")
    public Optional<Suivie> affiche(@PathVariable Long id)
    {

        return serviceSuivie.afficherInfod(id);
    }

    @GetMapping(path = "deletesuivie/{id}")
    public void suppression(@PathVariable Long id)
    {

        serviceSuivie.supprimer(id);
    }

    @PatchMapping(path = "modificationSuivie/{id}")
    public void modification(@RequestBody Suivie suivis, @PathVariable Long id)
    {
        if(id!=0)
        {
            suivis.setId(id);
            serviceSuivie.modification(suivis);
        }
    }
}
