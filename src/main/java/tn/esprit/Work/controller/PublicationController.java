package tn.esprit.Work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.Work.IService.IServicePublication;
import tn.esprit.Work.IService.IUserSerive;
import tn.esprit.Work.Serice.MapValidationErrorService;
import tn.esprit.Work.Validator.PublicationValidator;
import tn.esprit.Work.model.Publication;
import tn.esprit.Work.model.UploadImagePublication;

import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/publication")
public class PublicationController {



    @Autowired
    IServicePublication servicePublication;
    @Autowired
    MapValidationErrorService mapValidationErrorService ;

    @Autowired
    PublicationValidator publicationValidator ;

    @Autowired
    IUserSerive userSerive ;

    @GetMapping("/retrieve-all-publication")
    @ResponseBody
    public List<Publication> getAllPublication() {
        return servicePublication.retrieveAllPublication();
    }

    @PostMapping("/add-pub/{iduser}")
    @ResponseBody
    public ResponseEntity<?> addpub(@Valid @RequestBody Publication c , BindingResult result,@PathVariable("iduser") long idUser) {
        publicationValidator.validate(c,result);
        ResponseEntity<?> erroMap =mapValidationErrorService.MapValidationService(result);
        if(erroMap != null)return erroMap;
        c.setIduser(userSerive.findUserById(idUser));
        Publication o = servicePublication.addPublication(c);

        return new ResponseEntity<Publication>( o, HttpStatus.CREATED);
    }


    @DeleteMapping("/remove-publication/{publicationId}")
    @ResponseBody
    public String removepub(@PathVariable("publicationId")  long publicationId) {
        return   servicePublication.DeletePublication(publicationId);

    }

    @PutMapping("/modify-pub")
    @ResponseBody
    public Publication modifyPub(@RequestBody Publication c) {
        return servicePublication.updatePublication(c);
    }


    @GetMapping("/retrieve-pub/{pubId}")
    @ResponseBody
    public Publication retrievepub(@PathVariable("pubId") long pubId) {
        return servicePublication.findPublicationById(pubId);  }

    @PostMapping("/file")
    @ResponseBody
    @Transactional
    public Object  uploadImg (@RequestParam("file") @Nullable MultipartFile file, @RequestParam("identifier") Long id) {
        Publication pub =servicePublication.findPublicationById(id);
        if(pub==null)
        {
            Map<String, String> errorDetails= new HashMap<>();
            errorDetails.put("message", "publication non definit");
            return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
        }
        if(file!=null) {
            UploadImagePublication image =pub.getImage();

            if(image==null)
            {
                image= new UploadImagePublication();
                image.setPublication(pub);
                pub.setImage(image);
            }

            try {
                image.setData(file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            image.setName(file.getOriginalFilename());

            servicePublication.saveImage(image);

            servicePublication.updatePublication(pub);
        }


        return pub;
    }



}
