package archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import personajes.Caracteristicas;
import personajes.Heroe;
import personajes.Personaje;
import personajes.Villano;

public class Archivos {
	public static ArrayList<Personaje> cargarLigasDesdeArchivo(String file) {
		ArrayList<Personaje> personajes = new ArrayList<Personaje>();
		String nombreArchivo = new File(file).getAbsolutePath();
		try {
			Scanner scanner = new Scanner(new File(nombreArchivo));

			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				String[] datos = linea.split(", ");
				if (datos[0].equals("Heroe")) {
					String nombreReal = datos[1];
					String nombreFicticio = datos[2];
					double velocidad = Double.parseDouble(datos[3]);
					double fuerza = Double.parseDouble(datos[4]);
					double resistencia = Double.parseDouble(datos[5]);
					double destreza = Double.parseDouble(datos[6]);

					Caracteristicas caracteristicas = new Caracteristicas(velocidad, fuerza, resistencia, destreza);
					Heroe heroe = new Heroe(nombreReal, nombreFicticio, caracteristicas);

					personajes.add(heroe);
				} else if((datos[0].equals("Villano"))) {
					String nombreReal = datos[1];
					String nombreFicticio = datos[2];
					double velocidad = Double.parseDouble(datos[3]);
					double fuerza = Double.parseDouble(datos[4]);
					double resistencia = Double.parseDouble(datos[5]);
					double destreza = Double.parseDouble(datos[6]);

					Caracteristicas caracteristicas = new Caracteristicas(velocidad, fuerza, resistencia, destreza);
					Villano villano = new Villano(nombreReal, nombreFicticio, caracteristicas);

					personajes.add(villano);
				}
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return personajes;
	}
}
