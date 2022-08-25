package com.exercises;

public class Ejercicio1 {
	
	public static void main(String[] args) {
		
		//EJERCICIO #1
		// 1.- Cambiar el tipo de variable de int a double.
		// 2.- Agregar la condicion cuando sea "Zona escolar".
		
		// Variables
		double velocidad = 20; // KM/h
		double limiteVelocidad = 80; // KM/h - Avenida
		boolean isCarretera = false;
		boolean isEscolar = false;
		
		if(isCarretera==true) {
			limiteVelocidad = 100;
			if(velocidad>limiteVelocidad) {
				// Block code
				System.out.println("Carretera - Multa");
			}else {
				System.out.println("Carretera - Manejas bien!!");
			}
		}else if(isEscolar==true) {
			limiteVelocidad = 20;
			if(velocidad>limiteVelocidad) {
				System.out.println("Calle - Multa");
			}else {
				System.out.println("Calle - Manejas bien!!");
			}
		}else if(velocidad>limiteVelocidad) {
			System.out.println("Calle - Multa");
		}else {
			System.out.println("Calle - Manejas bien!!");
		}		
	}

}
