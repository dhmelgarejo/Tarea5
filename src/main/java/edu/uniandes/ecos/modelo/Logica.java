package edu.uniandes.ecos.modelo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase con metodos estaticos auxiliares para calcular variables de simpson
 * @author Melga
 *
 */
public class Logica {
	
	/**
	 * Calcula el rango de distancia entre 2 segmentos de una curva
	 * @param datos
	 * @return
	 */
	public static double calcularW(double x, double num_seg){
		return x/num_seg;
	}
	
	/**
	 * Calcula el valor de p segun la formula encontrada en los requisitos
	 * @param datos
	 * @return
	 */
	public static double calcularP(double xI, double xF, double dof, double num_seg){
		double p = 0;
		
		double range = xF - xI;
		double w = calcularW(range, num_seg);

		double fp_equation = calcularFuncionGamma(dof);
		int j = 0;
		for (double i = xI; i <= xF; i += w) {
			double col1 = 1 + (Math.pow(i,2)/dof);
			double col2 = Math.pow(col1, -((dof+1)/2));
			double fX = fp_equation * col2;
			double res = 0;
			if(i==xI || i == xF)
				res += w/3 * fX;
			else
				if(j%2 == 0)
					res += w/3 * 2 * fX;
				else
					res += w/3 * 4 * fX;
			p += res;
			j++;
		}
		return p;
	}
	

	/**
	 * Calcula el factorial de un numero
	 * @param datos
	 * @return
	 */
	public static double calcularFactorial(double x){
		double resp = 1;
		while(x > 1){
			resp *= x;
			x--;
		}
		return resp;
	}

	/**
	 * Calcula el valor gamma para un numero no entero
	 * @return
	 */
	public static double calcularGammaNoEntero(double x){
		x -= 1;
		if(x == 0.5){
			return x * Math.sqrt(Math.PI);
		}else{
			return x * calcularGammaNoEntero(x);
		}
	}
	
	/**
	 * Calcula valores de simpson en varias iteraciones hasta validar que la diferencia sea menor a un epsilon definido
	 * @return
	 */
	public static double calcularSimpson(double xI, double xF, double dof){
		double e = 0.00001;
		double p1 = calcularP(xI, xF, dof, 10);
		double p2 = calcularP(xI, xF, dof, 20);
		double num_seg = 20;
		while(Math.abs(p1 - p2) < e){
			p1 = calcularP(xI, xF, dof, num_seg);
			p2 = calcularP(xI, xF, dof, num_seg+10);
			num_seg += 20;
		}
		return p1;
	}

	
	/**
	 * Calcula el valor de la funcion gama segun un grado de libertad
	 * @param grados de libertad
	 * @return
	 */
	public static double calcularFuncionGamma(double dof){
		double numerador, denominador;
		double res_temp = (dof+1)/2;
		if(res_temp - Math.floor(res_temp) == 0)
			numerador = calcularFactorial(res_temp-1);
		else
			numerador = calcularGammaNoEntero(res_temp);

		res_temp = dof/2;
		if(res_temp - Math.floor(res_temp) == 0)
			denominador = calcularFactorial(res_temp-1);
		else
			denominador = calcularGammaNoEntero(res_temp);
		denominador *= Math.pow((dof * Math.PI), 0.5);
		double fp_equation = numerador / denominador;
		return fp_equation;
	}

}
