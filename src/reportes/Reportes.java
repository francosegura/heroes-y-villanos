package reportes;

import java.util.ArrayList;
import java.util.Collections;

import personajes.ComparadorDePersonajePorCaracteristica;
import personajes.Personaje;

public class Reportes {
	
	public static void personajesVencedoresPorCaracteristica(ArrayList<Personaje> personajesCargados,
			String nombrePersonaje, String caracteristica) {

		Personaje personajeIngresado = Personaje.buscarMiembroEnPersonajes(personajesCargados, nombrePersonaje);

		if (personajeIngresado == null) {
			throw new IllegalArgumentException("El personaje no fue encontrado.");
		}

		ArrayList<Personaje> vencedores = personajeIngresado.personajesQueLoVencen(personajesCargados, caracteristica);

		if (vencedores == null || vencedores.isEmpty()) {
			System.out.println("El personaje " + personajeIngresado.getNombreFicticio()
					+ " no es vencido por ningun otro personaje por la característica " + caracteristica);
		} else {
			System.out.println("El o los personajes que vencen a " + personajeIngresado.getNombreFicticio() + " en "
					+ caracteristica + " son: \n");

			for (Personaje vencedor : vencedores) {
				System.out.println(vencedor.getNombreFicticio()+"\n"+vencedor.getCaracteristicas()+"\n");
			}
		}
		    	  
  }
	
	public static void ordenarPorCaracteristicas(ArrayList<Personaje>personajesCargados,String... caracteristicas) {
		
		ArrayList<Personaje> personajesOrdenados = personajesCargados;
		
		Collections.sort(personajesOrdenados,new ComparadorDePersonajePorCaracteristica(caracteristicas));
		
		System.out.println("Personajes ordenados: ");
		
		for (Personaje personaje:personajesOrdenados)
		{
			System.out.println(personaje);
		}
	}
    
}