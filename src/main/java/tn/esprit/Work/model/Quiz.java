package tn.esprit.Work.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="quiz")
public class Quiz  implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idQ;

    private Date dateC ;

    private Date dateS ;
    @ManyToOne
    @JoinColumn(name="idQuestion",referencedColumnName = "idQ")
    private Question quizQuestion;

    public Quiz() {
    }

    public Long getIdQ() {
        return idQ;
    }

    public void setIdQ(Long idQ) {
        this.idQ = idQ;
    }

    public Date getDateC() {
        return dateC;
    }

    public void setDateC(Date dateC) {
        this.dateC = dateC;
    }

    public Date getDateS() {
        return dateS;
    }

    public void setDateS(Date dateS) {
        this.dateS = dateS;
    }

    public Question getQuizQuestion() {
        return quizQuestion;
    }

    public void setQuizQuestion(Question quizQuestion) {
        this.quizQuestion = quizQuestion;
    }
}
