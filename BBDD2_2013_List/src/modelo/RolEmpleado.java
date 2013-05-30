/**
 * Este paquete contiene las clases que representan las entidades del dominio.
 * 
 * Esta aplicacion de muestra fue desarrollada para la materia Bases de datos 2
 * de la Facultad de Informatica, perteneciente a la Universidad Nacional de La
 * Plata.
 */

package modelo;

import java.util.Date;

/**
 * Las instancias de esta clase representan los roles de los empleados en las mudanzas.
 * 
 * @author Catedra de BBDD2 bbdd2_2012@gruposyahoo.com.ar
 */
public abstract class RolEmpleado {
	
	private int id;	

	/**
	 * Empleado sobre el cual se construye el rol.
	 */
	private Empleado empleado;
	/**
	 * Nombre del rol.
	 */
	private String nombreRol;

	/**
	 * Retorna el valor que un empleado cobra por hora bajo este rol.
	 * 
	 * @return el valor por hora.
	 */
	public abstract int valorPorHora();

	/**
	 * Retorna el rol que un empleado desempeña en una mudanza.
	 * 
	 * @return el nombre del rol.
	 */
	/*public String nombreRol(){
		return this.getNombreRol();
	};*/
	
	/**
	 * Getter.
	 * 
	 * @return el empleado del rol.
	 */
	public Empleado getEmpleado() {
	  return empleado;
	}

	/**
	 * Setter.
	 *
	 * @param empleado
	 *            es el empleado sobre el cual se construye el rol.
	 */
	protected void setEmpleado(Empleado empleado) {
	  this.empleado = empleado;
	}

	/**
	 * Retorna el nombre del empleado.
	 * 
	 * @return el nombre del empleado.
	 */
	public String getNombreCompleto() {
	  return this.getEmpleado().getNombreCompleto();
	}
	
	/**
	 * Retorna la fecha de nacimiento del empleado.
	 * 
	 * @return la fecha de nacimiento.
	 */
	public Date getFechaNacimiento() {
	  return this.getEmpleado().getFechaNacimiento();
	}
	
	/**
	 * Retorna el cuil del empleado.
	 * 
	 * @return el CUIL del empleado.
	 */
	public String getCuil() {
	  return this.getEmpleado().getCuil();
	}
	
	/**
	 * Retorna el jefe del empleado.
	 * 
	 * @return el jefe del empleado en la empresa.
	 */
	public Empleado getJefe() {
	  return this.getEmpleado().getJefe();
	}

	/**
	 * Retorna el transporte asignado el rol para la mudanza.
	 * 
	 * @return el transporte utilizado.
	 */
	public abstract Transporte getTransporte();

	/**
	 * Getter
	 * 
	 * @return el nombre del rol
	 */
	public String getNombreRol() {
		return nombreRol;
	}

	/**
	 * Setter
	 * 
	 * @param nombreRol
	 * 			el nombre del rol
	 */
	protected void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	
	public int getId() {
		return id;
	}

}
