package archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import liga.Liga;
import personajes.Caracteristicas;
import personajes.Heroe;
import personajes.Villano;

public class Archivos {
    public static Liga cargarLigasDesdeArchivo(String nombreArchivo) {
        Liga ligaPrincipal = new Liga("Liga Principal");

        try {
            Scanner scanner = new Scanner(new File(nombreArchivo));

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] datos = linea.split(", ");

                if (datos[0].equals("Liga")) {//VER BIEN COMO PARSEAR LAS LIGAS
                    Liga subLiga = cargarLigasDesdeArchivo(datos[1] + ".in");
                    ligaPrincipal.agregarMiembro(subLiga);
                } else if (datos[0].equals("Heroe")) {
                    String nombreReal = datos[1];
                    String nombreFicticio = datos[2];
                    double velocidad = Double.parseDouble(datos[3]);
                    double fuerza = Double.parseDouble(datos[4]);
                    double resistencia = Double.parseDouble(datos[5]);
                    double destreza = Double.parseDouble(datos[6]);

                    Caracteristicas caracteristicas = new Caracteristicas(velocidad, fuerza, resistencia, destreza);
                    Heroe heroe = new Heroe(nombreReal, nombreFicticio, caracteristicas);

                    ligaPrincipal.agregarMiembro(heroe);
                } else if (datos[0].equals("Villano")) {
                    String nombreReal = datos[1];
                    String nombreFicticio = datos[2];
                    double velocidad = Double.parseDouble(datos[3]);
                    double fuerza = Double.parseDouble(datos[4]);
                    double resistencia = Double.parseDouble(datos[5]);
                    double destreza = Double.parseDouble(datos[6]);

                    Caracteristicas caracteristicas = new Caracteristicas(velocidad, fuerza, resistencia, destreza);
                    Villano villano = new Villano(nombreReal, nombreFicticio, caracteristicas);

                    ligaPrincipal.agregarMiembro(villano);
                }
            }
            
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return ligaPrincipal;
    }
}
