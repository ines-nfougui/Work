package tn.esprit.Work.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Publication {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idpub;

    private Date dateC ;
    
    private Double note;

    @Enumerated
    private Type type ;
    @NotBlank
    private String description ;

    @OneToOne(mappedBy = "publication")
    private UploadImagePublication image ;

    @ManyToOne
    @JoinColumn(name="idUser",referencedColumnName = "iduser")
    private User iduser;

    public Long getIdpub() {
        return idpub;
    }

    public void setIdpub(Long idpub) {
        this.idpub = idpub;
    }

    public Date getDateC() {
        return dateC;
    }

    public void setDateC(Date dateC) {
        this.dateC = dateC;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
    }

    public UploadImagePublication getImage() {
        return image;
    }

    public void setImage(UploadImagePublication image) {
        this.image = image;
    }

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Double getNote() {
		return note;
	}

	public void setNote(Double note) {
		this.note = note;
	}
	
	
    
    
}
