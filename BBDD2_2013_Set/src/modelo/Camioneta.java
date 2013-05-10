/**
 * Este paquete contiene las clases que representan las entidades del dominio.
 * 
 * Esta aplicacion de muestra fue desarrollada para la materia Bases de datos 2
 * de la Facultad de Informatica, perteneciente a la Universidad Nacional de La
 * Plata.
 */

package modelo;

/**
 * Las instancias de esta clase representan camionetas de mudanza.
 * 
 * @author Catedra de BBDD2 bbdd2_2012@gruposyahoo.com.ar
 * 
 */
public class Camioneta extends Transporte {

	public Camioneta() {
		this.setTipoTransporte("Camioneta");
	}
	
	/**
	 * Retorna el valor que se cobra por hora de uso del transporte.
	 * 
	 * @return el valor por hora.
	 */
	@Override
	public int valorPorHora() {
	  return 60;
	}
	/**
	 * Retorna que transporte es.
	 * 
	 * @return el valor por hora.
	 */
	/*public String tipoTransporte(){
		return "Camioneta";
	}*/
}
