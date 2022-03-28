package tn.esprit.Work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Work.IService.IServiceColloboration;
import tn.esprit.Work.Serice.MapValidationErrorService;
import tn.esprit.Work.Validator.Collaborateurvalidator;
import tn.esprit.Work.Validator.CommentaireValidator;
import tn.esprit.Work.model.Collaborateur;
import tn.esprit.Work.model.Commentaire;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/coll")
public class CollobrateurController {

    @Autowired
    IServiceColloboration serviceColloboration ;

    @Autowired
    MapValidationErrorService mapValidationErrorService ;

    @Autowired
    Collaborateurvalidator collaborateurvalidator ;
    
    @GetMapping("/retrieve-all-collobration")
    @ResponseBody
    public List<Collaborateur> getAllColloboration() {
        return serviceColloboration.retrieveAllCollobration();
    }

    @DeleteMapping("/remove-collob/{coll-id}")
    @ResponseBody
    public void removColl(@PathVariable("coll-id")  long collobId) {
        serviceColloboration.DeleteCollobration(collobId);

    }
    
    
    @PostMapping("/add-coll")
    @ResponseBody
    public ResponseEntity<?> addComment(@Valid @RequestBody Collaborateur c , BindingResult result ) {
    	collaborateurvalidator.validate(c,result);
        ResponseEntity<?> erroMap =mapValidationErrorService.MapValidationService(result);
        if(erroMap != null)return erroMap;

        Collaborateur comm = serviceColloboration.addCollobration(c);
        return new ResponseEntity<Collaborateur>( comm, HttpStatus.CREATED);
    }

    @PutMapping("/modify-coll")
    @ResponseBody
    public Collaborateur modifyColl(@RequestBody Collaborateur c) {
        return serviceColloboration.updateCollobration(c);
    }


    @GetMapping("/retrieve-coll/{CollId}")
    @ResponseBody
    public Collaborateur retrieveColl(@PathVariable("CollId") long colliD) {
        return serviceColloboration.findCollobrationById(colliD);  }



}
