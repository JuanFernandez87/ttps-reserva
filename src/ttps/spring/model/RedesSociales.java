package ttps.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="REDES_SOCIALES")
public class RedesSociales {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="REDES_SOCIALES_ID")	
	private Integer id;
	private Integer whatsapp;
	private String instagram;
	private String twitter;

	@OneToOne
	private Servicio servicios;
	
	public RedesSociales() {
	}

	public RedesSociales(Integer id, Integer whatsapp, String instagram, String twitter) {
		this.id = id;
		this.whatsapp = whatsapp;
		this.instagram = instagram;
		this.twitter = twitter;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(Integer whatsapp) {
		this.whatsapp = whatsapp;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	
		
}