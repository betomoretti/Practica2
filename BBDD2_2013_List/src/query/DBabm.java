package query;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import modelo.Ayudante;
import modelo.Camion;
import modelo.Conductor;
import modelo.Empleado;
import modelo.EmpresaDeMudanzas;
import modelo.Mudanza;
import modelo.RolEmpleado;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DBabm {

	private static SessionFactory sessions;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		sessions = cfg.buildSessionFactory();
		Session session = sessions.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			long start = System.nanoTime(); //Inicio del timer para medir la duraccion de la consulta
			
			ejecutarEjercicio3A(session);
			
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

	private static void ejecutarEjercicio3A(Session session){
		System.out.println("Persistir una mudanza de 6 horas para el día 4 de agosto de 2012 con 2 ayudantes:");
		System.out.println("Federico López, nacido el 9/2/1980");
		System.out.println("Daniel Estévez, nacido el 4/12/1975,");
		System.out.println("Y un conductor");
		System.out.println("Alberto Sánchez, nacido el 5/3/1970, conduciendo un camión patente ERS390 con");
		System.out.println("soporte para 4500 kilos.");
		System.out.println();

		DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd");
		/* Empleados */
		Date d1 = dfm.parse("1980-02-09");
		Empleado e1 = new Empleado("Federico López", d1, "21-22022663-9");
		Date d2 = dfm.parse("1975-04-12");
		Empleado e2 = new Empleado("Daniel Estevez", d1, "21-33033663-7");
		Date d3 = dfm.parse("1970-03-05");
		Empleado e3 = new Empleado("Alberto Sánchez", d1, "21-44044663-7");
		Ayudante a1 = new Ayudante(e1);
		Ayudante a2 = new Ayudante(e2);
		
		Camion camion = new Camion();
		camion.setPesoMaximo(4500);
		
		Conductor c1 = new Conductor(e3, camion);
		
		ArrayList<RolEmpleado> emple1 = new ArrayList<RolEmpleado>();
		emple1.add(a1);
		emple1.add(a2);
		emple1.add(c1);
		
		Date fecha = dfm.parse("2012-08-04");
		Mudanza m1 = new Mudanza(emple1, "XXX", fecha, 6);
		EmpresaDeMudanzas e;
		Query query = session.createQuery("from modelo.EmpresaDeMudanzas em");
		try {
			
			List<EmpresaDeMudanzas> empresas = query.list();
			e = empresas.get(0);
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
				
	}	
}
