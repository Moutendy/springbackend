package com.example.projetone.Services;

import com.example.projetone.Dao.IContacte;
import com.example.projetone.Entite.Appliance;
import com.example.projetone.Entite.Contact;
import com.example.projetone.dto.ContactDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceContacte
{
    @Autowired
    IContacte iContacte;
    public List<Contact> afficher()
    {
        return iContacte.findAll();
    }

    public Optional<Contact> afficherInfod(Long id)
    {
        return iContacte.findById(id);
    }

    public void ajouter(Contact contacte)
    {
        System.out.print(contacte);
        iContacte.save(contacte);
    }

    public void supprimer(Long id)
    {
        iContacte.deleteById(id);
    }

    public void modification(Contact contact)
    {
        if(iContacte.existsById(contact.getId()))
        {
            iContacte.save(contact);
        }


    }
/*
    public void modif(ContactDto dto)
    {
        Contact contact = contactDtoToContact(dto);

        iContacte.save(contact);
    }


    Contact contactDtoToContact(ContactDto dto){
        Contact contact = new Contact();

        contact.setId(dto.getId());

        return contact;
    }*/
}
