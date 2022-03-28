package tn.esprit.Work.Serice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Work.IService.IServiceOffer;
import tn.esprit.Work.Repository.IRepositoryOffer;
import tn.esprit.Work.model.Evenements;
import tn.esprit.Work.model.Offer;

import java.util.List;

@Service
public class ServiceOffer implements IServiceOffer {

    @Autowired
    IRepositoryOffer repositoryOffer ;

    @Override
    public Offer addE(Offer q) {
        return repositoryOffer.save(q);
    }

    @Override
    public String DeleteOffer(Long oId) {
        repositoryOffer.delete(repositoryOffer.findById(oId).get());
        return"Deleted";
    }

    @Override
    public Offer updateOffer(Offer Offer) {
        return repositoryOffer.save(Offer);
    }

    @Override
    public List<Offer> retrieveAllOffer() {
        List<Offer> offers=(List<Offer>)repositoryOffer.findAll();
        return offers;
    }

    @Override
    public Offer findOfferById(Long id) {
        return this.repositoryOffer.findById(id).orElse(null);

    }
}
