/**
 * Este paquete contiene las clases que representan las entidades del dominio.
 * 
 * Esta aplicacion de muestra fue desarrollada para la materia Bases de datos 2
 * de la Facultad de Informatica, perteneciente a la Universidad Nacional de La
 * Plata.
 */
package modelo;

/**
 * La instancia unica de esta clase representa el tarifario para cotizar las mudanzas.
 * 
 * @author Catedra de BBDD2 bbdd2_2012@gruposyahoo.com.ar
 */
public class Tarifario {
	
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	/**
	 * La unica instancia del tarifario. Es un singleton.
	 */
	private static Tarifario instance = null;

	/**
	 * Constructor.
	 * 
	 * impide la instanciacion, usar getInstance.
	 */
	private Tarifario() {};
	
	/**
	 * Retorna la unica instancia del singleton. Si no existe la crea.
	 * 
	 * @return la instancia unica.
	 */
	public static Tarifario getInstance() {
	   if(instance == null) {
	      instance = new Tarifario();
	   }
	   return instance;
	}

	/**
	 * Calcula el costo final de la mudanza.
	 * @param mudanza
	 * 		mudanza de la que se desea conocer el valor.
	 * @return
	 * 		el costo final de la mudanza
	 */
	public Integer calcularCosto(Mudanza mudanza) {
	  Integer costo = 0;
	  Integer importeEmpleado = 0;
	  for (RolEmpleado empleado: mudanza.getEmpleados()) {
	    importeEmpleado = importeEmpleado + empleado.valorPorHora();
	  }
	  Integer importeTransportes = 0;
	  for (Transporte transporte: mudanza.getTransportes()) {
	    importeTransportes = importeTransportes + transporte.valorPorHora();
	  }
	  costo = importeEmpleado + importeTransportes;
	  return costo * mudanza.getHoras();
	}
}
