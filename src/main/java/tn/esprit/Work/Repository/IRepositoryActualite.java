package tn.esprit.Work.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Work.model.Actualite;

@Repository
public interface IRepositoryActualite extends CrudRepository<Actualite,Long> {
}
