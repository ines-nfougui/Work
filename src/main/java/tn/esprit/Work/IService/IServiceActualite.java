package tn.esprit.Work.IService;

import tn.esprit.Work.model.Actualite;
import tn.esprit.Work.model.Collaborateur;

public interface IServiceActualite {

    Actualite addActualite(Actualite c);

    String DeleteActualite(Long corrId);

    Actualite findActualiteById(Long id);

}
