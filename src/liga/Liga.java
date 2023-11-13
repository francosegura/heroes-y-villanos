package liga;

import java.util.ArrayList;
import java.util.List;

import personajes.Caracteristicas;
import personajes.Personaje;

public class Liga {
	private String nombre;
	private List<Object> miembros;
	private String tipo = "";
	private Caracteristicas sumatoriaCaracteristicas = new Caracteristicas(0, 0, 0, 0);

	public Liga(String nombre) {
		this.nombre = nombre;
		this.miembros = new ArrayList<Object>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void agregarMiembro(String nuevoMiembro, ArrayList<Liga> ligasPrecargadas,
			ArrayList<Personaje> personajesPrecargados) {
		Liga miembroComoLiga = buscarMiembroEnLigas(ligasPrecargadas, nuevoMiembro);
		Personaje miembroComoPersonaje = Personaje.buscarMiembroEnPersonajes(personajesPrecargados, nuevoMiembro);

		// Me fijo si el miembro que quiero agregar existe
		if (miembroComoLiga == null && miembroComoPersonaje == null) {
			return;
		}

		// Me fijo si el nuevo miembro es un personaje
		if (miembroComoPersonaje != null) {
			// Me fijo si el nuevo miembro es del mismo tipo que la liga y lo agrego
			if (this.tipo.length() == 0 || miembroComoPersonaje.getTipo().contains(this.tipo)) {
				this.miembros.add(miembroComoPersonaje);
				this.acumularCaracteristicas(miembroComoPersonaje.getCaracteristicas());
				this.setTipo(miembroComoPersonaje.getTipo());
			}
		}

		// Lo mismo pero tratandolo como liga
		if (miembroComoLiga != null) {
			if (this.tipo.length() == 0 || miembroComoLiga.getTipo().contains(this.tipo)) {
				this.miembros.add(miembroComoLiga);
				this.acumularCaracteristicas(miembroComoLiga.getSumatoriaCaracteristicas());
				this.setTipo(miembroComoLiga.getTipo());
			}
		}

	}
	//
	// public boolean agregarCompetidor(Personaje competidor) {
	// miembros.add(competidor);
	// return false;
	// }

	public Caracteristicas calcularPromedioCaracteristica() {
		int cantidadPersonajes = this.miembros.size();
		if (cantidadPersonajes == 0)
			return null;
		Caracteristicas promedioCaracteristicas = new Caracteristicas(0, 0, 0, 0);

		promedioCaracteristicas.setDestreza(this.sumatoriaCaracteristicas.getDestreza() / cantidadPersonajes);
		promedioCaracteristicas.setFuerza(this.sumatoriaCaracteristicas.getFuerza() / cantidadPersonajes);
		promedioCaracteristicas.setResistencia(this.sumatoriaCaracteristicas.getResistencia() / cantidadPersonajes);
		promedioCaracteristicas.setVelocidad(this.sumatoriaCaracteristicas.getVelocidad() / cantidadPersonajes);

		return promedioCaracteristicas;
	}

	@Override
	public String toString() {
		String miembrosImprimibles = "\n\nMiembros: \n";
		for (Object miembro : this.miembros) {
			if (miembro instanceof Liga) {
				miembrosImprimibles = miembrosImprimibles.concat(((Liga) miembro).getNombre() + "\n");
			} else {
				miembrosImprimibles = miembrosImprimibles
						.concat(((Personaje) miembro).getNombreFicticio() + "\n");
			}
		}
		return nombre + miembrosImprimibles + "\n\nCaracteristicas: \n" + this.getSumatoriaCaracteristicas()
				+ "\n\nTipo: " + this.tipo;
	}

	public static Liga crearLiga(ArrayList<Liga> ligasPrecargadas, ArrayList<Personaje> personajesPrecargados) {
		return null;
	}

	public String getTipo() {
		return tipo;
	}

	private void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Caracteristicas getSumatoriaCaracteristicas() {
		return sumatoriaCaracteristicas;
	}

	public void acumularCaracteristicas(Caracteristicas nuevas) {
		this.sumatoriaCaracteristicas.setDestreza(this.sumatoriaCaracteristicas.getDestreza() + nuevas.getDestreza());
		this.sumatoriaCaracteristicas.setFuerza(this.sumatoriaCaracteristicas.getFuerza() + nuevas.getFuerza());
		this.sumatoriaCaracteristicas
				.setResistencia(this.sumatoriaCaracteristicas.getResistencia() + nuevas.getResistencia());
		this.sumatoriaCaracteristicas
				.setVelocidad(this.sumatoriaCaracteristicas.getVelocidad() + nuevas.getVelocidad());
	}

	public static Liga buscarMiembroEnLigas(ArrayList<Liga> ligas, String miembroABuscar) {
		for (Liga liga : ligas) {
			if (liga.nombre.trim().toLowerCase().contains(miembroABuscar.trim().toLowerCase())) {
				return liga;
			}
		}
		return null;
	}
}
