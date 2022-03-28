package tn.esprit.Work.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Base64;

@Entity
@Table (name="uploadImagePublication")
public class UploadImagePublication {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	private String name;
	@JsonIgnore
	@Lob
	private byte[] data;
	
	@JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publication_id", referencedColumnName = "idpub")
    private Publication publication;
    
	
	@Transient
	private String dataValue;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getDataValue() {
		return Base64.getEncoder().encodeToString(this.data);
	}
	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}


	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}
}
