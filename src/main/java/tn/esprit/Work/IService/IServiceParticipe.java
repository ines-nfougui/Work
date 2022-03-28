package tn.esprit.Work.IService;

import org.springframework.stereotype.Service;
import tn.esprit.Work.model.Participe;

import java.util.List;

@Service
public interface IServiceParticipe {

    Participe affecterParticipation(Participe p ,Long idUser ,Long idEvenement);
    List<Participe> retriveParticipe();
    List<Participe> retriveParticipeByEvent(Long iEvent);
    List<Participe> retriveParticipeByUser(Long idUser);
}
