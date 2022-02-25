package tn.esprit.Work.Repository;


import org.springframework.data.repository.CrudRepository;
import tn.esprit.Work.model.Evenements;
import tn.esprit.Work.model.Question;

@org.springframework.stereotype.Repository
public interface IRepositoryEvenement extends CrudRepository<Evenements,Long> {
}
