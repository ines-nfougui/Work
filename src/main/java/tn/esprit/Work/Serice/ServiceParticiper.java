package tn.esprit.Work.Serice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Work.IService.IServiceEvenements;
import tn.esprit.Work.IService.IServiceParticipe;
import tn.esprit.Work.Repository.IRepositoryParticipe;
import tn.esprit.Work.Repository.IRepositoryUser;
import tn.esprit.Work.model.Evenements;
import tn.esprit.Work.model.Participe;
import tn.esprit.Work.model.User;

import java.util.List;

@Service
public class ServiceParticiper implements IServiceParticipe {

    @Autowired
    IRepositoryParticipe repositoryParticipe ;
    @Autowired
    IRepositoryUser repositoryUser ;
    @Autowired
    IServiceEvenements serviceEvenements;


    @Override
    public Participe affecterParticipation(Participe p, Long idUser, Long idEvenement) {

        Evenements e = serviceEvenements.findEvenementById(idEvenement);
        User u = repositoryUser.findById(idUser).orElse(null);
        p.setEvenements(e);
        e.setNbrPlace(e.getNbrPlace()-1);
        p.setUser(u);
        serviceEvenements.updateEvenement(e);
        return repositoryParticipe.save(p);
    }

    @Override
    public List<Participe> retriveParticipe() {
        return (List<Participe>) repositoryParticipe.findAll();
    }

    @Override
    public List<Participe> retriveParticipeByEvent(Long idEvent) {
        Evenements e = serviceEvenements.findEvenementById(idEvent);
        return repositoryParticipe.findParticipeByEvenements(e);
    }

    @Override
    public List<Participe> retriveParticipeByUser(Long idUser) {
        User u = repositoryUser.findById(idUser).orElse(null);
        return repositoryParticipe.findParticipeByUser(u);
    }
}
