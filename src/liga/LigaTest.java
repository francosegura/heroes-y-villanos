package liga;

import static org.junit.Assert.*;
import org.junit.Test;

import personajes.Caracteristicas;
import personajes.Personaje;

import java.util.ArrayList;
import java.util.List;

public class LigaTest {

    @Test
    public void testAgregarMiembro() {
        Liga liga = new Liga("Justice League");
        ArrayList<Liga> ligasPrecargadas = new ArrayList<>();
        ArrayList<Personaje> personajesPrecargados = new ArrayList<>();

        // Crear personaje y agregarlo a la liga
        Caracteristicas caracteristicasHeroe = new Caracteristicas(10, 20, 30, 40);
        Personaje heroe = new Personaje("Heroe", "Bruce Wayne", "Batman", caracteristicasHeroe);
        personajesPrecargados.add(heroe);

        assertEquals(heroe, liga.agregarMiembro("Batman", ligasPrecargadas, personajesPrecargados));

        // Crear liga y agregarla a la liga
        Liga ligaAmiga = new Liga("Avengers");
        ligasPrecargadas.add(ligaAmiga);

        assertEquals(ligaAmiga, liga.agregarMiembro("Avengers", ligasPrecargadas, personajesPrecargados));

        // Intentar agregar un miembro inexistente
        assertNull(liga.agregarMiembro("Spiderman", ligasPrecargadas, personajesPrecargados));

        // Intentar agregar un miembro de tipo diferente
        Personaje villano = new Personaje("Villano", "Joker", "Joker", caracteristicasHeroe);
        personajesPrecargados.add(villano);

        //assertFail(liga.agregarMiembro("Joker", ligasPrecargadas, personajesPrecargados));
    }

    @Test
    public void testCalcularPromedioCaracteristica() {
        Liga liga = new Liga("Justice League");

        Caracteristicas caracteristicasHeroe1 = new Caracteristicas(10, 20, 30, 40);
        Personaje heroe1 = new Personaje("Heroe", "Bruce Wayne", "Batman", caracteristicasHeroe1);

        Caracteristicas caracteristicasHeroe2 = new Caracteristicas(15, 25, 35, 45);
        Personaje heroe2 = new Personaje("Heroe", "Clark Kent", "Superman", caracteristicasHeroe2);

        liga.agregarMiembro("Batman", new ArrayList<>(), new ArrayList<>(List.of(heroe1, heroe2)));

        // Calcular promedio de características
        Caracteristicas promedio = liga.calcularPromedioCaracteristica();

        assertEquals(10.0, promedio.getVelocidad(), 0.01);
        assertEquals(20, promedio.getFuerza(), 0.01);
        assertEquals(30, promedio.getResistencia(), 0.01);
        assertEquals(40, promedio.getDestreza(), 0.01);
    }

    @Test
    public void testBuscarMiembroEnLigas() {
        ArrayList<Liga> ligas = new ArrayList<>();

        Liga liga1 = new Liga("Justice League");
        ligas.add(liga1);

        Liga liga2 = new Liga("Avengers");
        ligas.add(liga2);

        assertEquals(liga1, Liga.buscarMiembroEnLigas(ligas, "Justice League"));

        assertNull(Liga.buscarMiembroEnLigas(ligas, "X-Men"));

        assertEquals(liga1, Liga.buscarMiembroEnLigas(ligas, "justice league "));
    }
}
