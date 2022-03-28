package tn.esprit.Work.IService;


import tn.esprit.Work.model.Offer;

import java.util.List;

public interface IServiceOffer {

    Offer addE(Offer q);

    String DeleteOffer(Long oId);

    Offer updateOffer(Offer Offer);

    List<Offer> retrieveAllOffer();

    Offer findOfferById(Long id);
    
    
}
