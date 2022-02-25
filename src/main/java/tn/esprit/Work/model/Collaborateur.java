package tn.esprit.Work.model;

import javax.persistence.*;

@Entity
@Table(name="collobrateur")
public class Collaborateur {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idC;

    private String titre ;
    private String description ;


    public Long getIdC() {
        return idC;
    }

    public void setIdC(Long idC) {
        this.idC = idC;
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
}
