package ttps.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="VALORACIONES")
public class Valoracion {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="VALORACION_ID")	
	private Integer id;
	private Integer limpieza;
    private Integer simpatia;
    private Integer calidad_precio;
    private Integer sabor;
    private Integer disenio;
    
    @OneToOne
	private Reserva reserva;
    
    @ManyToOne 
    @JoinColumn
    private Servicio servicio;
    
    public Valoracion() {
	}

	public Valoracion(Integer limpieza, Integer simpatia, Integer calidad_precio, Integer sabor, Integer disenio) {
		super();
		this.limpieza = limpieza;
		this.simpatia = simpatia;
		this.calidad_precio = calidad_precio;
		this.sabor = sabor;
		this.disenio = disenio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLimpieza() {
        return limpieza;
    }

    public void setLimpieza(Integer limpieza) {
        this.limpieza = limpieza;
    }

    public Integer getSimpatia() {
        return simpatia;
    }

    public void setSimpatia(Integer simpatia) {
        this.simpatia = simpatia;
    }

    public Integer getCalidad_precio() {
        return calidad_precio;
    }

    public void setCalidad_precio(Integer calidad_precio) {
        this.calidad_precio = calidad_precio;
    }

    public Integer getSabor() {
        return sabor;
    }

    public void setSabor(Integer sabor) {
        this.sabor = sabor;
    }

    public Integer getDisenio() {
        return disenio;
    }

    public void setDisenio(Integer disenio) {
        this.disenio = disenio;
    }  
}
