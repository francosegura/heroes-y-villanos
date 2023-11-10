package menu;

import java.util.ArrayList;
import java.util.Scanner;

import archivos.Archivos;
import liga.Liga;
import personajes.Personaje;
import utils.ConsoleColors;

public class Menu {
	private static ArrayList<Personaje> personajes = new ArrayList<Personaje>();
	private static ArrayList<Liga> ligas = new ArrayList<Liga>();

	public static void showMenu() {
		System.out.println("Menu principal");
		System.out.println("------------------------------------");

		System.out
				.println("\n" + ConsoleColors.GREEN_BOLD_BRIGHT + "Administracion de personajes" + ConsoleColors.RESET);
		System.out.println("\t 1 - Carga desde archivo");
		System.out.println("\t 2 - Creacion");
		System.out.println("\t 3 - Listado");
		System.out.println("\t 4 - Guardar todos los personajes en archivo");

		System.out.println("\n" + ConsoleColors.GREEN_BOLD_BRIGHT + "Administracion de ligas" + ConsoleColors.RESET);
		System.out.println("\t 5 - Carga desde archivo");
		System.out.println("\t 6 - Creacion");
		System.out.println("\t 7 - Listado");
		System.out.println("\t 8 - Guardar todas las ligas en archivo");

		System.out.println("\n" + ConsoleColors.GREEN_BOLD_BRIGHT + "Realizacion de combates" + ConsoleColors.RESET);
		System.out.println("\t 9 - Personaje contra liga");
		System.out.println("\t 10 - Liga contra liga");

		System.out.println("\n" + ConsoleColors.GREEN_BOLD_BRIGHT + "Reportes" + ConsoleColors.RESET);
		System.out.println(
				"\t 11 - Todos los personajes o ligas que venzan a un\n personaje dado para cierta característica");
		System.out.println("\t 12 - Listado ordenado de personajes por \n múltiples características");

		System.out.println("\n\nSeleccione una opcion correcta, " + ConsoleColors.RED_BRIGHT + " o - 1 para salir\n\n\n"
				+ ConsoleColors.RESET);
		System.out.println("------------------------------------");
		System.out.println("\n\n\n");

		/***************************************************/
	}

	public static void main(String[] args) {
		System.out.println(ConsoleColors.BLUE_BOLD + "BIENVENIDO A HEROES Y VILLANOS! \n\n" + ConsoleColors.RESET);
		try (Scanner scanner = new Scanner(System.in)) {
			showMenu();
			int selection = scanner.nextInt();

			while (selection != -1) {
				hacerAlgoAPartirDeSeleccion(selection);
				System.out.println("\n\nSeleccione una opcion correcta del menu, " + ConsoleColors.RED_BRIGHT
						+ " o - 1 para salir\n\n\n" + ConsoleColors.RESET);
				selection = scanner.nextInt();
			}
		}
	}

	private static void imprimirPersonajes() {
		String personajesImprimibles = "";
		for (Personaje personaje : personajes) {
			personajesImprimibles = personajesImprimibles.concat("\n" + personaje);
		}
		System.out.println("Heroe/Villano\tNombreReal\tNombrePersonaje\tVelocidad\tFuerza\tResistencia\tDestreza");
		System.out.println(ConsoleColors.BLUE + personajesImprimibles + ConsoleColors.RESET);
	}

	private static void imprimirLigas() {
		String ligasImprimibles = "";
		for (Liga liga : ligas) {
			ligasImprimibles = ligasImprimibles.concat("\n\n\n" + liga);
		}
		System.out.println("Nombre\t\t\t	Miembros");
		System.out.println(ConsoleColors.BLUE + ligasImprimibles + ConsoleColors.RESET);
	}

	private static void hacerAlgoAPartirDeSeleccion(int selection) {
		switch (selection) {
		case 1:
//			Scanner scanner = new Scanner(System.in);
//				System.out.println("Por supuesto! Por favor indique el nombre del archivo: ");
//				String nombreArchivo = scanner.next();

			personajes = Archivos.cargarPersonajesDesdeArchivo("personajes.in");

			System.out.println("\n\n" + ConsoleColors.GREEN_BRIGHT + "Felicidades" + ConsoleColors.RESET
					+ "! Logramos cargar los siguientes personajes: \n");
			imprimirPersonajes();
			break;
		case 2:
			System.out.println("\n\nPor supuesto! Vayamos a crear un personaje nuevo");
			Personaje nuevoPersonaje = Personaje.crearPersonaje();
			if(nuevoPersonaje instanceof Personaje) {
				personajes.add(nuevoPersonaje);
			}
			break;
		case 3:
			if(personajes.size() == 0) {				
				System.out.println("\n\nAun no ha cargado ningun personaje. Puede hacerlo mediante las opciones 1 o 2");
				break;
			}
			System.out.println("\n\nPor supuesto! Aqui tienes el listado de personajes cargados: ");
			imprimirPersonajes();
			break;
		case 4:
//			Scanner scanner = new Scanner(System.in);
//			System.out.println("Por supuesto! Por favor indique el nombre del archivo: ");
//			String nombreArchivo = scanner.next();
			Archivos.guardarPersonajesEnArchivo("Ponele");
			break;
		case 5:
//			Scanner scanner = new Scanner(System.in);
//				System.out.println("Por supuesto! Por favor indique el nombre del archivo: ");
//				String nombreArchivo = scanner.next();

			ligas = Archivos.cargarLigasDesdeArchivo("ligas.in");
			System.out.println("\n\n" + ConsoleColors.GREEN_BRIGHT + "Felicidades" + ConsoleColors.RESET
					+ "! Logramos cargar las siguientes ligas: \n");
			imprimirLigas();
			break;
		case 7:
			if(ligas.size() == 0) {				
				System.out.println("\n\nAun no ha cargado ninguna liga. Puede hacerlo mediante la opcion 5");
				break;
			}
			System.out.println("\n\nPor supuesto! Aqui tienes el listado de ligas cargadas: ");
			imprimirLigas();
			break;
		case 8:
//			Scanner scanner = new Scanner(System.in);
//			System.out.println("Por supuesto! Por favor indique el nombre del archivo: ");
//			String nombreArchivo = scanner.next();
			Archivos.guardarPersonajesEnArchivo("Ponele");
			break;
		case 9:
//			Scanner scanner = new Scanner(System.in);
//			System.out.println("Por supuesto! Por favor indique el nombre del archivo: ");
//			String nombreArchivo = scanner.next();
			Archivos.guardarPersonajesEnArchivo("Ponele");
			break;

		default:
			System.out.println(ConsoleColors.PURPLE_BRIGHT + "\nNo implementado aun x.x\n\n" + ConsoleColors.RESET);
			break;
		}
	}
}
