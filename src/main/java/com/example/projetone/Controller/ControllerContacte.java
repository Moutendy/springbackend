package com.example.projetone.Controller;

import com.example.projetone.Dao.IContacte;
import com.example.projetone.Entite.Client;
import com.example.projetone.Entite.Contact;
import com.example.projetone.Services.ServiceContacte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/apicontact")
@RestController
public class ControllerContacte
{
    @Autowired
    ServiceContacte contacte;

    @Autowired
    IContacte iContacte;
    @PostMapping(path = "/ajouterContact")
    public void ajouter(@RequestBody Contact contact)
    {
        contacte.ajouter(contact);
    }

    @GetMapping(path = "/afficherContact")
    public List<Contact> afficher()
    {

        return contacte.afficher();
    }

    @GetMapping(path = "afficherContact/{id}")
    public Optional<Contact> affiche(@PathVariable Long id)
    {

        return contacte.afficherInfod(id);
    }

    @GetMapping(path = "deleteContact/{id}")
    public void suppression(@PathVariable Long id)
    {

       contacte.supprimer(id);
    }
    @PatchMapping(path = "modification/{id}")
    public void modification(@RequestBody Contact contact,@PathVariable Long id)
    {
       if(id!=0)
       {
           contact.setId(id);
           contacte.modification(contact);
       }

    }
}
