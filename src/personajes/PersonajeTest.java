package personajes;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class PersonajeTest {
    private Personaje heroe;
    private Personaje villano;
    private Caracteristicas caracteristicasHeroe;
    private Caracteristicas caracteristicasVillano;

    @Before
    public void setUp() {
        caracteristicasHeroe = new Caracteristicas(10, 20, 30, 40);
        heroe = new Personaje("Heroe", "Bruce Wayne", "Batman", caracteristicasHeroe);

        caracteristicasVillano = new Caracteristicas(15, 25, 35, 45);
        villano = new Personaje("Villano", "Joker", "Joker", caracteristicasVillano);
    }

    @Test
    public void testGetTipo() {
        assertEquals("Heroe", heroe.getTipo());
        assertEquals("Villano", villano.getTipo());
    }

    @Test
    public void testSetTipo() {
        heroe.setTipo("NuevoTipo");
        assertEquals("NuevoTipo", heroe.getTipo());
    }

    @Test
    public void testBuscarMiembroEnPersonajes() {
        ArrayList<Personaje> personajes = new ArrayList<>();
        personajes.add(heroe);
        personajes.add(villano);

        assertEquals(heroe, Personaje.buscarMiembroEnPersonajes(personajes, "Batman"));
        assertEquals(villano, Personaje.buscarMiembroEnPersonajes(personajes, "Joker"));
        assertNull(Personaje.buscarMiembroEnPersonajes(personajes, "Superman"));
    }

    @Test
    public void testPersonajesQueLoVencen() {
        ArrayList<Personaje> personajesEnMemoria = new ArrayList<>();
        personajesEnMemoria.add(heroe);
        personajesEnMemoria.add(villano);
        
        ArrayList<Personaje> vencedores = heroe.personajesQueLoVencen(personajesEnMemoria, "Fuerza");

        assertEquals(1, vencedores.size());
        assertEquals(villano, vencedores.get(0));
    }
}
