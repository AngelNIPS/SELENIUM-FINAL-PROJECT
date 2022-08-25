package com.exercises;

public class Ejercicio5 {

	public static void main(String[] args) {
			
		/* EJERCICIO #5
		 * *
		 * Crear una clase que se llame Motos y vamos a crear 3 diferentes tipos de motos con estados y comportamientos.
		 *
		 */
		
		Moto moto1 = new Moto(2, 1, "V4", "Italika", "2020");
		moto1.encender();
		
		Moto moto2 = new Moto(2, 1, "V8", "Harley Davidson", "2000");
		moto2.encender();
		moto2.acelerar();
		
		Moto moto3 = new Moto(4, 2, "V6", "Honda", "2022");
		moto3.encender();
		moto3.acelerar();
		moto3.frenar();
	}
	
}

class Moto {
	
	private int llantas;
	private int asientos;
	private String motor;
	private String marca;
	private String modelo;
	
	public Moto(int llantas, int asientos, String motor, String marca, String modelo) {
		this.llantas = llantas;
		this.asientos = asientos;
		this.motor = motor;
		this.marca = marca;
		this.modelo = modelo;
	}
	
	public Moto(int llantas, int asientos, String modelo) {
		this.llantas = llantas;
		this.asientos = asientos;
		this.modelo = modelo;
	}
	
	public Moto() {	}
	
	
	public int getLlantas() {
		return llantas;
	}

	public void setLlantas(int llantas) {
		if(llantas>4) {
			this.llantas = -1;
		}else {
			this.llantas = llantas;
		}
	}
	
	public int getAsientos() {
		return asientos;
	}

	public void setAsientos(int asientos) {
		this.asientos = asientos;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public void acelerar() {
		System.out.println(this.marca + " " + this.modelo + " esta acelerando");
	}
	
	public void frenar() {
		System.out.println(this.marca + " " + this.modelo + " esta frenando");
	}
	
	public void encender() {
		System.out.println(this.marca + " " + this.modelo + " encendida");
	}
	
}
