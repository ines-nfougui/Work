package tn.esprit.Work.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name="question")
public class Question  implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idQ;

    @NotBlank(message = "Question is require")
    private String question ;
    private String option1 ;
    private String option2;
    private String option3;
    private  String croorectRep ;

    public Question() {
    }

    public Long getIdQ() {
        return idQ;
    }

    public void setIdQ(Long idQ) {
        this.idQ = idQ;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getCroorectRep() {
        return croorectRep;
    }

    public void setCroorectRep(String croorectRep) {
        this.croorectRep = croorectRep;
    }

    @Override
    public String toString() {
        return "Question{" +
                "idQ=" + idQ +
                ", question='" + question + '\'' +
                ", option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                ", croorectRep='" + croorectRep + '\'' +
                '}';
    }
}
