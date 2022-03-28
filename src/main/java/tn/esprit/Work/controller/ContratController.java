package tn.esprit.Work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.Work.IService.IServiceContrat;
import tn.esprit.Work.Serice.MapValidationErrorService;
import tn.esprit.Work.Validator.ContratValidator;
import tn.esprit.Work.model.Collaborateur;
import tn.esprit.Work.model.Contrat;
import tn.esprit.Work.model.Publicite;
import tn.esprit.Work.model.UploadImagePublication;
import tn.esprit.Work.model.UploadImagePublicite;

import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/contrat")
public class ContratController {

    @Autowired
    IServiceContrat serviceContrat;

    @Autowired
    ContratValidator contratValidator ;

    @Autowired
    MapValidationErrorService mapValidationErrorService ;

    @GetMapping("/retrieve-all-contrat")
    @ResponseBody
    public List<Contrat> getAllContrat() {
        return serviceContrat.retrieveAllContrat();
    }

    @DeleteMapping("/remove-contra/{contrat-id}")
    @ResponseBody
    public void removContrat(@PathVariable("contrat-id")  long contratId) {
        serviceContrat.DeleteContrat(contratId);

    }


    @PostMapping("/add-contrat/{idcontrat}")
    @ResponseBody
    public ResponseEntity<?> addContrat(@Valid Contrat c , @RequestParam("montant") float montant , @RequestParam("file") @Nullable MultipartFile file , BindingResult result , @PathVariable("idcontrat")  long idcoll) {
        contratValidator.validate(c,result);
        ResponseEntity<?> erroMap =mapValidationErrorService.MapValidationService(result);
        if(erroMap != null)return erroMap;


            try {
                c.setData(file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            c.setName(file.getOriginalFilename());
            c.setMontant(montant);
        Contrat comm = serviceContrat.addContrat(c,idcoll);
        return new ResponseEntity<Contrat>( comm, HttpStatus.CREATED);
    }

    @PutMapping("/modify-coll")
    @ResponseBody
    public Contrat modifyContrat(@RequestBody Contrat c) {
        return serviceContrat.updateContrat(c);
    }


    @GetMapping("/retrieve-coll/{contraID}")
    @ResponseBody
    public Contrat retrieveContrat(@PathVariable("contraID") long contratId) {
        return serviceContrat.findContratById(contratId);  }

    
    @GetMapping("/sommemontant")
    @ResponseBody
    public float SommeMontant() {
        return serviceContrat.SommeMontant();  }

    
    @GetMapping("/maxContrat")
    @ResponseBody
    public List <Contrat>ContratWithMaxMontant() {
        return serviceContrat.findContratWithMaxMontant();  }

}
