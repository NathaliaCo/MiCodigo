package com.quiz3;

import javax.swing.JOptionPane;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a,b;
		int indicaciones;
		do {
		indicaciones=Integer.parseInt(JOptionPane.showInputDialog("Seleccione la operación que desea realizar: "
				+"\n 1. Ver el número mayor"
				+"\n 2. Ver el número menor"
				+"\n 3. Calcular la raíz cuadrada"
				+"\n 4. Elevar una potencia"
				+"\n 5. Salir"));
		
		a= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número a"));
		b= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número b"));
		
		
		switch (indicaciones) {
		case 1:
			mayor (a,b);
			break;
		case 2:
			menor (a,b);
			break;
		case 3:
			raiz (a,b);
			break;
		case 4:
		    potencia (a,b);
		case 5:
			break;
		
		}
	
	} while (indicaciones!=5);
	}
		
	public static void mayor (int a, int b) {
		
		int operacion1=0;
		operacion1=Math.max(a,b);
		
		JOptionPane.showMessageDialog(null, "El mayor de los dos números ingresados es: "+ operacion1);
		
	}
	public static void menor (int a, int b) {
		int operacion2=0;
		operacion2=Math.min(a,b);
		JOptionPane.showMessageDialog(null, "El menor de los dos números ingresados es: "+ operacion2);
		
	}
	public static void raiz (int a, int b) {
		int operacion3=0;
		int operacion3_1=0;
		operacion3=(int) Math.sqrt(a);
		operacion3_1=(int) Math.sqrt(b);
		
		JOptionPane.showMessageDialog(null, "La raiz cuadrada de "+ a + " es " + operacion3);
		JOptionPane.showMessageDialog(null, "La raiz cuadrada de "+ b + " es " + operacion3_1);
			
	}
	public static void potencia (int a, int b) {
		int operacion4=0;
		int operacion4_1=0;
	
		operacion4= (int) Math.pow(a,10);
		operacion4_1=(int) Math.pow(b,10);
		
		JOptionPane.showMessageDialog(null, "El número "+ a + " elevado a la potencia de 10 es igual a " + operacion4);
		JOptionPane.showMessageDialog(null, "El número "+ b + " elevado a la potencia de 10 es igual a " + operacion4_1);
		
		
	}

}
