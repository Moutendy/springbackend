package com.example.projetone.Controller;

import com.example.projetone.Entite.Type;


import com.example.projetone.Services.ServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/apitype")
@RestController
public class ControllerType
{
    @Autowired
    ServiceType serviceType;

    @PostMapping(path = "/ajouterType")
    public void ajouter(@RequestBody Type type)
    {
        serviceType.ajouter(type);
    }

    @GetMapping(path = "/afficherType")
    public List<Type> afficher()
    {

        return serviceType.afficher();
    }

    @GetMapping(path = "afficherType/{id}")
    public Optional<Type> affiche(@PathVariable Long id)
    {

        return serviceType.afficherInfod(id);
    }

    @GetMapping(path = "deleteType/{id}")
    public void suppression(@PathVariable Long id)
    {

        serviceType.supprimer(id);
    }


    @PatchMapping(path = "modificationType/{id}")
    public void modification(@RequestBody Type type, @PathVariable Long id)
    {
              if(id!=0)
              {
                  type.setId(id);
                  serviceType.modification(type);
              }

    }
}
