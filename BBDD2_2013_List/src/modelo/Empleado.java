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
 * Las instancias de esta clase representan empleados de la empresa de mudanzas.
 * 
 * @author Catedra de BBDD2 bbdd2_2012@gruposyahoo.com.ar
 * 
 */
public class Empleado {
	
	private int id;

	/**
	 * El nombre completo del empleado.
	 */
	private String nombreCompleto;

	/**
	 * Fecha de nacimiento.
	 */
	private Date fechaNacimiento;

	/**
	 * CUIL del empleado.
	 */
	private String cuil;

	/**
	 * Jefe del empleado en la empresa.
	 */
	private Empleado jefe;
	
	public Empleado() {};
	
	public int getId() {
		return id;
	}


	
	/**
	 * Constructor.
	 * 
	 * @param nombreEmpleado
	 * 			es el nombre completo del empleado.
	 * @param fechaNacimiento
	 * 			es la fecha de nacimiento del empleado.
	 * @param cuil
	 * 			es el CUIL del empleado.
	 */
	public Empleado(String nombreEmpleado, Date fechaNacimiento, String cuil) {

	  this.setNombreCompleto(nombreEmpleado);
	  this.setFechaNacimiento(fechaNacimiento);
	  this.setCuil(cuil);

	}

	/**
	 * Asigna el jefe del empleado.
	 * 
	 * @param jefe
	 * 			es el jefe del empleado en la empresa.
	 */
	public void asignarJefe(Empleado empleado) {
	  this.setJefe(empleado);
	}

	/**
	 * Getter.
	 * 
	 * @return el nombre del empleado.
	 */
	public String getNombreCompleto() {
	  return nombreCompleto;
	}

	/**
	 * Setter.
	 * 
	 * @param nombreEmpleado
	 * 			es el nombre completo del empleado.
	 */
	  private void setNombreCompleto(String nombreEmpleado) {
	  this.nombreCompleto = nombreEmpleado;
	}

	/**
	 * Getter.
	 * 
	 * @return la fecha de nacimiento.
	 */
	public Date getFechaNacimiento() {
	  return fechaNacimiento;
	}

	/**
	 * Setter.
	 * 
	 * @param fechaNacimiento
	 * 			es la fecha de nacimiento.
	 */
	  private void setFechaNacimiento(Date fechaNacimiento) {
	  this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * Getter.
	 * 
	 * @return el CUIL del empleado.
	 */
	public String getCuil() {
	  return cuil;
	}

	/**
	 * Setter.
	 * 
	 * @param cuil
	 * 			es el CUIL del empleado.
	 */
	private void setCuil(String cuil) {
	  this.cuil = cuil;
	}

	/**
	 * Getter.
	 * 
	 * @return el jefe del empleado en la empresa.
	 */
	public Empleado getJefe() {
	  return jefe;
	}

	private void setJefe(Empleado jefe) {
		this.jefe = jefe;
	}
}
