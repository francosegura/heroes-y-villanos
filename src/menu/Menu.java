package menu;

import java.util.ArrayList;
import java.util.Scanner;

import archivos.Archivo;
import batalla.Batalla;
import liga.Liga;
import personajes.Caracteristicas;
import personajes.Personaje;
import reportes.Reportes;
import utils.ConsoleColors;

public class Menu {
	private static ArrayList<Personaje> personajes = new ArrayList<Personaje>();
	private static ArrayList<Liga> ligas = new ArrayList<Liga>();
	public static final Scanner scanner = new Scanner(System.in);

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
		System.out.println("\t 9 - Personaje contra Personaje");
		System.out.println("\t 10 - Personaje contra liga");
		System.out.println("\t 11 - Liga contra liga");

		System.out.println("\n" + ConsoleColors.GREEN_BOLD_BRIGHT + "Reportes" + ConsoleColors.RESET);
		System.out.println(
				"\t 12 - Todos los personajes o ligas que venzan a un\n personaje dado para cierta caracteristica");
		System.out.println("\t 13 - Listado ordenado de personajes por \n multiples caracteristicas");

		System.out.println("\n\nSeleccione una opcion correcta, " + ConsoleColors.RED_BRIGHT + " o - 1 para salir\n\n\n"
				+ ConsoleColors.RESET);
		System.out.println("------------------------------------");
		System.out.println("\n\n\n");

