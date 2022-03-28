package tn.esprit.Work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.Work.IService.IServiceColloboration;
import tn.esprit.Work.IService.IServicePublicite;
import tn.esprit.Work.Serice.MapValidationErrorService;
import tn.esprit.Work.Validator.PublicationValidator;
import tn.esprit.Work.model.Publication;
import tn.esprit.Work.model.Publicite;
import tn.esprit.Work.model.UploadImagePublication;
import tn.esprit.Work.model.UploadImagePublicite;

import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/publicite")
public class PubliciteController {



    @Autowired
    IServicePublicite servicePublicite;
    @Autowired
    MapValidationErrorService mapValidationErrorService ;

    @Autowired
    PublicationValidator publicationValidator ;

    @Autowired
    IServiceColloboration serviceColloboration ;

    @GetMapping("/retrieve-all-publicite")
    @ResponseBody
    public List<Publicite> getAllPublicite() {
        return servicePublicite.retrieveAllPub();
    }

    @PostMapping("/add-pub/{idCol}")
    @ResponseBody
    public ResponseEntity<?> addpub(@Valid @RequestBody Publicite c,@PathVariable("idCol")  long idCol , BindingResult result) {
        publicationValidator.validate(c,result);
        ResponseEntity<?> erroMap =mapValidationErrorService.MapValidationService(result);
        if(erroMap != null)return erroMap;
        c.setIdColl(serviceColloboration.findCollobrationById(idCol));
        Publicite o = servicePublicite.addPub(c);

        return new ResponseEntity<Publicite>( o, HttpStatus.CREATED);
    }


    @DeleteMapping("/remove-pub/{pubId}")
    @ResponseBody
    public String removepub(@PathVariable("pubId")  long pubId) {
        return   servicePublicite.DeletePub(pubId);

    }
    @GetMapping("/stat-pub/{type}")
    @ResponseBody
    public String stat(@PathVariable("type")  String type) {
        return   servicePublicite.statPubliciteParType(type);

    }


    @PutMapping("/modify-pub")
    @ResponseBody
    public Publicite modifyPub(@RequestBody Publicite c) {
        return servicePublicite.updatePub(c);
    }


    @GetMapping("/retrieve-pub/{pubId}")
    @ResponseBody
    public Publicite retrievepub(@PathVariable("pubId") long pubId) {
        return servicePublicite.findPubById(pubId);  }



    @PostMapping("/fileUpload")
    @ResponseBody
    @Transactional
    public Object  uploadImg (@RequestParam("file") @Nullable MultipartFile file, @RequestParam("identifier") Long id) {
        Publicite pub =servicePublicite.findPubById(id);
        if(pub==null)
        {
            Map<String, String> errorDetails= new HashMap<>();
            errorDetails.put("message", "publicite non definit");
            return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
        }
        if(file!=null) {
            UploadImagePublicite image =pub.getImage();

            if(image==null)
            {
                image= new UploadImagePublicite();
                image.setPub(pub);
                pub.setImage(image);
            }

            try {
                image.setData(file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            image.setName(file.getOriginalFilename());

            servicePublicite.saveImage(image);

            servicePublicite.updatePub(pub);
        }


        return pub;
    }


}
