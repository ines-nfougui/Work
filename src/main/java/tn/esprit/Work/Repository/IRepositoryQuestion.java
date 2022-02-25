package tn.esprit.Work.Repository;


import org.springframework.data.repository.CrudRepository;
import tn.esprit.Work.model.Question;

@org.springframework.stereotype.Repository
public interface IRepositoryQuestion extends CrudRepository<Question,Long> {
}
