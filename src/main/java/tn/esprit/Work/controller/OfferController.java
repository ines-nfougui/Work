package tn.esprit.Work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Work.IService.IServiceOffer;
import tn.esprit.Work.Serice.MapValidationErrorService;
import tn.esprit.Work.Validator.OfferValidator;
import tn.esprit.Work.Validator.QuestionValidator;
import tn.esprit.Work.model.Offer;
import tn.esprit.Work.model.Question;

import javax.validation.Valid;
import java.util.List;

@RestController
public class OfferController {


    @Autowired
    IServiceOffer serviceOffer ;
    @Autowired
    MapValidationErrorService mapValidationErrorService ;

    @Autowired
    OfferValidator OfferValidator ;
    @GetMapping("/retrieve-all-offer")
    @ResponseBody
    public List<Offer> getAllOffer() {
        return serviceOffer.retrieveAllOffer();
    }

    @PostMapping("/add-Offer")
    @ResponseBody
    public ResponseEntity<?> addOffer(@Valid @RequestBody Offer c , BindingResult result) {
        OfferValidator.validate(c,result);
        ResponseEntity<?> erroMap =mapValidationErrorService.MapValidationService(result);
        if(erroMap != null)return erroMap;
        Offer o = serviceOffer.addE(c);
        return new ResponseEntity<Offer>( o, HttpStatus.CREATED);
    }


    @DeleteMapping("/remove-offer/{offerId}")
    @ResponseBody
    public String removeOffer(@PathVariable("offerId")  long offerId) {
        return   serviceOffer.DeleteOffer(offerId);

    }

    @PutMapping("/modify-offer")
    @ResponseBody
    public Offer modifyOffer(@RequestBody Offer c) {
        return serviceOffer.updateOffer(c);
    }


    @GetMapping("/retrieve-offer/{offerId}")
    @ResponseBody
    public Offer retrieveOffer(@PathVariable("offerId") long offerId) {
        return serviceOffer.findOfferById(offerId);  }



}
