package tn.esprit.Work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Work.IService.IServiceColloboration;
import tn.esprit.Work.model.Collaborateur;

import java.util.List;

@RestController
@RequestMapping("/coll")
public class CollobrateurController {

    @Autowired
    IServiceColloboration serviceColloboration ;

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
