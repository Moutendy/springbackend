package com.example.projetone.Services;

import com.example.projetone.Dao.IAppliance;
import com.example.projetone.Dao.IType;
import com.example.projetone.Entite.Appliance;
import com.example.projetone.Entite.Type;
import com.lowagie.text.pdf.BaseFont;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.hibernate.annotations.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ServicesAppliance
{
    @Autowired
    IAppliance iAppliance;
    @Autowired
    IType iType;

    public static  String RESOURCE = "resources/appliance.jrxml";

    public List<Appliance> afficher()
    {
        return iAppliance.findAll();
    }

    public Optional<Appliance> afficherInfod(Long id)
    {
        return iAppliance.findById(id);
    }

    public void ajouter(Appliance appliance)
    {
        iAppliance.save(appliance);
    }

    public void supprimer(Long id)
    {
        iAppliance.deleteById(id);
    }

    public void modification(Appliance appliance)
    {
        if(iAppliance.existsById(appliance.getId()))
        {
            iAppliance.save(appliance);
        }

    }

    public String exportReport() throws IOException, JRException {
       //recupperer les appliances
        List<Appliance> appliances=iAppliance.findAll();
        //recupperer le fichier .jrxml
        File file = ResourceUtils.getFile("classpath:appliance.jrxml");
        //compilation de fichier .jrxml
        JasperReport jasperReport= JasperCompileManager.compileReport(file.getAbsolutePath());
        //recupperer l'entite
        JRBeanCollectionDataSource jrBeanCollectionDataSource= new JRBeanCollectionDataSource(appliances);
        //on definit les parameters
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("createdBy","Java Techie");
        //fait le rapport
        JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport,parameters,jrBeanCollectionDataSource);
        String path="I:\\applianceisicode\\ProjetAppliance";



             //export le fichier pdf cr??e vers le dossier choisi
            JasperExportManager.exportReportToPdfFile(jasperPrint,path+"\\appliance.pdf");


        return "";
    }

    public JasperPrint fillReport() throws IOException, JRException, ClassNotFoundException {
        List<Appliance> appliances=iAppliance.findAll();
        InputStream resource = new ClassPathResource(RESOURCE).getInputStream();
        JasperReport jasperReport = JasperCompileManager.compileReport(resource);
        JRBeanCollectionDataSource dataSource= new JRBeanCollectionDataSource(appliances);
        //on definit les parameters
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("createdBy","Java Techie");

        return JasperFillManager.fillReport(jasperReport,parameters,dataSource);
    }
}
