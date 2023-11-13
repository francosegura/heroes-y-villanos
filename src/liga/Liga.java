package liga;

import java.util.ArrayList;
import java.util.List;

import menu.Menu;
import personajes.Caracteristicas;
import personajes.Personaje;
import utils.ConsoleColors;

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
		System.out.println("\n\n\n\n" + ConsoleColors.BLUE_BOLD_BRIGHT + "Bienvenido a la creacion de ligas"
				+ ConsoleColors.RESET);
		System.out.println("\n"
				+ "Primero escribiremos el nombre real. Puede escribirlo a continuacion: ");
		String nombre = Menu.scanner.next();
		Liga nuevaLiga = new Liga(nombre);

		do {
			System.out.println("\n" + "Desea agregar miembros?. Por favor elija "
					+ ConsoleColors.BLUE_BRIGHT + "(1)" + ConsoleColors.RESET + " si desea agregar un miembro, o "
					+ ConsoleColors.BLUE_BRIGHT + "(2)" + ConsoleColors.RESET + " si desea finalizar. ");
			int tipoDePersonaje = Menu.scanner.nextInt();
			if (tipoDePersonaje == 1) {
				// Agregar
			} else if (tipoDePersonaje == 2) {
				// Rebotar
				break;
			} else {
				System.out.println("\n" + ConsoleColors.RED_BRIGHT
						+ "Opcion incorrecta." + ConsoleColors.RESET);
				return null;
			}
		} while (true);
		System.out.println("\n\n" + ConsoleColors.GREEN_BRIGHT
				+ "Felicidades! Su liga fue creada de la siguiente manera: \n" + ConsoleColors.RESET);
		System.out
				.println(nuevaLiga);
		return nuevaLiga;
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
