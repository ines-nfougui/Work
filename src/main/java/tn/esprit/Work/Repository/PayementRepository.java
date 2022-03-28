package tn.esprit.Work.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Work.model.Payement;

@Repository
public interface PayementRepository extends CrudRepository<Payement, Long> {

}
