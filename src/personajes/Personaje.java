package personajes;

import utils.ConsoleColors;

import java.util.ArrayList;
import java.util.Scanner;

public class Personaje {
	private String nombreReal;
	private String nombreFicticio;
	private String tipo;
	private Caracteristicas caracteristicas;

	public Personaje(String tipo, String nombreReal, String nombreFicticio, Caracteristicas caracteristicas) {
		this.nombreReal = nombreReal;
		this.nombreFicticio = nombreFicticio;
		this.caracteristicas = caracteristicas;
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombreReal() {
		return nombreReal;
	}

	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
	}

	public String getNombreFicticio() {
		return nombreFicticio;
	}

	public void setNombreFicticio(String nombreFicticio) {
		this.nombreFicticio = nombreFicticio;
	}

	public Caracteristicas getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(Caracteristicas caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public enum Tipos {
		Heroe, Villano
	}

	@Override
	public String toString() {
		return this.tipo + "\t\t" + this.nombreReal + "\t" + this.nombreFicticio + "\t"
				+ this.caracteristicas.getVelocidad() + "\t\t" + this.caracteristicas.getFuerza() + "\t"
				+ this.caracteristicas.getResistencia() + "\t\t" + this.caracteristicas.getDestreza();
	}


	public static Personaje crearPersonaje() {
		System.out.println("\n\n\n\n" + ConsoleColors.BLUE_BOLD_BRIGHT + "Bienvenido a la creacion de personaje"
				+ ConsoleColors.RESET);
		System.out.println("\n" + ConsoleColors.BLUE_BRIGHT + "Primero seleccionemos el tipo. Por favor elija "
				+ ConsoleColors.BLUE_BRIGHT + "(1)" + ConsoleColors.RESET + " si desea crear un heroe, o "
				+ ConsoleColors.BLUE_BRIGHT + "(2)" + ConsoleColors.RESET + " si desea crear un villano. "
				+ ConsoleColors.RESET);
		Scanner scanner = new Scanner(System.in);
		int tipoDePersonaje = scanner.nextInt();
		String tipoDePersonajeTexto;
		if (tipoDePersonaje == 1) {
			tipoDePersonajeTexto = "Heroe";
		} else if (tipoDePersonaje == 2) {
			tipoDePersonajeTexto = "Villano";
		} else {
			System.out.println("\n" + ConsoleColors.RED_BRIGHT
					+ "Opcion incorrecta. Volviendo al menu.... " + ConsoleColors.RESET);
			scanner.close();
			return null;
		}
		System.out.println("\n" + ConsoleColors.BLUE_BRIGHT
				+ "Ahora vamos con el nombre real. Puede escribirlo a continuacion: " + ConsoleColors.RESET);
		String nombreReal = scanner.next();
		System.out.println("\n" + ConsoleColors.BLUE_BRIGHT
				+ "Genial! Continuamos con el nombre ficticio. Puede escribirlo a continuacion: "
				+ ConsoleColors.RESET);
		String nombreFicticio = scanner.next();
		System.out.println("\n" + ConsoleColors.BLUE_BRIGHT
				+ "Buen nombre! Ahora definiremos sus habilidades(Recuerde que son numericas). \nComencemos con la velocidad: "
				+ ConsoleColors.RESET);
		int velocidad = scanner.nextInt();
		System.out.println("\n" + ConsoleColors.BLUE_BRIGHT + "Continuamos con la fuerza: " + ConsoleColors.RESET);
		int fuerza = scanner.nextInt();
		System.out.println("\n" + ConsoleColors.BLUE_BRIGHT + "Seguimos con la resistencia: " + ConsoleColors.RESET);
		int resistencia = scanner.nextInt();
		System.out.println("\n" + ConsoleColors.BLUE_BRIGHT + "Finalizamos con la destreza: " + ConsoleColors.RESET);
		int destreza = scanner.nextInt();

		System.out.println("\n\n" + ConsoleColors.GREEN_BRIGHT
				+ "Felicidades! Su personaje fue creado de la siguiente manera: " + ConsoleColors.RESET);
		System.out
				.println(ConsoleColors.BLUE_BRIGHT + "Tipo: " + tipoDePersonajeTexto + ConsoleColors.RESET);
		System.out
				.println(ConsoleColors.BLUE_BRIGHT + "Nombre Real: " + nombreReal + ConsoleColors.RESET);
		System.out
				.println(ConsoleColors.BLUE_BRIGHT + "Nombre Ficticio: " + nombreFicticio + ConsoleColors.RESET);
		System.out
				.println(ConsoleColors.BLUE_BRIGHT + "Velocidad: " + velocidad + ConsoleColors.RESET);
		System.out
				.println(ConsoleColors.BLUE_BRIGHT + "Fuerza: " + fuerza + ConsoleColors.RESET);
		System.out
				.println(ConsoleColors.BLUE_BRIGHT + "Resistencia: " + resistencia + ConsoleColors.RESET);
		System.out
				.println(ConsoleColors.BLUE_BRIGHT + "Destreza: " + destreza + ConsoleColors.RESET);

		// scanner.close();
		return new Personaje(tipoDePersonajeTexto, nombreReal, nombreFicticio,
				new Caracteristicas(velocidad, fuerza, resistencia, destreza));
	}

	public static Personaje buscarMiembroEnPersonajes(ArrayList<Personaje> personajes, String miembroABuscar) {
		for (Personaje personaje : personajes) {
			if (personaje.nombreFicticio.toLowerCase().trim().contains(miembroABuscar.toLowerCase().trim())) {
				return personaje;
			}
		}
		return null;
	}
}