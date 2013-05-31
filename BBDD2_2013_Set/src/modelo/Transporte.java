/**
 * Este paquete contiene las clases que representan las entidades del dominio.
 * 
 * Esta aplicacion de muestra fue desarrollada para la materia Bases de datos 2
 * de la Facultad de Informatica, perteneciente a la Universidad Nacional de La
 * Plata.
 */
package modelo;

/**
 * Las instancias de esta clase representan transportes genericos de mudanzas.
 * 
 * @author Catedra de BBDD2 bbdd2_2012@gruposyahoo.com.ar
 */
public abstract class Transporte {
	
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Peso maximo que tolera el transporte.
	 */
	private int pesoMaximo;

	/**
	 * Patente del transporte.
	 */
	private String patente;
	private String tipoTransporte;

	/**
	 * Retorna el peso maximo que tolera el transporte.
	 * 
	 * @return el peso maximo que tolera el transporte.
	 */
	public int getPesoMaximo() {
	  return pesoMaximo;
	}

	/**
	 * Setea el valor maximo que soporta el transporte.
	 * 
	 * @param pesoMaximo
	 *		peso maximo que tolera el transporte.
	 */
	public void setPesoMaximo(int pesoMaximo) {
		this.pesoMaximo = pesoMaximo;
	}

	/**
	 * Retorna la patente del transporte.
	 * 
	 * @return la patente del transporte.
	 */
	public String getPatente() {
	  return patente;
	}

	/**
	 * Setea la patente del transporte.
	 * 
	 * @param patente
	 *			patente del transporte.
	 */
	public void setPatente(String patente) {
	  this.patente = patente;
	}

	/**
	 * Retorna el valor que se cobra por hora de uso del transporte.
	 * 
	 * @return el valor por hora.
	 */
	public abstract int valorPorHora();
	
	public String getTipoTransporte() {
		return this.tipoTransporte;
	}
	
	public void setTipoTransporte(String tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}
}