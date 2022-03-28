package tn.esprit.Work.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Work.model.Commentaire;
import tn.esprit.Work.model.Publication;
import tn.esprit.Work.model.User;

import java.util.List;

@Repository
public interface IRepositoryCommentaire extends CrudRepository<Commentaire,Long> {

       List<Commentaire> findCommentaireByIdpubAndIduser(Publication idpub,User iduser );

}
