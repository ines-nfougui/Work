package tn.esprit.Work.IService;


import tn.esprit.Work.model.Collaborateur;

import java.util.List;

public interface IServiceColloboration {


    Collaborateur  addCollobration(Collaborateur c);

    String DeleteCollobration(Long corrId);

    Collaborateur updateCollobration(Collaborateur c);

    List<Collaborateur> retrieveAllCollobration();

    Collaborateur findCollobrationById(Long id);
}
