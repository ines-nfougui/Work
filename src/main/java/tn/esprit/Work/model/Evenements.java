package tn.esprit.Work.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="evenement")
public class Evenements {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idE;

    private String titre ;
    private String description ;
    private Date dateStart ;
    private Date dateEnd ;

    public Long getIdE() {
        return idE;
    }

    public void setIdE(Long idE) {
        this.idE = idE;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }
}
