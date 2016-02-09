package business;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import persistence.util.Jpa;

public class CommandExecutor {

	public Object execute(Command command) {
		// Creo el entityManager usando la factoria
		EntityManager em = Jpa.createEntityManager();

		// Tengo que abrir una transaccion
		EntityTransaction trx = em.getTransaction();
		// La abro
		try {
			trx.begin();
		} catch (PersistenceException pex) {
			throw new RuntimeException("Ha ocurrido un error con la base " 
		+ "de datos.");
		}

		Object res = null;
		try {
			res = command.execute();

			// Guardo cambios
			trx.commit();
		} catch (RuntimeException rex) {
			if (trx.isActive()) {
				trx.rollback();
			}
			throw rex;
		} finally {
			// Cierro
			if (em.isOpen()) {
				em.close();
			}
		}
		return res;
	}

}
