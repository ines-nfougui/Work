package tn.esprit.Work.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Base64;

@Entity
@Table (name="uploadImagePublication")
public class UploadImagePublicite {
	
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
    @JoinColumn(name = "pub_id", referencedColumnName = "idp")
    private Publicite pub;

	
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

	public Publicite getPub() {
		return pub;
	}

	public void setPub(Publicite pub) {
		this.pub = pub;
	}
}
