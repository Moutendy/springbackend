package com.example.projetone.Services;

import com.example.projetone.Dao.IClient;
import com.example.projetone.Entite.Appliance;
import com.example.projetone.Entite.Client;
import com.example.projetone.Entite.Pov;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesClient
{
    @Autowired
    IClient iClient;

    public List<Client> Afficher()
    {
        return iClient.findAll();
    }

    public Optional<Client> afficherInfod(Long id)
    {
        return iClient.findById(id);
    }

    public void ajouter(Client client)
    {
        iClient.save(client);
    }

    public void supprimer(Long id)
    {
        iClient.deleteById(id);
    }

    public void modification(Client client)
    {
        if(iClient.existsById(client.getId()))
        {
            iClient.save(client);
        }

    }
}
