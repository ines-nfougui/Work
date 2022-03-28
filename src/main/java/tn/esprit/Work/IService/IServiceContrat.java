package tn.esprit.Work.IService;

import org.springframework.stereotype.Service;
import tn.esprit.Work.model.Contrat;

import java.util.List;

@Service
public interface IServiceContrat {



    Contrat addContrat(Contrat c,Long idcoll);

    String DeleteContrat(Long corrId);

    Contrat updateContrat(Contrat c);

    List<Contrat> retrieveAllContrat();

    Contrat findContratById(Long id);

    List<Contrat> findContratWithMaxMontant();

    float SommeMontant();

}
