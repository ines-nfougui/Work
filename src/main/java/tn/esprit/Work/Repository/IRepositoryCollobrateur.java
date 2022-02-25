package tn.esprit.Work.Repository;


import org.springframework.data.repository.CrudRepository;
import tn.esprit.Work.model.Collaborateur;

@org.springframework.stereotype.Repository
public interface IRepositoryCollobrateur extends CrudRepository<Collaborateur,Long> {
}
