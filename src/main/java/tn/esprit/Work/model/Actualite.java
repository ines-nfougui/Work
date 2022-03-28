package tn.esprit.Work.model;


import javax.persistence.*;

@Entity
public class Actualite {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idActualite ;

    @ManyToOne
    @JoinColumn(name="idevent",referencedColumnName = "idE")
    private Evenements idevent;

    @ManyToOne
    @JoinColumn(name="idq",referencedColumnName = "idQ")
    private Quiz idquiz;
    
    @ManyToOne
    @JoinColumn(name="idpublication",referencedColumnName = "idpub")
    private Publication idpublicqtion;
    
    
    @ManyToOne
    @JoinColumn(name="idoffer",referencedColumnName = "idOffer")
    private Offer idoffer;



    public Long getIdActualite() {
        return idActualite;
    }

    public void setIdActualite(Long idActualite) {
        this.idActualite = idActualite;
    }

    public Evenements getIdevent() {
        return idevent;
    }

    public void setIdevent(Evenements idevent) {
        this.idevent = idevent;
    }

    public Quiz getIdquiz() {
        return idquiz;
    }

    public void setIdquiz(Quiz idquiz) {
        this.idquiz = idquiz;
    }

	public Publication getIdpublicqtion() {
		return idpublicqtion;
	}

	public void setIdpublicqtion(Publication idpublicqtion) {
		this.idpublicqtion = idpublicqtion;
	}

	public Offer getIdoffer() {
		return idoffer;
	}

	public void setIdoffer(Offer idoffer) {
		this.idoffer = idoffer;
	}
    
    
}
