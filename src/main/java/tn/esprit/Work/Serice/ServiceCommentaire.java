package tn.esprit.Work.Serice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Work.IService.IServiceCommentaire;
import tn.esprit.Work.IService.IServicePublication;
import tn.esprit.Work.IService.IUserSerive;
import tn.esprit.Work.Repository.IRepositoryCommentaire;
import tn.esprit.Work.model.Commentaire;
import tn.esprit.Work.model.Publication;
import tn.esprit.Work.model.User;

import java.util.List;

@Service
public class ServiceCommentaire implements IServiceCommentaire {

    @Autowired
    IRepositoryCommentaire repositoryCommentaire ;

    @Autowired
    IServicePublication servicePublication ;
    @Autowired
    IUserSerive serviceuser ;


    @Override
    public Commentaire addComment(Commentaire c) {
        return repositoryCommentaire.save(c);
    }

    @Override
    public String DeleteComment(Long corrId) {
        repositoryCommentaire.delete(repositoryCommentaire.findById(corrId).get());
        return"Deleted";
    }

    @Override
    public Commentaire updateComment(Commentaire c) {
        return repositoryCommentaire.save(c);
    }

    @Override
    public List<Commentaire> retrieveAllCommentByIdPub(long idUser , long IdPub) {

        User u = serviceuser.findUserById(idUser);
        Publication p = servicePublication.findPublicationById(IdPub);
        List<Commentaire> cmts=(List<Commentaire>)repositoryCommentaire.findCommentaireByIdpubAndIduser(p,u);
        return cmts;
    }

    @Override
    public Commentaire findCommentById(Long id) {
        return repositoryCommentaire.findById(id).get();
    }

}
