package tn.esprit.Work.IService;

import tn.esprit.Work.model.Collaborateur;
import tn.esprit.Work.model.Commentaire;

import java.util.List;

public interface IServiceCommentaire {


    Commentaire addComment(Commentaire c);

    String DeleteComment(Long corrId);

    Commentaire updateComment(Commentaire c);

    List<Commentaire> retrieveAllCommentByIdPub(long idUser , long IdPub);


    Commentaire findCommentById(Long id);

}
