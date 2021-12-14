package ttps.spring.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="EVENTOS")
public class Evento {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="EVENTO_ID")
	private Integer id;
	private String nombre;
	private String direccion;
	private Integer cp;
	private String provincia;
	private String latitud;
	private String longitud;
	private String tipo_evento;
	private Date fecha;
	private Time hora;
	
	@OneToMany
	private List<Reserva> reservas;
	
	@ManyToOne
	private Usuario user;
	
	public Evento() {
	}

	public Evento(String nombre, String direccion, Integer cp, String provincia, String latitud, String longitud, String tipo_evento, Date fecha, Time hora) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.cp = cp;
		this.provincia = provincia;
		this.latitud = latitud;
		this.longitud = longitud;
		this.tipo_evento = tipo_evento;
		this.fecha = fecha;
		this.hora = hora;
		this.reservas = new ArrayList<Reserva>();
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getCp() {
		return cp;
	}

	public void setCp(Integer cp) {
		this.cp = cp;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getTipo_evento() {
		return tipo_evento;
	}

	public void setTipo_evento(String tipo_evento) {
		this.tipo_evento = tipo_evento;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void addReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}
	
	
}