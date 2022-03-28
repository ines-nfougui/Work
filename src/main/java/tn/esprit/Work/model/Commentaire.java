package tn.esprit.Work.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Commentaire {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idComm;

    @NotBlank
    private String comment ;

    @ManyToOne
    @JoinColumn(name="idUser",referencedColumnName = "iduser")
    private User iduser;

    @ManyToOne
    @JoinColumn(name="idPub",referencedColumnName = "idpub")
    private Publication idpub;


    public Long getIdComm() {
        return idComm;
    }

    public void setIdComm(Long idComm) {
        this.idComm = idComm;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
    }

    public Publication getIdpub() {
        return idpub;
    }

    public void setIdpub(Publication idpub) {
        this.idpub = idpub;
    }
}
