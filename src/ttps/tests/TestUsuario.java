package ttps.tests;

import java.sql.Time;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Date;

import ttps.clasesDAO.EventoDAO;
import ttps.clasesDAO.UsuarioDAO;
import ttps.spring.config.PersistenceConfig;
import ttps.spring.model.Evento;
import ttps.spring.model.Usuario;

public class TestUsuario {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		
		ctx.register(PersistenceConfig.class);
		ctx.scan("ttps");
		ctx.refresh();
		
		UsuarioDAO usrDAO = ctx.getBean("usuarioDAOHibernateJPA", UsuarioDAO.class);
		EventoDAO eventDAO = ctx.getBean("eventoDAOHibernateJPA", EventoDAO.class);
		
		Date date1 = new Date(1987, 10, 19);		
		Date date2 = new Date(2021, 10, 31);		
		Time hora = new Time(15, 15, 0);		

		Usuario user1 = new Usuario("m_ariano", "mariano", "perez", "1234", 33125125, "juan@mail.com", date1);
		Usuario user2 = new Usuario("juan_ce", "juan", "fernandez", "1234", 232323, "asdasdn@mail.com", date1);
		
		Evento event1 = new Evento("casamiento 1", "84 2685", 1900, "bs as", "12346", "123456", "casorio", date2, hora);
		Evento event2 = new Evento("casamiento 2", "84 2685", 1900, "bs as", "12346", "123456", "casorio", date2, hora);
		
		user1.addEvento(event1);
		user2.addEvento(event2);
		
		eventDAO.persistir(event1);
		eventDAO.persistir(event2);
		
		usrDAO.persistir(user1);
		usrDAO.persistir(user2);
		
		user1.setApellido("gomez");
		usrDAO.actualizar(user1);

		System.out.println("Finalizo correctamente");
		ctx.close();

	}

}
