package personajes;

public class Personaje {
	private String nombreReal;
	private String nombreFicticio;
	private String tipo;
	private Caracteristicas caracteristicas;

	public Personaje(String tipo, String nombreReal, String nombreFicticio, Caracteristicas caracteristicas) {
		this.nombreReal = nombreReal;
		this.nombreFicticio = nombreFicticio;
		this.caracteristicas = caracteristicas;
		this.tipo= tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombreReal() {
		return nombreReal;
	}

	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
	}

	public String getNombreFicticio() {
		return nombreFicticio;
	}

	public void setNombreFicticio(String nombreFicticio) {
		this.nombreFicticio = nombreFicticio;
	}

	public Caracteristicas getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(Caracteristicas caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public enum Tipos {
		Heroe, Villano
	}

	@Override
	public String toString() {
		return this.tipo + "\t\t" + this.nombreReal + "\t" + this.nombreFicticio + "\t"
				+ this.caracteristicas.getVelocidad() + "\t\t" + this.caracteristicas.getFuerza() + "\t"
				+ this.caracteristicas.getResistencia() + "\t\t" + this.caracteristicas.getDestreza();
	}
}