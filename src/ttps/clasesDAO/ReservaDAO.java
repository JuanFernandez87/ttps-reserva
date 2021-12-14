package ttps.clasesDAO;
import ttps.spring.model.Reserva;

public interface ReservaDAO extends GenericDAO<Reserva>{
	public Reserva recuperarReserva(String reserva);
}
