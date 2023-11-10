package liga;

import java.util.ArrayList;
import java.util.List;

import personajes.Personaje;

public class Liga {
	private String nombre;
	private List<String> miembros;
	
	public Liga(String nombre) {
		this.nombre = nombre;
		this.miembros = new ArrayList<String>();
	}
		
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void agregarMiembro(String miembro) {
		miembros.add(miembro);
	}// Hacer individualmente o para agregar subligas tambien???
//
//	public boolean agregarCompetidor(Personaje competidor) {
//		miembros.add(competidor);
//		return false;
//	}

	public double calcularPromedioCaracteristica(String caracteristica) {
		double sumaCaracteristica = 0;
		int cantidadPersonajes = 0;

		for (Object miembro : miembros) {
			if (miembro instanceof Liga) {
				Liga subLiga = (Liga) miembro;
				sumaCaracteristica += subLiga.calcularPromedioCaracteristica(caracteristica);
			} else if (miembro instanceof Personaje) {
				Personaje personaje = (Personaje) miembro;
				sumaCaracteristica += personaje.getCaracteristicas().getCaracteristica(caracteristica);
				cantidadPersonajes++;
			}
		}

		if (cantidadPersonajes > 0) {
			return sumaCaracteristica / cantidadPersonajes;
		} else {
			return 0;
		}
	}
	@Override
	public String toString() {
		String miembrosImprimibles = "";
		for (String miembro : this.miembros) {
			miembrosImprimibles  = miembrosImprimibles.concat("\t\t" + miembro);
		}
		return nombre + miembrosImprimibles;
	}
}
