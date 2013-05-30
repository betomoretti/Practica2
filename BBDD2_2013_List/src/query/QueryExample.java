package query;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import modelo.Conductor;
import modelo.Empleado;
import modelo.Mudanza;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class QueryExample {
	
	private static SessionFactory sessions;
	
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		sessions = cfg.buildSessionFactory();
		Session session = sessions.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			long start = System.nanoTime(); //Inicio del timer para medir la duraccion de la consulta
			
			ejecutarConsultaA(session);
			
			long elapsedTime = System.nanoTime() - start;   //Calculo de la duraccion en nanosegundos
			
			System.out.println("Tiempo transcurrido: " + elapsedTime + " nanosegundos");

			session.flush();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
			session.close();
		}
		session.disconnect() ;
	}
	
	private static void ejecutarConsultaA(Session session) {
		System.out.println("Obtener las mudanzas realizadas antes del 1/1/2010");
		System.out.println();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Query query = session.createQuery("select m from modelo.Mudanza m where m.fecha < :fecha");
		try {
			query.setParameter("fecha", sdf.parse("01/01/2010"));
			List<Mudanza> mudanzas = query.list();
			for (Mudanza m: mudanzas) {
				System.out.println(m);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
