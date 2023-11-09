package menu;

import java.util.Scanner; // explicit Scanner import

import utils.ConsoleColors;

public class Menu {
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

		System.out.println(ConsoleColors.RED_BRIGHT + "\n\nSeleccione - 1 para salir\n\n\n" + ConsoleColors.RESET);
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
				selection = scanner.nextInt();
			}
		}
	}
	
	private static void hacerAlgoAPartirDeSeleccion(int selection) {
		switch (selection) {
		case 1:
			
			break;

		default:
			break;
		}
	}
}
