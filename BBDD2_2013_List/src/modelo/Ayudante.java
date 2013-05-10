/**
 * Este paquete contiene las clases que representan las entidades del dominio.
 * 
 * Esta aplicacion de muestra fue desarrollada para la materia Bases de datos 2
 * de la Facultad de Informatica, perteneciente a la Universidad Nacional de La
 * Plata.
 */

package modelo;

/**
 * Las instancias de esta clase representan roles de ayudante para las mudanzas.
 * 
 * @author Catedra de BBDD2 bbdd2_2012@gruposyahoo.com.ar
 * 
 */
public class Ayudante extends RolEmpleado {
	
	public Ayudante() { }
	
	/**
	 * Constructor.
	 * 
	 * @param empleado
	 *            es el empleado sobre el cual se construye el rol.
	 */
	 public Ayudante(Empleado empleado) {
	   this.setEmpleado(empleado);
	   this.setNombreRol("Ayudante");
	 }
	
	/**
	 * Retorna el valor que un empleado cobra por hora bajo este rol.
	 * 
	 * @return el valor por hora.
	 */
	 @Override
	 public int valorPorHora() {
	   return 30;
	 }

	/**
	 * Retorna el transporte asignado el rol para la mudanza.
	 * 
	 * @return el transporte utilizado, ninguno en el caso del ayudante.
	 */
	 @Override
	 public Transporte getTransporte() {
	   return null;
	 }
}
