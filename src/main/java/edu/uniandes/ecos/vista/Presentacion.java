package edu.uniandes.ecos.vista;

import edu.uniandes.ecos.modelo.Persistencia;

/**
 * Clase auxiliar para mostrar resultados de forma ordenada
 * @author Melga
 *
 */
public class Presentacion {
	
	/**
	 * Metodo estatico que recibe una instancia de la persistencia de datos y realiza la impresion de las
	 * operaciones entre variables para calcular la integracion numerica con metodo de simpson
	 * @param datos
	 */
	public static void mostrarResultados(Persistencia datos){
		System.out.println("Resultado:");
		System.out.println("x Inicial: "+datos.getxInicial());
		System.out.println("x Final: "+datos.getxFinal());
		System.out.println("dof: "+datos.getDof());
		System.out.println("p: "+datos.getP());
		System.out.println("------");
	}
	
}
