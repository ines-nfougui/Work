package tn.esprit.Work.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Work.model.Evenements;
import tn.esprit.Work.model.Participe;
import tn.esprit.Work.model.User;

import java.util.List;

@Repository
public interface IRepositoryParticipe extends CrudRepository<Participe,Long> {

    List<Participe> findParticipeByEvenements(Evenements evenements);
    List<Participe> findParticipeByUser(User user);
}
