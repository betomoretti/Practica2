package query;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
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

import com.sun.org.apache.xpath.internal.functions.FuncBoolean;

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
		ejecutarEjercicio3A(cfg);
		ejecutarEjercicio3B(cfg);
		ejecutarEjercicio3C(cfg);

		System.out.println("----------------------- Done. -----------------------");
		
	}
	public static void ejecutarEjercicio3C(Configuration cfg) {
		System.out.println("----------------------------------------------");
		System.out.println("Eliminar la mudanza del inciso a");
		System.out.println("----------------------------------------------");

		long elapsedTime = 0;
		sessions = cfg.buildSessionFactory();
		Session session = sessions.openSession();
		Transaction tx = null;
		try {
			String dir = "xxx";
			DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd");
			Date fecha = dfm.parse("2012-08-04");
			tx = session.beginTransaction();
			long start = System.nanoTime(); 
			Query query = session.createQuery("from modelo.Mudanza m where m.domicilio = ? and m.fecha = ?").setParameter(0, dir).setParameter(1, fecha);
			System.out.println("Ejecuta el query");
			Mudanza mudanza = (Mudanza) query.uniqueResult();
			
			EmpresaDeMudanzas empresa = (EmpresaDeMudanzas) session.createQuery("from modelo.EmpresaDeMudanzas em").uniqueResult();
			System.out.println("Quita la mudanza de la empresa");
			empresa.getPendientes().remove(mudanza);
			System.out.println("Persiste los datos");
			session.update(empresa);
			tx.commit();
			elapsedTime = System.nanoTime() - start;
			System.out.println("--------------------- El tiempo insumido es: -------------------------");
			System.out.println(elapsedTime);

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			elapsedTime = -1;
		}
	}
	
	
	
	public static void ejecutarEjercicio3B(Configuration cfg) {
		System.out.println("----------------------------------------------");
		System.out.println("Obtener la mudanza creada en el ejercicio 3a y eliminar el conductor");
		System.out.println("----------------------------------------------");
		
		long elapsedTime = 0;
		sessions = cfg.buildSessionFactory();
		Session session = sessions.openSession();
		Transaction tx = null;
		System.out.println("Obtener la mudanza creada en el ejercicio 3a y eliminar el conductor");

		try {
			String dir = "xxx";
			DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd");
			Date fecha = dfm.parse("2012-08-04");
			System.out.println("Comienza la transaccion");

			tx = session.beginTransaction();
			long start = System.nanoTime(); 
			Query query = session.createQuery("from modelo.Mudanza m where m.domicilio = ? and m.fecha = ?").setParameter(0, dir).setParameter(1, fecha);
			System.out.println("Ejecuta el query");

			Mudanza mudanza = (Mudanza) query.list().get(0);

			RolEmpleado conductor = null;
			Iterator<RolEmpleado> itRoles = mudanza.getEmpleados().iterator();
			System.out.println("Obtiene el condunctor de la coleccion de empleados de la mudanza");

			while (itRoles.hasNext() && (conductor == null)) {
				RolEmpleado auxRol = itRoles.next();
				if (auxRol.getNombreRol().equals("Conductor")) {
					conductor = auxRol;
				}
			}
			System.out.println("Elimina al conductor ");

			mudanza.getEmpleados().remove(conductor);
			System.out.println("Persiste los nuevos datos");

			session.update(mudanza);
			tx.commit();
			elapsedTime = System.nanoTime() - start;
			System.out.println("--------------------- El tiempo insumido es: -------------------------");
			System.out.println(elapsedTime);
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		

	}
	
	
	public static void ejecutarEjercicio3A(Configuration cfg) throws ParseException  {
		System.out.println("----------------------------------------------");
		System.out.println("Persistir una mudanza de 6 horas para el dia 4 de agosto de 2012 con 2 ayudantes:");
		System.out.println("Federico Lopez, nacido el 9/2/1980");
		System.out.println("Daniel Estevez, nacido el 4/12/1975,");
		System.out.println("Y un conductor");
		System.out.println("Alberto Sanchez, nacido el 5/3/1970, conduciendo un camion patente ERS390 con");
		System.out.println("soporte para 4500 kilos.");
		System.out.println("----------------------------------------------");

		System.out.println();
		
		System.out.println("----------------------- Creacion de los objetos. -----------------------");

		DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd");
		/* Empleados */
		Date d1 = dfm.parse("1980-02-09");
		Empleado em1 = new Empleado("Federico Lopez", d1, "21-22022663-9");
		Date d2 = dfm.parse("1975-04-12");
		Empleado em2 = new Empleado("Daniel Estevez", d2, "21-33033663-7");
		Date d3 = dfm.parse("1970-03-05");
		Empleado em3 = new Empleado("Alberto Sanchez", d3, "21-44044663-7");
		Ayudante a1 = new Ayudante(em1);
		Ayudante a2 = new Ayudante(em2);
		
		Camion camion = new Camion();
		camion.setPesoMaximo(4500);
		camion.setPatente("ERS390");
		
		Conductor c1 = new Conductor(em3, camion);
		
		ArrayList<RolEmpleado> empleadosMudanza = new ArrayList<RolEmpleado>();
		empleadosMudanza.add(a1);
		empleadosMudanza.add(a2);
		empleadosMudanza.add(c1);
		
		Date fecha = dfm.parse("2012-08-04");
		Mudanza m1 = new Mudanza(empleadosMudanza, "xxx", fecha, 6);
		System.out.println("----------------------- Fin de la creacion de los objetos. -----------------------");

		sessions = cfg.buildSessionFactory();
		Session session = sessions.openSession();
		Transaction tx = null;
		
		EmpresaDeMudanzas emp = null;
		long start = System.nanoTime(); //Inicio del timer para medir la duraccion de la consulta
		Query query = session.createQuery("from modelo.EmpresaDeMudanzas em");
		
		try {		
			tx = session.beginTransaction();
			System.out.println("----------------------- Ejecucion de la consulta. -----------------------");
			List<EmpresaDeMudanzas> empresas = query.list();
			emp = empresas.get(0);
			System.out.println("----------------------- Fin Ejecucion de la consulta. -----------------------");

			emp.getTransportes().add(camion);
			emp.getEmpleados().add(em1);
			emp.getEmpleados().add(em2);
			emp.getEmpleados().add(em3);
			emp.getPendientes().add(m1);
			System.out.println("----------------------- Persiste los datos. -----------------------");

			session.save(emp);
			session.flush();
			tx.commit();
			long elapsedTime = System.nanoTime() - start;   //Calculo de la duraccion en nanosegundos
			System.out.println("--------------------- El tiempo insumido es: -------------------------");
			System.out.println(elapsedTime);
		} catch (HibernateException e) {
			e.printStackTrace();
		}			
	}	
}
