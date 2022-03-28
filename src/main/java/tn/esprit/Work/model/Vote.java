package tn.esprit.Work.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vote {

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int note;

    @ManyToOne
    private Publication publication;

    @ManyToOne
    private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	



	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public Vote() {
		super();
	}

	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}


    
    
    

}
