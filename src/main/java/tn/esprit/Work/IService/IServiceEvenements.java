package tn.esprit.Work.IService;

import tn.esprit.Work.model.Evenements;

import java.util.List;

public interface IServiceEvenements {



    Evenements addE(Evenements Evenement);

    String DeleteEvenement(Long EvenementId);

    Evenements updateEvenement(Evenements Evenement);

    List<Evenements> retrieveAllEvenement();

    Evenements findEvenementById(Long id);
    
    
}
