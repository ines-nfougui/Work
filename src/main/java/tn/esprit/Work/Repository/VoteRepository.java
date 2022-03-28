package tn.esprit.Work.Repository;


import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.Work.model.Publication;
import tn.esprit.Work.model.User;

@Repository
public interface VoteRepository extends CrudRepository<tn.esprit.Work.model.Vote, Integer>{

    @Query("SELECT v FROM Vote v WHERE v.publication= :publication AND v.user= :user")
    tn.esprit.Work.model.Vote SearchLike(@Param("publication") Publication publication, @Param("user") User user);

    @Query("SELECT sum(note)as val1 ,count(*) as val2 FROM Vote v WHERE v.publication= :publication")
    Map<String,Long>  getPubicationtNote (@Param("publication") Publication publication);
    


}
