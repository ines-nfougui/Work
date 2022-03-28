package tn.esprit.Work.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Publicite {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idp;

    @NotBlank
    private String titre ;

    @NotBlank
    private String slogan ;

    private Type theme ;
    
    @NotBlank
    private double montant ;
    
    
    
    
    

    public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	@ManyToOne
    @JoinColumn(name="idColl",referencedColumnName = "idC")
    private Collaborateur idColl;

    @OneToOne(mappedBy = "pub")
    private UploadImagePublicite image ;

    public Long getIdp() {
        return idp;
    }

    public void setIdp(Long idp) {
        this.idp = idp;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public Collaborateur getIdColl() {
        return idColl;
    }

    public void setIdColl(Collaborateur idColl) {
        this.idColl = idColl;
    }

    public UploadImagePublicite getImage() {
        return image;
    }

    public void setImage(UploadImagePublicite image) {
        this.image = image;
    }


    public Type getTheme() {
        return theme;
    }

    public void setTheme(Type theme) {
        this.theme = theme;
    }
}
