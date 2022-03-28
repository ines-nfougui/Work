package tn.esprit.Work.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

@Entity
public class Contrat {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idC;

    @ManyToOne
    @JoinColumn(name="idColla",referencedColumnName = "idC")
    private Collaborateur idColl;
    
    
	private String name;
	@Lob
	private byte[] data;

	private float montant ;

	private Date dateSegniateur ;


    public Long getIdC() {
        return idC;
    }

    public void setIdC(Long idC) {
        this.idC = idC;
    }

    public Collaborateur getIdColl() {
        return idColl;
    }

    public void setIdColl(Collaborateur idColl) {
        this.idColl = idColl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public Date getDateSegniateur() {
        return dateSegniateur;
    }

    public void setDateSegniateur(Date dateSegniateur) {
        this.dateSegniateur = dateSegniateur;
    }
}
