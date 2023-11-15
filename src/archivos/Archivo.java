package archivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import liga.Liga;
import personajes.Caracteristicas;
import personajes.Personaje;
import utils.Tipos;

public class Archivo {
	public static ArrayList<Personaje> cargarPersonajesDesdeArchivo(String file) {
		ArrayList<Personaje> personajes = new ArrayList<Personaje>();
		String nombreArchivo = new File(file).getAbsolutePath();
		try {
			Scanner scanner = new Scanner(new File(nombreArchivo));

			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				String[] datos = linea.split(", ");
				if (datos[0].equals(Tipos.HEROE) || datos[0].equals(Tipos.VILLANO)) {
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

	public static void guardarPersonajesEnArchivo(String file, ArrayList<Personaje> personajes) {
		String nombreArchivo = new File(file).getAbsolutePath();
		 try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
			writer.write("Heroe/Villano, NombreReal, NombrePersonaje, Velocidad, Fuerza, Resistencia, Destreza");
			writer.newLine();
            for (Personaje personaje : personajes) {
				// Heroe, Edward Blake, The Comedian, 100, 200, 150, 50
                writer.write(personaje.getTipo() + ", ");
                writer.write(personaje.getNombreReal() + ", ");
                writer.write(personaje.getNombreFicticio() + ", ");
                writer.write(Double.toString(personaje.getCaracteristicas().getVelocidad()) + ", ");
                writer.write(Double.toString(personaje.getCaracteristicas().getFuerza()) + ", ");
                writer.write(Double.toString(personaje.getCaracteristicas().getResistencia()) + ", ");
                writer.write(Double.toString(personaje.getCaracteristicas().getDestreza()));
                writer.newLine();
            }
            System.out.println("Personajes guardados correctamente en el archivo " + file);
        } catch (IOException e) {
            e.printStackTrace();
        }
	} 

	public static ArrayList<Liga> cargarLigasDesdeArchivo(String file, ArrayList<Liga> ligasPrecargadas,
			ArrayList<Personaje> personajesPrecargados) {
		ArrayList<Liga> ligas = new ArrayList<Liga>(ligasPrecargadas);
		String nombreArchivo = new File(file).getAbsolutePath();
		try {
			Scanner scanner = new Scanner(new File(nombreArchivo));

			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				String[] datos = linea.split(", ");
				Liga liga = new Liga(datos[0]);
				for(int i = 1; i < datos.length ; i++) {
					liga.agregarMiembro(datos[i], ligas, personajesPrecargados);
				}
				ligas.add(liga);
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return ligas;
	}

	public static void guardarLigasEnArchivo(String file, ArrayList<Liga> ligas) {
		String nombreArchivo = new File(file).getAbsolutePath();
		 try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Liga liga : ligas) {
				// Midnight Sons, Dr Strange, Ghost Rider, Dr Vadoo
                writer.write(liga.getNombre());
				if(liga.getMiembros().size() > 0) {
					for (Object miembro : liga.getMiembros()) {
						if(miembro instanceof Personaje) {
							writer.write(", " + ((Personaje)miembro).getNombreFicticio());
						}
						if(miembro instanceof Liga) {
							writer.write(", " + ((Liga)miembro).getNombre());
						}
					}
				}
                writer.newLine();
            }
            System.out.println("Ligas guardadas correctamente en el archivo " + file);
        } catch (IOException e) {
            e.printStackTrace();
        }
	} 

}
