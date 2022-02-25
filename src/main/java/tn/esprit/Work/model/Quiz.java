package tn.esprit.Work.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="quiz")
public class Quiz  implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idQ;

    public Quiz() {
    }

    public Long getIdQ() {
        return idQ;
    }

    public void setIdQ(Long idQ) {
        this.idQ = idQ;
    }


}
