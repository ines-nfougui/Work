package tn.esprit.Work.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Work.model.Offer;

@Repository
public interface IRepositoryOffer extends CrudRepository<Offer,Long> {
}
