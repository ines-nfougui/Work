package tn.esprit.Work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Work.IService.IServiceCommentaire;
import tn.esprit.Work.IService.IServicePublication;
import tn.esprit.Work.IService.IUserSerive;
import tn.esprit.Work.Serice.MapValidationErrorService;
import tn.esprit.Work.Validator.CommentaireValidator;
import tn.esprit.Work.model.Commentaire;

import javax.validation.Valid;
import java.util.List;

@RestController

public class CommentaireController {


    @Autowired
    IServiceCommentaire serviceCommentaire ;

    @Autowired
    MapValidationErrorService mapValidationErrorService ;

    @Autowired
    CommentaireValidator commentValidator ;
    @Autowired
    IUserSerive serviceUserSerive;
    @Autowired
    IServicePublication servicePublication ;

    @GetMapping("/retrieve-all-comment/{pub-id}/{user-id}")
    @ResponseBody
    public List<Commentaire> getAllCommentaires(@PathVariable("pub-id")  long pub , @PathVariable("user-id")  long user) {
        return serviceCommentaire.retrieveAllCommentByIdPub(pub,user);
    }

    @PostMapping("/add-comment/{user-id}/{pub-id}")
    @ResponseBody
    public ResponseEntity<?> addComment(@Valid @RequestBody Commentaire c , BindingResult result , @PathVariable("pub-id")  long pub , @PathVariable("user-id")  long user) {
        commentValidator.validate(c,result);
        ResponseEntity<?> erroMap =mapValidationErrorService.MapValidationService(result);
        if(erroMap != null)return erroMap;
        c.setIdpub(servicePublication.findPublicationById(pub));
        c.setIduser(serviceUserSerive.findUserById(user));
        Commentaire comm = serviceCommentaire.addComment(c);
        return new ResponseEntity<Commentaire>( comm, HttpStatus.CREATED);
    }

    @DeleteMapping("/remove-comment/{comment-id}")
    @ResponseBody
    public void removecomment(@PathVariable("comment-id")  long commentid) {
        serviceCommentaire.DeleteComment(commentid);

    }

    @PutMapping("/modify-comment")
    @ResponseBody
    public Commentaire modifycomment(@RequestBody Commentaire c) {
        return serviceCommentaire.updateComment(c);
    }


    @GetMapping("/retrieve-comment/{commentId}")
    @ResponseBody
    public Commentaire retrievecomment(@PathVariable("commentId") long commentId) {
        return serviceCommentaire.findCommentById(commentId);  }











}
