package com.example.projetone.Controller;

import com.example.projetone.Entite.Appliance;
import com.example.projetone.Services.ServicesAppliance;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/apiappliance")
@RestController
public class ControllerAppliance
{
    @Autowired
    ServicesAppliance servicesAppliance;



    @PostMapping(path = "/ajouterAppliance")
    public void ajouter(@RequestBody Appliance appliance)
    {
        servicesAppliance.ajouter(appliance);
    }

    @GetMapping(path = "/afficherAppliance")
    public List<Appliance> afficher()
    {

        return servicesAppliance.afficher();
    }
    @GetMapping(path = "affichePdf")
    public void afficherPdf() throws JRException, IOException {
        servicesAppliance.exportReport();
    }

    @GetMapping(path = "afficherAppliance/{id}")
    public Optional<Appliance> affiche(@PathVariable Long id)
    {

        return servicesAppliance.afficherInfod(id);
    }

    @GetMapping(path = "afficherAppliancePdf")
    public JasperPrint afficheAppliancePdf() throws JRException, IOException, ClassNotFoundException {

        return servicesAppliance.fillReport();
    }



    @GetMapping(path = "deleteAppliance/{id}")
    public void suppression(@PathVariable Long id)
    {

        servicesAppliance.supprimer(id);
    }


    @PatchMapping(path = "modificationAppliance/{id}")
    public void modification(@RequestBody Appliance appliance,@PathVariable Long id)
    {
        if(id!=0)
        {
            appliance.setId(id);
            servicesAppliance.modification(appliance);
        }
    }
}
