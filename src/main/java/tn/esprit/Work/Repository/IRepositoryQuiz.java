package tn.esprit.Work.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Work.model.Quiz;

@Repository
public interface IRepositoryQuiz extends CrudRepository<Quiz,Long> {
}
