package ttps.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="RESERVAS")
public class Reserva {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RESERVA_ID")	    
	private Integer id;
	private boolean forma_de_pago;
    //El estado en que se encuentra la reserva: valorado, cancelado, valorar y pendiente
    private String estado;

	@OneToOne
	private Servicio servicio;
	
	@OneToOne
	private Valoracion valoracion;  
	
	@ManyToOne
	private Evento evento;	

    public Reserva() {
	}
    
	public Reserva(boolean forma_de_pago, String estado) {
		this.forma_de_pago = forma_de_pago;
		this.estado = estado;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isForma_de_pago() {
        return forma_de_pago;
    }

    public void setForma_de_pago(boolean forma_de_pago) {
        this.forma_de_pago = forma_de_pago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Valoracion getValoracion() {
		return valoracion;
	}

	public void setValoracion(Valoracion valoracion) {
		this.valoracion = valoracion;
	}

    
}