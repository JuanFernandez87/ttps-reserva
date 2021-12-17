 package ttps.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="SERVICIOS")
public class Servicio {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SERVICIO_ID")	    
	private Integer id;
	private String nombre;
    private String tipo_servicio;
    private String descripcion;
    private String url;
    private String  id_usuario;
    //private List<String> galeria;
    
    @ManyToOne
	Usuario usuario;
    
    public String getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}

	public List<Valoracion> getValoraciones() {
		return valoraciones;
	}

	public void setValoraciones(List<Valoracion> valoraciones) {
		this.valoraciones = valoraciones;
	}

	public RedesSociales getRedes_sociales() {
		return redes_sociales;
	}

	public void setRedes_sociales(RedesSociales redes_sociales) {
		this.redes_sociales = redes_sociales;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	@OneToMany (mappedBy = "servicio")
    private List <Valoracion> valoraciones = new ArrayList<Valoracion>();
    
	@OneToOne
	private RedesSociales redes_sociales;
    //@OneToOne
	//private Valoracion valoracion;
	
	@ManyToOne
	private Usuario user;
        
    public Servicio() {
	}

	public Servicio(String nombre, String tipo_servicio, String descripcion, String url) {
		super();
		this.nombre = nombre;
		this.tipo_servicio = tipo_servicio;
		this.descripcion = descripcion;
		this.url = url;
		//this.galeria = new ArrayList<String>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo_servicio() {
		return tipo_servicio;
	}

	public void setTipo_servicio(String tipo_servicio) {
		this.tipo_servicio = tipo_servicio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/*public List<String> getGaleria() {
		return galeria;
	}

	public void addGaleria(String galeria) {
		this.galeria.add(galeria);
	}*/
    
}