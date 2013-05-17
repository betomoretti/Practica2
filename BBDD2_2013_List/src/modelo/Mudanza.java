/**
 * Este paquete contiene las clases que representan las entidades del dominio.
 * 
 * Esta aplicacion de muestra fue desarrollada para la materia Bases de datos 2
 * de la Facultad de Informatica, perteneciente a la Universidad Nacional de La
 * Plata.
 */

package modelo;

import java.util.Date;
import java.util.HashSet;
import java.util.Collection;

/**
 * Las instancias de esta clase representan a las mudanzas.
 * @author Catedra de BBDD2 bbdd2_2012@gruposyahoo.com.ar
 */
public class Mudanza {
	
	private int idMudanza;
	/**
	 * Indica si la mudanza fue finalizada.
	 */
	private Boolean finalizada;
	
	/**
	 * Domicilio donde se realiza la mudanza.
	 */
	private String domicilio;
	/**
	 * Fecha en que realiza la mudanza.
	 */
	private Date fecha;
	/**
	 * Valor total cobrado por la mudanza.
	 */
	private Integer valor;
	/**
	 * Empleados que trabajan en la mudanza.
	 */
	private Collection<RolEmpleado> empleados = new HashSet<RolEmpleado>();
	/**
	 * Duracion de la mudanza.
	 */
	private int horas;

	/**
	 * Constructor.
	 */
	public Mudanza() { }
	
	/**
	 * Constructor.
	 * 
	 * @param empleados
	 * 			coleccion de roles de empleados que trabajan en la mudanza.
	 * @param domicilio
	 * 			domicilio de la mudanzas.
	 * @param fecha
	 * 			fecha de la mudanza.
	 * @param horasHombre
	 * 			horas que lleva la mudanza.
	 */
	public Mudanza(Collection<RolEmpleado> empleados, String domicilio, Date fecha, int horasHombre) {
		this.setEmpleados(empleados);
		this.setDomicilio(domicilio);
		this.setFecha(fecha);
		this.setHoras(horasHombre);
		this.setValor(Tarifario.getInstance().calcularCosto(this));
		this.setFinalizada(false);
	}
	
	/**
	 * Agrega un conductor a la mudanza.
	 * 
	 * @param empleado
	 * 			el empleado sobre el cual se arma el rol de conductor.
	 * @param transporte
	 * 			el transporte que conduce.
	 */
	public void agregarConductor(Empleado empleado, Transporte transporte) {
	    Conductor conductor = new Conductor(empleado, transporte);
	    this.getEmpleados().add(conductor);
	    this.recalcularValor();
	}

	/**
	 * Calcula el valor de la mudanza.
	 */
	private void recalcularValor() {
	    this.setValor(Tarifario.getInstance().calcularCosto(this));
	}

	/**
	 * Agrega un ayudante a la mudanza.
	 * 
	 * @param empleado
	 * 			el empleado sobre el cual se arma el rol de ayudante.
	 */
	public void agregarAyudante(Empleado empleado) {
	    Ayudante ayudante = new Ayudante(empleado);
	    this.getEmpleados().add(ayudante);
	    this.recalcularValor();
	
	  }
	
	public void finalizar(){
	    this.setFinalizada(true);
	}

	/**
	 * Getter.
	 * 
	 * @return los transportes utilizados por los conductores de la mudanza.
	 */
	public Collection<Transporte> getTransportes() {
	    Collection<Transporte> transportes = new HashSet<Transporte>();
	    for (RolEmpleado empleado : this.getEmpleados()) {
	      if (!(empleado.getTransporte() == null))
	    	transportes.add(empleado.getTransporte());
	    }
	    return transportes;
	  }
	
	/**
	 * Getter 
	 * 
	 * @return int idMudanza
	 */
	public int getIdMudanza() {
		return idMudanza;
	}
	
	/**
	 * Setter
	 * 
	 * @param idMudanza
	 */
	public void setIdMudanza(int idMudanza) {
		this.idMudanza = idMudanza;
	}

	/**
	 * Getter.
	 * 
	 * @return las horas de la mudanza.
	 */
	public int getHoras() {
	    return horas;
	  }

	/**
	 * Setter.
	 * 
	 * @param horas
	 *			las horas de la mudanza.
	 */
	private void setHoras(int horas) {
	    this.horas = horas;
	  }

	/**
	 * Getter.
	 * 
	 * @return el domicilio de la mudanza.
	 */
	public String getDomicilio() {
	    return domicilio;
	  } 

	/**
	 * Setter.
	 * 
	 * @param domicilio
	 *			el domicilio de la mudanza.
	 */
	private void setDomicilio(String domicilio) {
	    this.domicilio = domicilio;
	  }

	/**
	 * Getter.
	 * 
	 * @return la fecha de la mudanza.
	 */
	public Date getFecha() {
	    return fecha;
	  }

	/**
	 * Setter.
	 * 
	 * @param fecha
	 *			losla fecha de la mudanza.
	 */
	private void setFecha(Date fecha) {
	    this.fecha = fecha;
	  }

	/**
	 * Getter.
	 * 
	 * @return el valor cobrado para la mudanza.
	 */
	public int getValor() {
	    return valor;
	  }
	
	/**
	 * Setter.
	 * 
	 * @param empleados
	 *			los empleados que trabajan en la mudanza.
	 */
	private void setValor(int valor) {
	    this.valor = valor;
	  }

	/**
	 * Getter.
	 * 
	 * @return los empleados que trabajan en la mudanza.
	 */
	public Collection<RolEmpleado> getEmpleados() {
	    return empleados;
	  }

	/**
	 * Setter.
	 * 
	 * @param empleados
	 *			los empleados que trabajan en la mudanza.
	 */
	private void setEmpleados(Collection<RolEmpleado> empleados) {
	    this.empleados = empleados;
	  }

	public boolean getFinalizada() {
		return finalizada;
	}

	private void setFinalizada(Boolean finalizada) {
		this.finalizada = finalizada;
	}
	
	@Override
	public String toString() {
		return "Mudanza [finalizada=" + finalizada + ", domicilio=" + domicilio
				+ ", fecha=" + fecha + ", valor=" + valor + ", empleados="
				+ empleados + ", horas=" + horas + "]";
	}  
}
