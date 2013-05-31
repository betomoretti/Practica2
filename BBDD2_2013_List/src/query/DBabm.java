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
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		System.out.println("----------------------- Setting up Hibernate -----------------------");
		Configuration cfg = new Configuration();
		cfg.configure();
		
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
		Empleado em1 = new Empleado("Federico López", d1, "21-22022663-9");
		Date d2 = dfm.parse("1975-04-12");
		Empleado em2 = new Empleado("Daniel Estevez", d1, "21-33033663-7");
		Date d3 = dfm.parse("1970-03-05");
		Empleado em3 = new Empleado("Alberto Sánchez", d1, "21-44044663-7");
		Ayudante a1 = new Ayudante(em1);
		Ayudante a2 = new Ayudante(em2);
		
		Camion camion = new Camion();
		camion.setPesoMaximo(4500);
		camion.setPatente("ERS390");
		
		Conductor c1 = new Conductor(em3, camion);
		
		ArrayList<RolEmpleado> emple1 = new ArrayList<RolEmpleado>();
		emple1.add(a1);
		emple1.add(a2);
		emple1.add(c1);
		
		Date fecha = dfm.parse("2012-08-04");
		Mudanza m1 = new Mudanza(emple1, "XXX", fecha, 6);
		
		sessions = cfg.buildSessionFactory();
		Session session = sessions.openSession();
		Transaction tx = null;
		try {
				
			long start = System.nanoTime(); //Inicio del timer para medir la duraccion de la consulta

			tx = session.beginTransaction();
			EmpresaDeMudanzas emp = ejecutarEjercicio3A(session);
			emp.getTransportes().add(camion);
			emp.getEmpleados().add(em1);
			emp.getEmpleados().add(em2);
			emp.getEmpleados().add(em3);
			emp.getPendientes().add(m1);
				session.save(emp);
				session.flush();
				tx.commit();
			long elapsedTime = System.nanoTime() - start;   //Calculo de la duraccion en nanosegundos
			
			System.out.println("Tiempo transcurrido: " + elapsedTime + " nanosegundos");


		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
			session.close();
		}
		session.disconnect() ;
	}

	private static EmpresaDeMudanzas ejecutarEjercicio3A(Session session) {
		
		EmpresaDeMudanzas emp = null;
		Query query = session.createQuery("from modelo.EmpresaDeMudanzas em");
		try {
			
			List<EmpresaDeMudanzas> empresas = query.list();
			emp = empresas.get(0);
			return emp;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return emp;
				
	}	
}
