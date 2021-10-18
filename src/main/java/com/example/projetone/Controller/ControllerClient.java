package com.example.projetone.Controller;

import com.example.projetone.Entite.Appliance;
import com.example.projetone.Entite.Client;
import com.example.projetone.Services.ServicesClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RequestMapping(value = "/api")
@RestController
public class ControllerClient
{
    @Autowired
    ServicesClient servicesClient;

    @PostMapping(path = "/ajouter")
    public void ajouter(@RequestBody Client client)
    {
        servicesClient.ajouter(client);
    }

    @GetMapping(path = "/afficher")
    public List<Client> afficher()
    {
        return servicesClient.Afficher();
    }

    @GetMapping(path = "afficher/{id}")
    public Optional<Client> affiche(@PathVariable Long id)
    {
        return servicesClient.afficherInfod(id);
    }

    @GetMapping(path = "delete/{id}")
    public void suppression(@PathVariable Long id)
    {
        servicesClient.supprimer(id);
    }

    @PatchMapping(path = "modificationClient/{id}")
    public void modification(@RequestBody Client client, @PathVariable Long id)
    {
        if(id!=0)
        {
            client.setId(id);
            servicesClient.modification(client);
        }
    }


}
