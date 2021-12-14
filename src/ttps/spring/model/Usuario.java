package ttps.spring.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="USUARIOS")
public class Usuario {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="USUARIO_ID")	     
	private Integer id;
	private String user;
	private String nombre;
	private String apellido;
	private String pass;
	private Integer dni;
	private String mail;
	private Date fechaNac;
	
	@JsonIgnore
	@OneToMany
	private List<Evento> eventos = new LinkedList<Evento>();
	
	@JsonIgnore
	@OneToMany
	private List<Servicio> servicios = new LinkedList<Servicio>();
	
	public Usuario() {
	}

	public Usuario(String user, String nombre, String apellido, String pass, Integer dni, String mail, Date fechaNac) {
		this.user = user;
		this.nombre = nombre;
		this.apellido = apellido;
		this.pass = pass;
		this.dni = dni;
		this.mail = mail;
		this.fechaNac = fechaNac;
		this.eventos = new ArrayList<Evento>();
		this.servicios = new ArrayList<Servicio>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	
	public List<Evento> getEventos() {
		return this.eventos;
	}

	public void addEvento(Evento evento) {
		this.eventos.add(evento);
	}
	
	public List<Servicio> getServicios() {
		return this.servicios;
	}

	public void addServicio(Servicio servicio) {
		this.servicios.add(servicio);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.apellido + this.mail + this.nombre + this.fechaNac;
	}
	
	
	
}