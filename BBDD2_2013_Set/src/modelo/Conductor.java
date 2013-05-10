/**
 * Este paquete contiene las clases que representan las entidades del dominio.
 * 
 * Esta aplicacion de muestra fue desarrollada para la materia Bases de datos 2
 * de la Facultad de Informatica, perteneciente a la Universidad Nacional de La
 * Plata.
 */

package modelo;

/**
 * Las instancias de esta clase representan roles de conductor para las mudanzas.
 * 
 * @author Catedra de BBDD2 bbdd2_2012@gruposyahoo.com.ar
 * 
 */
public class Conductor extends RolEmpleado {

	/**
	 * Transporte que se conduce.
	 */
	private Transporte transporte;

	public Conductor() { }
	
	/**
	 * Constructor.
	 * 
	 * @param empleado
	 *            es el empleado sobre el cual se construye el rol
	 * @param transporte
	 *            es el transporte que conduce el conductor
	 */
	public Conductor(Empleado empleado, Transporte transporte) {
	  this.setEmpleado(empleado);
	  this.setTransporte(transporte);
	  this.setNombreRol("Conductor");
	}

	/**
	 * Retorna el valor que un empleado cobra por hora bajo este rol.
	 * 
	 * @return el valor por hora.
	 */
	public int valorPorHora() {
	  return 40;
	}

	/**
	 * Retorna el transporte asignado el rol para la mudanza.
	 * 
	 * @return el transporte utilizado.
	 */
	/*public Transporte transporteAsignado() {
	  return transporte;
	}*/

	/**
	 * Setter.
	 *
	 * @param transporte
	 *            el transporte utilizado.
	 */
	private void setTransporte(Transporte transporte) {
	  this.transporte = transporte;
	}

	public Transporte getTransporte() {
		return transporte;
	}
	
}
