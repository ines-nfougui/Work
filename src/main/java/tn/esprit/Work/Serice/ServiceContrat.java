package tn.esprit.Work.Serice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Work.IService.IServiceColloboration;
import tn.esprit.Work.IService.IServiceContrat;
import tn.esprit.Work.Repository.IRepositoryContrat;
import tn.esprit.Work.model.Collaborateur;
import tn.esprit.Work.model.Contrat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ServiceContrat implements IServiceContrat {
    @Autowired
    IRepositoryContrat repositoryContrat ;

    @Autowired
    IServiceColloboration serviceColl;
    @Override
    public Contrat addContrat(Contrat c,Long idcoll) {
        Collaborateur col =serviceColl.findCollobrationById(idcoll);
        c.setIdColl(col);
        c.setDateSegniateur(new Date());
        return repositoryContrat.save(c);
    }

    @Override
    public String DeleteContrat(Long corrId) {
        repositoryContrat.delete(repositoryContrat.findById(corrId).get());
        return"Deleted";
    }

    @Override
    public Contrat updateContrat(Contrat c) {
        return repositoryContrat.save(c);
    }

    @Override
    public List<Contrat> retrieveAllContrat() {
        return (List<Contrat>) repositoryContrat.findAll();
    }

    @Override
    public Contrat findContratById(Long id) {
       return this.repositoryContrat.findById(id).orElse(null);

    }

    @Override
    public List<Contrat> findContratWithMaxMontant() {

        float i=0;
        List<Contrat> lc = retrieveAllContrat();
        List<Contrat> lnewc = new ArrayList<>();


        for (Contrat c :
                lc) {
            if (c.getMontant() > i)
                i=c.getMontant();
        }

        for (Contrat c :
                lc) {
            if (c.getMontant() >= i)
                lnewc.add(c);
        }


        return lnewc;
    }

    @Override
    public float SommeMontant() {
        return repositoryContrat.getSommeMontant();
    }
}
