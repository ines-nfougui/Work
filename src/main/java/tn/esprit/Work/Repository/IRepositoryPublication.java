package tn.esprit.Work.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Work.model.Publication;

@Repository
public interface IRepositoryPublication extends CrudRepository<Publication,Long> {
}
