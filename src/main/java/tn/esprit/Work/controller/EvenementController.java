package tn.esprit.Work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Work.IService.IServiceEvenements;
import tn.esprit.Work.model.Evenements;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EvenementController {


    @Autowired
    IServiceEvenements serviceEvenements ;

    @GetMapping("/retrieve-all-evenemnts")
    @ResponseBody
    public List<Evenements> getAllEvenements() {
        return serviceEvenements.retrieveAllEvenement();
    }


    @DeleteMapping("/remove-evenement/{eventId}")
    @ResponseBody
    public void removEvenement(@PathVariable("eventId")  long eventId) {
        serviceEvenements.DeleteEvenement(eventId);

    }

    @PutMapping("/modify-evenement")
    @ResponseBody
    public Evenements modifyEvenement(@RequestBody Evenements c) {
        return serviceEvenements.updateEvenement(c);
    }


    @GetMapping("/retrieve-event/{eventId}")
    @ResponseBody
    public Evenements retrieveEvent(@PathVariable("eventId") long eventId) {
        return serviceEvenements.findEvenementById(eventId);  }


}
