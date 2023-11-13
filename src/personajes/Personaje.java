package personajes;

import utils.ConsoleColors;

import java.util.ArrayList;

import menu.Menu;

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
		return ConsoleColors.BLUE_BRIGHT + "\n\nTipo: " + this.tipo
				+ "\nnombre Real: " + nombreReal + "\nNombre Ficticio: " + nombreFicticio + "\nVelocidad: "
				+ this.caracteristicas.getVelocidad() + "\nFuerza: " + this.caracteristicas.getFuerza() + "\nResistencia: "
				+ this.caracteristicas.getResistencia() + "\nDestreza: " + this.caracteristicas.getDestreza()
				+ ConsoleColors.RESET;
	}

	public static Personaje crearPersonaje() {
		System.out.println("\n\n\n\n" + ConsoleColors.BLUE_BOLD_BRIGHT + "Bienvenido a la creacion de personaje"
				+ ConsoleColors.RESET);
		System.out.println("\n" + "Primero seleccionemos el tipo. Por favor elija "
				+ ConsoleColors.BLUE_BRIGHT + "(1)" + ConsoleColors.RESET + " si desea crear un heroe, o "
				+ ConsoleColors.BLUE_BRIGHT + "(2)" + ConsoleColors.RESET + " si desea crear un villano. ");
		int tipoDePersonaje = Menu.scanner.nextInt();
		String tipoDePersonajeTexto;
		if (tipoDePersonaje == 1) {
			tipoDePersonajeTexto = "Heroe";
		} else if (tipoDePersonaje == 2) {
			tipoDePersonajeTexto = "Villano";
		} else {
			System.out.println("\n" + ConsoleColors.RED_BRIGHT
					+ "Opcion incorrecta. Volviendo al menu.... " + ConsoleColors.RESET);
			return null;
		}
		System.out.println("\n" + ConsoleColors.BLUE_BRIGHT
				+ "Ahora vamos con el nombre real. Puede escribirlo a continuacion: " + ConsoleColors.RESET);
		String nombreReal = Menu.scanner.next();
		System.out.println("\n" + ConsoleColors.BLUE_BRIGHT
				+ "Genial! Continuamos con el nombre ficticio. Puede escribirlo a continuacion: "
				+ ConsoleColors.RESET);
		String nombreFicticio = Menu.scanner.next();
		System.out.println("\n" + ConsoleColors.BLUE_BRIGHT
				+ "Buen nombre! Ahora definiremos sus habilidades(Recuerde que son numericas). \nComencemos con la velocidad: "
				+ ConsoleColors.RESET);
		int velocidad = Menu.scanner.nextInt();
		System.out.println("\n" + ConsoleColors.BLUE_BRIGHT + "Continuamos con la fuerza: " + ConsoleColors.RESET);
		int fuerza = Menu.scanner.nextInt();
		System.out.println("\n" + ConsoleColors.BLUE_BRIGHT + "Seguimos con la resistencia: " + ConsoleColors.RESET);
		int resistencia = Menu.scanner.nextInt();
		System.out.println("\n" + ConsoleColors.BLUE_BRIGHT + "Finalizamos con la destreza: " + ConsoleColors.RESET);
		int destreza = Menu.scanner.nextInt();

		Personaje nuevoPersonaje = new Personaje(tipoDePersonajeTexto, nombreReal, nombreFicticio,
				new Caracteristicas(velocidad, fuerza, resistencia, destreza));
		System.out.println("\n\n" + ConsoleColors.GREEN_BRIGHT
				+ "Felicidades! Su personaje fue creado de la siguiente manera: \n" + ConsoleColors.RESET);
		System.out
				.println(nuevoPersonaje);
		
		return nuevoPersonaje;
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