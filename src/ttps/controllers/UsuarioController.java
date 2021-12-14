package ttps.controllers;

import org.springframework.web.bind.annotation.*;
import ttps.spring.model.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ttps.clasesDAO.UsuarioDAO;

@RestController
@RequestMapping(value = "/usuario", produces = "application/json")
public class UsuarioController {

	@Autowired
	private UsuarioDAO usuarioDAO;

	// Recupero todos los usuarios
	@GetMapping("/all")
	public ResponseEntity<List<Usuario>> listAllUsers() {
		List<Usuario> users = usuarioDAO.recuperarTodos("user");
		if (users.isEmpty()) {
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
	@PostMapping
	public ResponseEntity<Void> createUser(@RequestBody Usuario user) {
		/*System.out.println("Creando el usuario " + user.getUser());
		if (usuarioDAO.isExist(user.getUser())) {
			System.out.println("Ya existe el usuario " + user.getUser());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT); // Código de respuesta 409
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