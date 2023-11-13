package archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import liga.Liga;
import personajes.Caracteristicas;
import personajes.Personaje;

public class Archivos {
	public static ArrayList<Personaje> cargarPersonajesDesdeArchivo(String file) {
		ArrayList<Personaje> personajes = new ArrayList<Personaje>();
		String nombreArchivo = new File(file).getAbsolutePath();
		try {
			Scanner scanner = new Scanner(new File(nombreArchivo));

			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				String[] datos = linea.split(", ");
				if (datos[0].equals("Heroe") || datos[0].equals("Villano")) {
					String tipo = datos[0];
					String nombreReal = datos[1];
					String nombreFicticio = datos[2];
					double velocidad = Double.parseDouble(datos[3]);
					double fuerza = Double.parseDouble(datos[4]);
					double resistencia = Double.parseDouble(datos[5]);
					double destreza = Double.parseDouble(datos[6]);

					Caracteristicas caracteristicas = new Caracteristicas(velocidad, fuerza, resistencia, destreza);

					Personaje personaje = new Personaje(tipo, nombreReal, nombreFicticio, caracteristicas);

					personajes.add(personaje);
				}
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return personajes;
	} 

	public static void guardarPersonajesEnArchivo(String file) {
		// TODO: Hacer

	}

	public static ArrayList<Liga> cargarLigasDesdeArchivo(String file, ArrayList<Liga> ligasPrecargadas,
			ArrayList<Personaje> personajesPrecargados) {
		ArrayList<Liga> ligas = new ArrayList<Liga>();
		String nombreArchivo = new File(file).getAbsolutePath();
		try {
			Scanner scanner = new Scanner(new File(nombreArchivo));

			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				String[] datos = linea.split(", ");
				Liga liga = new Liga(datos[0]);
				for(int i = 1; i < datos.length ; i++) {
					liga.agregarMiembro(datos[i], ligasPrecargadas, personajesPrecargados);
				}
				ligas.add(liga);
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return ligas;
	}

	public static void guardarLigasEnArchivo(String file) {
		// TODO: Hacer

	}
}
