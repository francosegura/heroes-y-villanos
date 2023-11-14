package reportes;
import org.junit.Before;
import org.junit.Test;

import personajes.Caracteristicas;
import personajes.Personaje;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ReportesTest {

    private ArrayList<Personaje> personajesCargados;

    @Before
    public void setUp() {
        personajesCargados = new ArrayList<>();
    }

    @Test
    public void testOrdenarPorCaracteristicas() {
        Personaje batman = new Personaje("Heroe", "Bruce Wayne", "Batman", new Caracteristicas(10, 20, 30, 40));
        Personaje joker = new Personaje("Villano", "Joker", "Joker", new Caracteristicas(15, 25, 30, 45));
        personajesCargados.add(batman);
        personajesCargados.add(joker);

        Reportes.ordenarPorCaracteristicas(personajesCargados, "Velocidad");
        assertTrue(personajesCargados.indexOf(joker) < personajesCargados.indexOf(batman));
        
        Reportes.ordenarPorCaracteristicas(personajesCargados, "Destreza");
        assertTrue(personajesCargados.indexOf(joker) < personajesCargados.indexOf(batman));
        
        Reportes.ordenarPorCaracteristicas(personajesCargados, "Fuerza");
        assertTrue(personajesCargados.indexOf(joker) < personajesCargados.indexOf(batman));
        
        Reportes.ordenarPorCaracteristicas(personajesCargados, "Resistencia");
        assertFalse(personajesCargados.indexOf(joker) > personajesCargados.indexOf(batman));
    }
}
