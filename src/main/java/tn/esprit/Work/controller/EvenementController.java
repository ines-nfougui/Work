package tn.esprit.Work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Work.IService.IServiceEvenements;
import tn.esprit.Work.Serice.MapValidationErrorService;
import tn.esprit.Work.Validator.EvenementValidator;
import tn.esprit.Work.model.Actualite;
import tn.esprit.Work.model.Evenements;
import tn.esprit.Work.model.Offer;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/event")
public class EvenementController {


    @Autowired
    IServiceEvenements serviceEvenements ;
    @Autowired
    EvenementValidator evenementValidator ;

    @Autowired
    MapValidationErrorService mapValidationErrorService ;

    @GetMapping("/retrieve-all-evenemnts")
    @ResponseBody
    public List<Evenements> getAllEvenements() {
        return serviceEvenements.retrieveAllEvenement();
    }


    @DeleteMapping("/remove-evenement/{eventId}")
    @ResponseBody
    public String removEvenement(@PathVariable("eventId")  long eventId) {
      return   serviceEvenements.DeleteEvenement(eventId);

    }

    @PostMapping("/add-event")
    @ResponseBody
    public ResponseEntity<?> addEvent(@Valid @RequestBody Evenements c , BindingResult result) {
        evenementValidator.validate(c,result);
        ResponseEntity<?> erroMap =mapValidationErrorService.MapValidationService(result);
        if(erroMap != null)return erroMap;
        Evenements o = serviceEvenements.addE(c);
        Actualite a = new Actualite();
        //a.setIdevent();
        return new ResponseEntity<Evenements>( o, HttpStatus.CREATED);
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
