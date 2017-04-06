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
	* Programa 5 
	* ECOS Primer Semestre de 2017
	*
	* @author  Daniel Melgarejo
**/
public class Principal {
	public static void main(String[] args) {
		
		
//		System.out.println(Logica.calcularGammaNoEntero(4.5, 1));
//		System.out.println(Logica.calcularSimpson(0, 1.1, 9));
//		System.out.println(Logica.calcularSimpson(0, 1.1812, 10));
//		System.out.println(Logica.calcularSimpson(0, 2.750, 30));
		
		
//	    port(Integer.valueOf(System.getenv("PORT")));
//	    staticFileLocation("/public");
	    
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
		
//		get("/", (req, res) -> 
//			"<h2>Expected Values</h2>"+
//			"<table border='1'><th></th>"+
//			"<th>VS</th>"+
//			"<th>S</th>"+
//			"<th>M</th>"+
//			"<th>L</th>"+
//			"<th>VL</th>"+
//			"<tr><td>LOC/Method</td>"+
//			"<td>"+datos.getVerySmall()+"</td>"+
//			"<td>"+datos.getSmall()+"</td>"+
//			"<td>"+datos.getMedium()+"</td>"+
//			"<td>"+datos.getLarge()+"</td>"+
//			"<td>"+datos.getVeryLarge()+"</td>"+
//			"</tr><tr><td>Pgs/Chapter</td>"+
//			"<td>"+datos2.getVerySmall()+"</td>"+
//			"<td>"+datos2.getSmall()+"</td>"+
//			"<td>"+datos2.getMedium()+"</td>"+
//			"<td>"+datos2.getLarge()+"</td>"+
//			"<td>"+datos2.getVeryLarge()+"</td>"+
//			"</tr></table>"
//		);
	}
}
