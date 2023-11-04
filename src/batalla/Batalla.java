package batalla;

import liga.Liga;
import personajes.Personaje;

public class Batalla {

	public static Personaje determinarGanador1v1(Personaje personaje1, Personaje personaje2, String caracteristica) {
		String[] orden = { "Velocidad", "Fuerza", "Resistencia", "Destreza" };

		// Determinar el índice de la característica actual
		int i = -1;
		for (int j = 0; j < orden.length; j++) {
			if (caracteristica.equals(orden[j])) {
				i = j;
				break; // Ver como resolver de otra forma
			}
		}

		if (i == -1) {
			throw new IllegalArgumentException("Característica no válida");
		}

		// Comparar las características de los personajes en el orden establecido
		for (int k = 0; k < orden.length; k++) {
			double caracteristica1 = personaje1.getCaracteristicas().getCaracteristica(orden[i]);
			double caracteristica2 = personaje2.getCaracteristicas().getCaracteristica(orden[i]);

			if (caracteristica1 > caracteristica2) {
				return personaje1;
			} else if (caracteristica2 > caracteristica1) {
				return personaje2;
			}

			// Si hay empate, pasa a la siguiente característica
			i = (i + 1) % orden.length;
		}
		return null;
	}
	
	public static Object determinarGanador1vN(Personaje personaje, Liga liga, String caracteristica) {
		if("Velocidad" == caracteristica)
			return personaje;
		else
			return liga;
	}
	
	public static Liga determinarGanadorNvN(Liga liga1, Liga liga2, String caracteristica) {
		return liga1;
	}
}