		/***************************************************/
	}

	public static void main(String[] args) {
		System.out.println(ConsoleColors.BLUE_BOLD + "BIENVENIDO A HEROES Y VILLANOS! \n\n" + ConsoleColors.RESET);
		showMenu();
		int selection = scanner.nextInt();

		while (true) {
			if (selection == -1) {
				System.out.println("\n\n" + ConsoleColors.RED_BRIGHT
						+ "\nADIOS! \n\n\n"
						+ ConsoleColors.RESET);
				break;
			}
			hacerAlgoAPartirDeSeleccion(selection);
			System.out.println("\n\nSeleccione una opcion correcta del menu, " + ConsoleColors.RED_BRIGHT
					+ " o - 1 para salir\n\n\n" + ConsoleColors.RESET);
			System.out.println("Press Any Key To Continue...");
			// new java.util.Scanner(System.in).next();
			selection = new Scanner(System.in).nextInt();
			showMenu();
		}
		scanner.close();
	}

	private static void imprimirPersonajes() {
		for (Personaje personaje : personajes) {
			System.out.println("\n\n" + personaje);
		}
	}

	private static void imprimirLigas() {
		for (Liga liga : ligas) {
			System.out.println("\n\n\n" + liga);
		}
	}
    private static String ingresarPersonaje(Scanner scanner) {
        System.out.println("Ingrese el nombre del personaje:");
        scanner.nextLine(); // Consumir la nueva línea pendiente después de nextInt
        return scanner.nextLine();
    }

    private static String ingresarCaracteristica(Scanner scanner) {
        System.out.println("Ingrese la característica:");
        return scanner.next();
    }
	 private static String[] ingresarCaracteristicas(Scanner scanner) {
	        System.out.println("Ingrese entre 1 y 4 características (separadas por espacios):");
	        scanner.nextLine(); // Consumir la nueva línea pendiente después de nextInt
	        String entrada = scanner.nextLine();
	        String[] caracteristicas = entrada.split("\\s+");

	        // Validar la cantidad de características
	        while (caracteristicas.length < 1 || caracteristicas.length > 4) {
	            System.out.println("Cantidad de características no válida. Ingrese entre 1 y 4 características:");
	            entrada = scanner.nextLine();
	            caracteristicas = entrada.split("\\s+");
	        }

	        return caracteristicas;
	    }
	private static void hacerAlgoAPartirDeSeleccion(int selection) {
		switch (selection) {
			case 1:
				// Scanner scanner = new Scanner(System.in);
				// System.out.println("Por supuesto! Por favor indique el nombre del archivo:
				// ");
				// String nombreArchivo = scanner.next();
				ArrayList<Personaje> personajesDesdeArchivo = Archivo.cargarPersonajesDesdeArchivo("personajes.in");
				for (Personaje personajeDesdeArchivo : personajesDesdeArchivo) {
					personajes.add(personajeDesdeArchivo);
				}

				System.out.println("\n\n" + ConsoleColors.GREEN_BRIGHT + "Felicidades" + ConsoleColors.RESET
						+ "! Logramos cargar los siguientes personajes: \n");
				imprimirPersonajes();
				break;
			case 2:
				System.out.println("\n\nPor supuesto! Vayamos a crear un personaje nuevo");
				Personaje nuevoPersonaje = Personaje.crearPersonaje();
				if (nuevoPersonaje instanceof Personaje) {
					personajes.add(nuevoPersonaje);
				}
				break;
			case 3:
				if (personajes.size() == 0) {
					System.out.println(
							"\n\nAun no ha cargado ningun personaje. Puede hacerlo mediante las opciones 1 o 2");
					break;
				}
				System.out.println("\n\nPor supuesto! Aqui tienes el listado de personajes cargados: \n\n");
				imprimirPersonajes();
				break;
			case 4:
				// Scanner scanner = new Scanner(System.in);
				// System.out.println("Por supuesto! Por favor indique el nombre del archivo:
				// ");
				// String nombreArchivo = scanner.next();
				Archivo.guardarPersonajesEnArchivo("personajesAArchivo.in", personajes);
				break;
			case 5:
				// Scanner scanner = new Scanner(System.in);
				// System.out.println("Por supuesto! Por favor indique el nombre del archivo:
				// ");
				// String nombreArchivo = scanner.next();

				ligas.addAll(Archivo.cargarLigasDesdeArchivo("ligas.in", ligas, personajes));
				System.out.println("\n\n" + ConsoleColors.GREEN_BRIGHT + "Felicidades" + ConsoleColors.RESET
						+ "! Logramos cargar las siguientes ligas: \n");
				imprimirLigas();
				break;
			case 6:
				System.out.println("\n\nPor supuesto! Vayamos a crear una nueva liga");
				Liga nuevaLiga = Liga.crearLiga(ligas, personajes);
				if (nuevaLiga instanceof Liga) {
					ligas.add(nuevaLiga);
				}
				break;
			case 7:
				if (ligas.size() == 0) {
					System.out.println("\n\nAun no ha cargado ninguna liga. Puede hacerlo mediante la opcion 5");
					break;
				}
				System.out.println("\n\nPor supuesto! Aqui tienes el listado de ligas cargadas: ");
				imprimirLigas();
				break;
			case 8:
				// Scanner scanner = new Scanner(System.in);
				// System.out.println("Por supuesto! Por favor indique el nombre del archivo:
				// ");
				// String nombreArchivo = scanner.next();
				Archivo.guardarLigasEnArchivo("ligasAArchivo.in", ligas);
				break;
			case 9: {
				System.out.println(ConsoleColors.GREEN_BRIGHT
						+ "\n\nBienvenido a la batalla Personaje vs Personaje! (Fran y Boca dan empate)" + ConsoleColors.RESET);
				System.out.println("\nIngrese el primer personaje a combatir: ");

				String primerNombreDePersonaje = scanner.next();
				Personaje primerPersonaje = Personaje.buscarMiembroEnPersonajes(personajes, primerNombreDePersonaje);

				if (primerPersonaje == null) {
					System.out.println("\n\nEl personaje ingresado no existe. Intente nuevamente");
					break;
				}

				System.out.println("\nIngrese el segundo personaje a combatir: ");
				String segundoNombreDePersonaje = scanner.next();
				Personaje segundoPersonaje = Personaje.buscarMiembroEnPersonajes(personajes, segundoNombreDePersonaje);

				if (segundoPersonaje == null) {
					System.out.println("\n\nEl personaje ingresado no existe. Intente nuevamente");
					break;
				}

				System.out.println(
						"\nIngrese la caracteristica por la que combatiran. Recuerde que las mismas son: Velocidad, Fuerza, Resistencia, Destreza:\n ");
				String caracteristica = Caracteristicas.caracteristicaValida(scanner.next());
				if (caracteristica.length() > 0) {
					Personaje ganador = Batalla.determinarGanador1v1(primerPersonaje, segundoPersonaje, caracteristica);
					if (ganador == null) {
						System.out.println("\n\nEMPATE! \n\n");
					} else {
						System.out.println("\n\nContendiente ganador: \n\n" + ganador);
					}
				} else {
					System.out.println("\n\nLa caracteristica ingresada no existe. Intente nuevamente");
					break;
				}
				break;
			}
			case 11: {
				System.out.println(ConsoleColors.GREEN_BRIGHT
						+ "\n\nBienvenido a la batalla Liga vs Liga!" + ConsoleColors.RESET);
				System.out.println("\nIngrese la primera liga a combatir: ");

				String nombrePrimeraLiga = scanner.next();
				Liga primeraLiga = Liga.buscarMiembroEnLigas(ligas, nombrePrimeraLiga);

				if (primeraLiga == null) {
					System.out.println("\n\nLa liga ingresada no existe. Intente nuevamente");
					break;
				}

				System.out.println("\nIngrese la segunda liga a combatir: ");
				String nombreSegundaLiga = scanner.next();
				Liga segundaLiga = Liga.buscarMiembroEnLigas(ligas, nombreSegundaLiga);

				if (segundaLiga == null) {
					System.out.println("\n\nLa liga ingresada no existe. Intente nuevamente");
					break;
				}

				System.out.println(
						"\nIngrese la caracteristica por la que combatiran. Recuerde que las mismas son: Velocidad, Fuerza, Resistencia, Destreza:\n ");
				String caracteristica = Caracteristicas.caracteristicaValida(scanner.next());
				if (caracteristica.length() > 0) {
					Liga ganador = Batalla.determinarGanadorNvN(primeraLiga, segundaLiga, caracteristica);
					if (ganador == null) {
						System.out.println("\n\nEMPATE! \n\n");
					} else {
						System.out.println("\n\nContendiente ganador: \n\n" + ganador);
					}
				} else {
					System.out.println("\n\nLa caracteristica ingresada no existe. Intente nuevamente");
					break;
				}
				break;
			}
			case 10: {
				System.out.println(ConsoleColors.GREEN_BRIGHT
						+ "\n\nBienvenido a la batalla Personaje vs Liga! (Boca y xmen dan empate)" + ConsoleColors.RESET);
				System.out.println("\nIngrese el personaje a combatir: ");

				String nombreDePersonaje = scanner.next();
				Personaje personaje = Personaje.buscarMiembroEnPersonajes(personajes, nombreDePersonaje);

				if (personaje == null) {
					System.out.println("\n\nEl personaje ingresado no existe. Intente nuevamente");
					break;
				}

				System.out.println("\nIngrese la liga a combatir: ");
				String nombreDeLiga = scanner.next();
				Liga liga = Liga.buscarMiembroEnLigas(ligas, nombreDeLiga);

				if (liga == null) {
					System.out.println("\n\nLa liga ingresada no existe. Intente nuevamente");
					break;
				}

				System.out.println(
						"\nIngrese la caracteristica por la que combatiran. Recuerde que las mismas son: Velocidad, Fuerza, Resistencia, Destreza:\n ");
				String caracteristica = Caracteristicas.caracteristicaValida(scanner.next());
				if (caracteristica.length() > 0) {
					Object ganador = Batalla.determinarGanador1vN(personaje, liga, caracteristica);
					if (ganador == null) {
						System.out.println("\n\nEMPATE! \n\n");
					} else {
						System.out.println("\n\nContendiente ganador: \n\n" + ganador);
					}
				} else {
					System.out.println("\n\nLa caracteristica ingresada no existe. Intente nuevamente");
					break;
				}
				break;
			}
			case 12:
                String heroe = ingresarPersonaje(scanner);
                String caracteristica = ingresarCaracteristica(scanner);
				Reportes.personajesVencedoresPorCaracteristica(personajes,heroe,caracteristica);
				break;
			case 13:
				String[] caracteristicas = ingresarCaracteristicas(scanner);
				System.out.println("Características ingresadas: ");
				for (String caracteristicaIngreada : caracteristicas) {
					System.out.println(caracteristicaIngreada);
				}
				Reportes.ordenarPorCaracteristicas(personajes, caracteristicas);
				break;

			default:
				System.out.println(ConsoleColors.PURPLE_BRIGHT + "\nNo implementado aun x.x\n\n" + ConsoleColors.RESET);
				break;
		}
	}
}
