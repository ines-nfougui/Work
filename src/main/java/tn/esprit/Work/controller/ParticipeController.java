package tn.esprit.Work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.Work.IService.IServiceParticipe;
import tn.esprit.Work.model.Evenements;
import tn.esprit.Work.model.Offer;
import tn.esprit.Work.model.Participe;

import java.util.List;

@RestController
public class ParticipeController {

    @Autowired
    IServiceParticipe serviceParticipe ;

    @GetMapping("/retrieve-all-participe")
    @ResponseBody
    public List<Participe> getAllParticipe() {
        return serviceParticipe.retriveParticipe();
    }

    @GetMapping("/retrieve-all-participe/{idUser}")
    @ResponseBody
    public List<Participe> getAllParticipeByUser(@PathVariable("idUser") long idUser) {
        return serviceParticipe.retriveParticipeByUser(idUser);
    }

    @GetMapping("/retrieve-all-participe/{IdEvent}")
    @ResponseBody
    public List<Participe> getAllParticipeByEvent(@PathVariable("IdEvent") long idEvent) {
        return serviceParticipe.retriveParticipeByEvent(idEvent);
    }

    @GetMapping("/affecter/{IdEvent}/{idUser}")
    @ResponseBody
    public Participe affecterParticipation(@PathVariable("IdEvent") long idEvent, @PathVariable("idUser") long idUser, Participe p) {
        return serviceParticipe.affecterParticipation(p,idUser,idEvent);
    }

}
