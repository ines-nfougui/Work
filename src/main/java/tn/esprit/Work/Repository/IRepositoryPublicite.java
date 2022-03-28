package tn.esprit.Work.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.Work.model.Collaborateur;
import tn.esprit.Work.model.Publicite;

import java.util.List;

public interface IRepositoryPublicite extends CrudRepository<Publicite,Long> {

    List<Publicite> findPubliciteByIdColl(Collaborateur idColl);
}
