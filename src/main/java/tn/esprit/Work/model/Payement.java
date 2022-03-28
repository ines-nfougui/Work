package tn.esprit.Work.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name="payements")
public class Payement {
	
	@Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id;
	private Date createDate;
	private Double amount;
	@ManyToOne
	private Collaborateur user ;
	@ManyToOne
	private Publicite publicite ;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status ;
	
	@Enumerated(EnumType.STRING)
	private PayementType payementType;
	
	private String referenceExterne;
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Collaborateur getUser() {
		return user;
	}
	public void setUser(Collaborateur user) {
		this.user = user;
	}

	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReferenceExterne() {
		return referenceExterne;
	}
	public void setReferenceExterne(String referenceExterne) {
		this.referenceExterne = referenceExterne;
	}

	public Publicite getPublicite() {
		return publicite;
	}

	public void setPublicite(Publicite publicite) {
		this.publicite = publicite;
	}

	public PayementType getPayementType() {
		return payementType;
	}

	public void setPayementType(PayementType payementType) {
		this.payementType = payementType;
	}
}
