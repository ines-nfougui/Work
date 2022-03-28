package tn.esprit.Work.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Work.model.User;

@Repository
public interface IRepositoryUser extends CrudRepository<User,Long> {
}
