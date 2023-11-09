package personajes;

public abstract class Personaje {
	private String nombreReal;
	private String nombreFicticio;
	private Caracteristicas caracteristicas;

	public Personaje(String tipo, String nombreReal, String nombreFicticio, Caracteristicas caracteristicas) {
		this.nombreReal = nombreReal;
		this.nombreFicticio = nombreFicticio;
		this.caracteristicas = caracteristicas;
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
}