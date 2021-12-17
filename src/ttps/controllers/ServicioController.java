package ttps.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ttps.clasesDAO.ServicioDAO;
import ttps.clasesDAO.UsuarioDAO;
import ttps.spring.model.Servicio;
import ttps.spring.model.Usuario;


@RestController
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RequestMapping(value = "/servicios", produces = "application/json")
public class ServicioController {

	@Autowired
	private ServicioDAO servicioDAO;
	
	@Autowired
	private UsuarioDAO usuarioDAO;

	// Recupero todos los servicios
	@CrossOrigin
	@GetMapping("/all")
	public ResponseEntity<List<Servicio>> listAllServices() {
		List<Servicio> servicios = servicioDAO.recuperarTodos("tipo_servicio");
		if (servicios.isEmpty()) {
			return new ResponseEntity<List<Servicio>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Servicio>>(servicios, HttpStatus.OK);
	}

	// Recupero un servicio por id
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<Servicio> getServicio(@PathVariable("id") Integer id) {
		System.out.println("Obteniendo servicio con id " + id);
		Servicio servicio = servicioDAO.recuperar(id);
		if (servicio == null) {
			System.out.println("Servicio con id " + id + " no encontrado");
			return new ResponseEntity<Servicio>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Servicio>(servicio, HttpStatus.OK);
	}
	
	// Crear servicio
	@PostMapping("/nuevo")
	public ResponseEntity<Void> createServicio(@RequestBody Servicio servicio) {
		servicioDAO.persistir(servicio);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	// Actualizar servicio
	@PutMapping("/{id}")
	public ResponseEntity<Servicio> updateUser(@PathVariable("id") Integer id, @RequestBody Servicio servicio) {
		System.out.println("Actualizando el usuario " + id);

		Servicio currentServicio = servicioDAO.recuperar(id);

		if (currentServicio == null) {
			System.out.println("Servicio con id " + id + " not found");
			return new ResponseEntity<Servicio>(HttpStatus.NOT_FOUND);
		}
		currentServicio.setNombre(servicio.getNombre());
		currentServicio.setTipo_servicio(servicio.getTipo_servicio());
		currentServicio.setDescripcion(servicio.getDescripcion());
		currentServicio.setUrl(servicio.getUrl());
		
		servicioDAO.actualizar(currentServicio);
		return new ResponseEntity<Servicio>(currentServicio, HttpStatus.OK);
	}

	// Eliminar servicio
	@DeleteMapping("/{id}")
	public ResponseEntity<Servicio> deleteServicio(@PathVariable("id") Integer id) {
		System.out.println("Obteniendo y eliminando el servicio con id " + id);
		Servicio servicio = servicioDAO.recuperar(id);
		if (servicio == null) {
			System.out.println("No es posible eliminar, no se encuentra el servicio con id " + id);
			return new ResponseEntity<Servicio>(HttpStatus.NOT_FOUND);
		}
		servicioDAO.borrar(id);
		return new ResponseEntity<Servicio>(HttpStatus.NO_CONTENT);
	}	
}
