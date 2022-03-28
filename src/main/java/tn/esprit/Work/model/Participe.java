package tn.esprit.Work.model;

import javax.persistence.*;

@Entity
public class Participe {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idp;

    @ManyToOne
    @JoinColumn(name="idUser",referencedColumnName = "iduser")
    User user;

    @ManyToOne
    @JoinColumn(name="idEvenement",referencedColumnName = "idE")
    Evenements evenements;

    public Long getIdp() {
        return idp;
    }

    public void setIdp(Long idp) {
        this.idp = idp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Evenements getEvenements() {
        return evenements;
    }

    public void setEvenements(Evenements evenements) {
        this.evenements = evenements;
    }
}
