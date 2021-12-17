package ttps.controllers;

import org.springframework.web.bind.annotation.*;

import ttps.spring.model.Usuario;
import ttps.spring.model.usuarioNuevo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import ttps.clasesDAO.UsuarioDAO;

@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RestController
@RequestMapping(value = "/usuario", produces = "application/json")
public class UsuarioController {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	private final static Logger logger = LoggerFactory.getLogger(UsuarioController.class);

	// Recupero todos los usuarios
	@GetMapping("/all")
	public ResponseEntity<List<Usuario>> listAllUsers() {
		List<Usuario> users = usuarioDAO.recuperarTodos("user");
		if (users.isEmpty()) {
			logger.error("se devolvera la lista");
			return new ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Usuario>>(users, HttpStatus.OK);
	}

	// Recupero un usuario por id
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUser(@PathVariable("id") Integer id) {
		System.out.println("Obteniendo usuario con id " + id);
		Usuario user = usuarioDAO.recuperar(id);
		if (user == null) {
			System.out.println("Usuario con id " + id + " no encontrado");
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Usuario>(user, HttpStatus.OK);
	}

	// Crear usuario
	/*@PostMapping
	public ResponseEntity<Void> createUser(@RequestBody Usuario nuevoUsuario, BindingResult bindingResult) {
		System.out.println("Creando el usuario " + nuevoUsuario.getUser());
		System.out.println("Creando el usuario " + nuevoUsuario.getUser());
		
		if (usuarioDAO.isExist(nuevoUsuario.getUser())) {
			System.out.println("Ya existe el usuario " + nuevoUsuario.getUser());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT); // C�digo de respuesta 409
		}
		usuarioDAO.persistir(nuevoUsuario);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}*/
	@PostMapping
	public ResponseEntity<Void> createUser(@RequestBody Usuario user) {
		/*System.out.println("Creando el usuario " + user.getUser());
		if (usuarioDAO.isExist(user.getUser())) {
			System.out.println("Ya existe el usuario " + user.getUser());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT); // C�digo de respuesta 409
		}*/
		usuarioDAO.persistir(user);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	// Actualizar usuario
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> updateUser(@PathVariable("id") Integer id, @RequestBody Usuario user) {
		System.out.println("Actualizando el usuario " + id);

		Usuario currentUser = usuarioDAO.recuperar(id);

		if (currentUser == null) {
			System.out.println("User with id " + id + " not found");
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
		currentUser.setUser(user.getUser());
		currentUser.setNombre(user.getNombre());
		currentUser.setApellido(user.getApellido());
		currentUser.setPass(user.getPass());
		currentUser.setDni(user.getDni());
		currentUser.setMail(user.getMail());
		currentUser.setFechaNac(user.getFechaNac());

		usuarioDAO.actualizar(currentUser);
		return new ResponseEntity<Usuario>(currentUser, HttpStatus.OK);
	}

	// Eliminar usuario
	@DeleteMapping("/{id}")
	public ResponseEntity<Usuario> deleteUser(@PathVariable("id") Integer id) {
		System.out.println("Obteniendo y eliminando el usuario con id " + id);
		Usuario user = usuarioDAO.recuperar(id);
		if (user == null) {
			System.out.println("No es posible eliminar, no se encuentra el usuario con id " + id);
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
		usuarioDAO.borrar(id);
		return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
	}
}