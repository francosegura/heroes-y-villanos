package batalla;

import liga.Liga;
import personajes.Personaje;

public class Batalla {

	// NO PUEDEN SER DEL MISMO TIPO, TIENEN Q SER SI O SI HEROES VS VILLANOS
	// YA SEA LIGAS O PERSONAJES
	// personaje vs personaje
	public static Personaje determinarGanador1v1(Personaje personaje1, Personaje personaje2, String caracteristica) {
		String[] orden = { "Velocidad", "Fuerza", "Resistencia", "Destreza" };

		// Determinar el indice de la caracteristica actual
		int i = -1;
		for (int j = 0; j < orden.length; j++) {
			if (caracteristica.equals(orden[j])) {
				i = j;
				break;
			}
		}

		if (i == -1) {
			throw new IllegalArgumentException("Caracteristica no valida");
		}

		// Comparar las caracteristicas de los personajes en el orden establecido
		for (int k = 0; k < orden.length; k++) {
			double caracteristica1 = personaje1.getCaracteristicas().getCaracteristica(orden[i]);
			double caracteristica2 = personaje2.getCaracteristicas().getCaracteristica(orden[i]);

			if (caracteristica1 > caracteristica2) {
				return personaje1;
			} else if (caracteristica2 > caracteristica1) {
				return personaje2;
			}

			// Si hay empate, pasa a la siguiente caracteristica
			i = (i + 1) % orden.length;
		}
		return null;
	}

	// personaje vs liga
	public static Object determinarGanador1vN(Personaje personaje, Liga liga, String caracteristica) {
		String[] orden = { "Velocidad", "Fuerza", "Resistencia", "Destreza" };

		// Determinar el indice de la caracteristica actual
		int i = -1;
		for (int j = 0; j < orden.length; j++) {
			if (caracteristica.equals(orden[j])) {
				i = j;
				break;
			}
		}

		if (i == -1) {
			throw new IllegalArgumentException("Caracteristica no valida");
		}

		// Comparar las caracteristicas de los personajes en el orden establecido
		for (int k = 0; k < orden.length; k++) {
			double caracteristica1 = personaje.getCaracteristicas().getCaracteristica(orden[i]);
			double caracteristica2 = Math.floor(liga.calcularPromedioCaracteristica().getCaracteristica(orden[i]));

			if (caracteristica1 > caracteristica2) {
				return personaje;
			} else if (caracteristica2 > caracteristica1) {
				return liga;
			}

			// Si hay empate, pasa a la siguiente caracteristica
			i = (i + 1) % orden.length;
		}
		return null;
	}

	// liga vs liga
	public static Liga determinarGanadorNvN(Liga liga1, Liga liga2, String caracteristica) {
		String[] orden = { "Velocidad", "Fuerza", "Resistencia", "Destreza" };

		// Determinar el indice de la caracteristica actual
		int i = -1;
		for (int j = 0; j < orden.length; j++) {
			if (caracteristica.equals(orden[j])) {
				i = j;
				break;
			}
		}

		if (i == -1) {
			throw new IllegalArgumentException("Caracteristica no valida");
		}

		// Comparar las caracteristicas de los personajes en el orden establecido
		for (int k = 0; k < orden.length; k++) {
			double caracteristica1 = liga1.calcularPromedioCaracteristica().getCaracteristica(orden[i]);
			double caracteristica2 = liga2.calcularPromedioCaracteristica().getCaracteristica(orden[i]);

			if (caracteristica1 > caracteristica2) {
				return liga1;
			} else if (caracteristica2 > caracteristica1) {
				return liga2;
			}

			// Si hay empate, pasa a la siguiente caracteristica
			i = (i + 1) % orden.length;
		}
		return null;
	}
}
