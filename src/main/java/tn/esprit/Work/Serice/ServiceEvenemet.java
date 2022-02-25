package tn.esprit.Work.Serice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Work.IService.IServiceEvenements;
import tn.esprit.Work.Repository.IRepositoryEvenement;
import tn.esprit.Work.model.Evenements;
import tn.esprit.Work.model.Question;

import java.util.List;

@Service
public class ServiceEvenemet implements IServiceEvenements {


    @Autowired
    IRepositoryEvenement repositoryEvenement ;
    @Override
    public Evenements addE(Evenements Evenement) {
        return repositoryEvenement.save(Evenement);
    }

    @Override
    public String DeleteEvenement(Long EvenementId) {
        repositoryEvenement.delete(repositoryEvenement.findById(EvenementId).get());
        return"Deleted";
    }

    @Override
    public Evenements updateEvenement(Evenements Evenement) {
        repositoryEvenement.save(Evenement);
        return Evenement ;
    }

    @Override
    public List<Evenements> retrieveAllEvenement() {
        List<Evenements> events=(List<Evenements>)repositoryEvenement.findAll();
        return events;
    }

    @Override
    public Evenements findEvenementById(Long id) {
        return this.repositoryEvenement.findById(id).orElse(null);
    }
}
