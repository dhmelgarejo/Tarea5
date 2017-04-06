package edu.uniandes.ecos.controlador;

import java.io.FileNotFoundException;
import java.util.Scanner;


import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;
import static spark.Spark.*;

import edu.uniandes.ecos.modelo.Logica;
import edu.uniandes.ecos.modelo.Persistencia;
import edu.uniandes.ecos.vista.Presentacion;


/**
	* Programa 5 - Integracion numerica con simpson
	* ECOS Primer Semestre de 2017
	*
	* @author  Daniel Melgarejo
**/
public class Principal {
	public static void main(String[] args) {
		
	    port(Integer.valueOf(System.getenv("PORT")));
	    staticFileLocation("/public");
	    
		Scanner in = new Scanner(System.in);
		String ruta = "target/classes/public/test1.txt";
		Persistencia datos = new Persistencia();
		Lector lector = new Lector(datos);
		try {
			lector.leerArchivo(ruta);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		datos.calcularP();
		//Impresion de resultados
		Presentacion.mostrarResultados(datos);
		

		String ruta2 = "target/classes/public/test2.txt";
		Persistencia datos2 = new Persistencia();
		Lector lector2 = new Lector(datos2);
		try {
			lector2.leerArchivo(ruta2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		datos2.calcularP();
		//Impresion de resultados
		Presentacion.mostrarResultados(datos2);
		

		String ruta3 = "target/classes/public/test3.txt";
		Persistencia datos3 = new Persistencia();
		Lector lector3 = new Lector(datos3);
		try {
			lector3.leerArchivo(ruta3);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		datos3.calcularP();
		//Impresion de resultados
		Presentacion.mostrarResultados(datos3);
		
		get("/", (req, res) -> 
			"<h2>Expected Values</h2>"+
			"<table border='1'>"+
			"<th>x inicial</th>"+
			"<th>x final</th>"+
			"<th>dof</th>"+
			"<th>p</th>"+
			"<tr>"+
			"<td>"+datos.getxInicial()+"</td>"+
			"<td>"+datos.getxFinal()+"</td>"+
			"<td>"+datos.getDof()+"</td>"+
			"<td>"+datos.getP()+"</td>"+
			"<tr>"+
			"<td>"+datos2.getxInicial()+"</td>"+
			"<td>"+datos2.getxFinal()+"</td>"+
			"<td>"+datos2.getDof()+"</td>"+
			"<td>"+datos2.getP()+"</td>"+
			"<tr>"+
			"<td>"+datos3.getxInicial()+"</td>"+
			"<td>"+datos3.getxFinal()+"</td>"+
			"<td>"+datos3.getDof()+"</td>"+
			"<td>"+datos3.getP()+"</td>"+
			"</tr></table>"
		);
	}
}
