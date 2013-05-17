/**
 * Este paquete contiene las clases que representan las entidades del dominio.
 * 
 * Esta aplicacion de muestra fue desarrollada para la materia Bases de datos 2
 * de la Facultad de Informatica, perteneciente a la Universidad Nacional de La
 * Plata.
 */

package modelo;

import java.util.HashSet;
import java.util.Collection;

/**
 * La instancia unica de esta clase representa a la empresa de mudanzas.
 * 
 * @author Catedra de BBDD2 bbdd2_2012@gruposyahoo.com.ar
 * 
 */
public class EmpresaDeMudanzas {

	private int idEmpresaDeMudanzas;
	
	/**
	 * CUIT de la empresa.
	 */
	private String cuit;

	/**
	 * Razon social .
	 */
	private String razonSocial;
	
	/**
	 * Gerente .
	 */
	private Empleado gerente;

	/**
	 * Coleccion con todos los empleados de la empresa.
	 */
	private Collection<Empleado> empleados = new HashSet<Empleado>();

	/**
	 * Coleccion con todos los transportes de la empresa.
	 */
	private Collection<Transporte> transportes = new HashSet<Transporte>();

	/**
	 * Coleccion de todas las mudanzas realizadas.
	 */
	private Collection<Mudanza> realizadas = new HashSet<Mudanza>();

	/**
	 * Coleccion de todas las mudanzas que aun no fueron finalizadas.
	 */
	private Collection<Mudanza> pendientes = new HashSet<Mudanza>();
	
	public EmpresaDeMudanzas() { }
	
	/**
	 * Constructor.
	 * 
	 * @param transportes
	 * 			coleccion de transportes de la empresa.
	 * @param mudanzasFinalizadas
	 * 			coleccion de mudanzas finalizadas.
	 * @param mudanzasPendientes
	 * 			coleccion de mudanzas sin finalizar.
	 * @param empleados
	 * 			coleccion de empleados de la empresa.
	 * @param gerente
	 * 			gerente de la empresa
	 */
	public EmpresaDeMudanzas(Collection<Transporte> transportes, Collection<Mudanza> mudanzasFinalizadas,
	    Collection<Mudanza> mudanzasPendientes, Collection<Empleado> empleados, Empleado gerente) {
	  super();
	  this.setTransportes(transportes);
	  this.setRealizadas(mudanzasFinalizadas);
	  this.setPendientes(mudanzasPendientes);
	  this.setEmpleados(empleados);
	  this.setGerente(gerente);
	}
	
	/**
	 * @return the idEmpresaDeMudanzas
	 */
	public int getIdEmpresaDeMudanzas() {
		return idEmpresaDeMudanzas;
	}

	/**
	 * @param idEmpresaDeMudanzas the idEmpresaDeMudanzas to set
	 */
	public void setIdEmpresaDeMudanzas(int idEmpresaDeMudanzas) {
		this.idEmpresaDeMudanzas = idEmpresaDeMudanzas;
	}

	/**
	 * Getter.
	 * 
	 * @return el CUIT de la empresa.
	 */
	public String getCuit() {
	  return cuit;
	}

	/**
	 * Setter.
	 * 
	 * @param cuit
	 *			es el CUIT de la empresa.
	 */
	public void setCuit(String cuit) {
	  this.cuit = cuit;
	}

	/**
	 * Getter.
	 * 
	 * @return la razon social de la empresa.
	 */
	public String getRazonSocial() {
	  return razonSocial;
	}

	/**
	 * Setter.
	 * 
	 * @param razonSocial
	 *			es la razon social de la empresa.
	 */
	public void setRazonSocial(String razonSocial) {
	  this.razonSocial = razonSocial;
	}

	/**
	 * Getter.
	 * 
	 * @return la coleccion de empleados de la empresa.
	 */
	public Collection<Empleado> getEmpleados() {
	  return empleados;
	}

	/**
	 * Setter.
	 * 
	 * @param empleados
	 *			es la coleccion de empleados de la empresa.
	 */
	private void setEmpleados(Collection<Empleado> empleados) {
	  this.empleados = empleados;
	}

	/**
	 * Getter.
	 * 
	 * @return la coleccion de transportes de la empresa.
	 */
	public Collection<Transporte> getTransportes() {
	  return transportes;
	}

	/**
	 * Setter.
	 * 
	 * @param transportes
	 *			es la coleccion de transportes de la empresa.
	 */
	private void setTransportes(Collection<Transporte> transportes) {
	  this.transportes = transportes;
	}

	/**
	 * Getter.
	 * 
	 * @return la coleccion de mudanzas finalizadas.
	 */
	public Collection<Mudanza> getRealizadas() {
	  return realizadas;
	}

	/**
	 * Setter.
	 * 
	 * @param realizadas
	 *			es la coleccion de mudanzas finalizadas.
	 */
	private void setRealizadas(Collection<Mudanza> realizadas) {
	  this.realizadas = realizadas;
	}

	/**
	 * Getter.
	 * 
	 * @return la coleccion de mudanzas sin finalizar.
	 */
	public Collection<Mudanza> getPendientes() {
	  return pendientes;
	}

	/**
	 * Setter.
	 * 
	 * @param pendientes
	 *			es la coleccion de mudanzas sin finalizar.
	 */
	private void setPendientes(Collection<Mudanza> pendientes) {
	  this.pendientes = pendientes;
	}
	/**
	 * Getter
	 * @return el gerente de la empresa
	 */
	public Empleado getGerente() {
		return gerente;
	}
	/**
	 * Setter
	 * @param el gerente de la empresa
	 */
	private void setGerente(Empleado gerente) {
		this.gerente = gerente;
	}
	/**
	 * Finaliza una mudanza.
	 * 
	 * @param la mudanza a finalizar.
	 */
	public void finalizarMudanza(Mudanza mudanza) {
	  this.getPendientes().remove(mudanza);
	  mudanza.finalizar();
	  this.getRealizadas().add(mudanza);
	}
}
