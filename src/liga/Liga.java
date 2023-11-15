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

	public List<Object> getMiembros() {
		return miembros;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Object agregarMiembro(String nuevoMiembro, ArrayList<Liga> ligasPrecargadas,
			ArrayList<Personaje> personajesPrecargados) {
		Liga miembroComoLiga = buscarMiembroEnLigas(ligasPrecargadas, nuevoMiembro);
		Personaje miembroComoPersonaje = Personaje.buscarMiembroEnPersonajes(personajesPrecargados, nuevoMiembro);

		// Me fijo si el miembro que quiero agregar existe
		if (miembroComoLiga == null && miembroComoPersonaje == null) {
			return null;
		}

		// Me fijo si el nuevo miembro es un personaje
		if (miembroComoPersonaje != null) {
			// Me fijo si el nuevo miembro es del mismo tipo que la liga y lo agrego
			if (this.tipo.length() == 0 || miembroComoPersonaje.getTipo().contains(this.tipo)) {
				this.miembros.add(miembroComoPersonaje);
				this.acumularCaracteristicas(miembroComoPersonaje.getCaracteristicas());
				this.setTipo(miembroComoPersonaje.getTipo());
				return miembroComoPersonaje;
			}
		}

		// Lo mismo pero tratandolo como liga
		if (miembroComoLiga != null) {
			if (this.tipo.length() == 0 || miembroComoLiga.getTipo().contains(this.tipo)) {
				this.miembros.add(miembroComoLiga);
				this.acumularCaracteristicas(miembroComoLiga.getSumatoriaCaracteristicas());
				this.setTipo(miembroComoLiga.getTipo());
				return miembroComoLiga;
			}
		}
		if (miembroComoLiga != null) {
			return miembroComoLiga;
		} else {
			return miembroComoPersonaje;
		}
	}

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
		if (this.miembros.size() > 0) {
			return ConsoleColors.BLUE + nombre + miembrosImprimibles + "\nCaracteristicas: \n"
					+ this.calcularPromedioCaracteristica()
					+ "\n\nTipo: " + this.tipo + ConsoleColors.RESET;
		}
		return ConsoleColors.BLUE + nombre + ": Esta liga no tiene miembros aun" + ConsoleColors.RESET;
	}

	public static Liga crearLiga(ArrayList<Liga> ligasPrecargadas, ArrayList<Personaje> personajesPrecargados) {
		System.out.println("\n\n\n\n" + ConsoleColors.BLUE_BOLD_BRIGHT + "Bienvenido a la creacion de ligas"
				+ ConsoleColors.RESET);
		System.out.println("\n"
				+ "Primero escribiremos el nombre de la liga. Puede escribirlo a continuacion: ");
		String nombre = Menu.scanner.next();
		Liga nuevaLiga = new Liga(nombre);

		do {
			System.out.println("\n" + "Desea agregar miembros?. Por favor elija "
					+ ConsoleColors.BLUE_BRIGHT + "(1)" + ConsoleColors.RESET + " si desea agregar un miembro, o "
					+ ConsoleColors.BLUE_BRIGHT + "(2)" + ConsoleColors.RESET + " si desea finalizar. ");
			int tipoDePersonaje = Menu.scanner.nextInt();
			if (tipoDePersonaje == 1) {
				System.out.println("\n"
						+ "Escriba el nombre del miembro nuevo. Recuerde que ya tiene que existir en la base: ");
				String nombrePersonaje = Menu.scanner.next();
				Object miembroAAgregar = nuevaLiga.agregarMiembro(nombrePersonaje, ligasPrecargadas,
						personajesPrecargados);
				if (miembroAAgregar != null) {
					System.out.println("\n"
							+ "Miembro agregado con exito!");
				} else {
					System.out.println("\n"
							+ "No pudimos agregarlo ya que el miembro no existe, o no pertenece al mismo tipo de la liga (Villanos o heroes).. :( ");
				}
			} else if (tipoDePersonaje == 2) {
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
			if (miembroABuscar.trim().toLowerCase().contains(liga.nombre.trim().toLowerCase())) {
				return liga;
			}
		}
		return null;
	}
}
