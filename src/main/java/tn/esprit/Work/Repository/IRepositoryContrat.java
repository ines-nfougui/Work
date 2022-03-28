package tn.esprit.Work.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.Work.model.Contrat;
import tn.esprit.Work.model.Publication;

import java.util.Map;

@Repository
public interface IRepositoryContrat extends CrudRepository<Contrat,Long> {

    @Query("SELECT sum(montant)as val1 FROM Contrat")
    float getSommeMontant ();
}
