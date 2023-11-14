package personajes;

import java.util.Comparator;

public class ComparadorDePersonajePorCaracteristica implements Comparator<Personaje> {
	private String[] caracteristicas;

	public ComparadorDePersonajePorCaracteristica(String... caracteristicas) {
	    this.caracteristicas = caracteristicas;
	}
	@Override
	public int compare(Personaje p1, Personaje p2) {
		for (String caracteristica : caracteristicas) {
            int comparacion = compararPorCaracteristica(p1, p2, caracteristica);
            if (comparacion != 0) {
                return comparacion;
            }
        }
        return 0;
	}
	
	private int compararPorCaracteristica (Personaje p1, Personaje p2, String caracteristica)
	{
		 switch (caracteristica.toLowerCase()) {
         case "velocidad":
             return Double.compare(p2.getCaracteristicas().getVelocidad(), p1.getCaracteristicas().getVelocidad());
         case "fuerza":
             return Double.compare(p2.getCaracteristicas().getFuerza(), p1.getCaracteristicas().getFuerza());
         case "resistencia":
             return Double.compare(p2.getCaracteristicas().getResistencia(), p1.getCaracteristicas().getResistencia());
         case "destreza":
             return Double.compare(p2.getCaracteristicas().getDestreza(), p1.getCaracteristicas().getDestreza());
         default:
             throw new IllegalArgumentException("Característica no válida: " + caracteristica);
	}
	}

}
