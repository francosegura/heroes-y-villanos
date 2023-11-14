package batalla;

import static org.junit.Assert.*;
import org.junit.Test;

import personajes.Caracteristicas;
import personajes.Personaje;

public class BatallaTest {

    @Test
    public void testDeterminarGanador1v1Velocidad() {
        Caracteristicas caracteristicasHeroe = new Caracteristicas(10, 20, 30, 40);
        Personaje heroe = new Personaje("Heroe", "Bruce Wayne", "Batman", caracteristicasHeroe);

        Caracteristicas caracteristicasVillano = new Caracteristicas(15, 25, 35, 45);
        Personaje villano = new Personaje("Villano", "Joker", "Joker", caracteristicasVillano);
        Personaje ganador = Batalla.determinarGanador1v1(heroe, villano, "Velocidad");
        assertEquals("Joker",ganador.getNombreFicticio());
    }

    @Test
    public void testDeterminarGanador1v1Fuerza() {
        Caracteristicas caracteristicasHeroe = new Caracteristicas(10, 20, 30, 40);
        Personaje heroe = new Personaje("Heroe", "Bruce Wayne", "Batman", caracteristicasHeroe);

        Caracteristicas caracteristicasVillano = new Caracteristicas(15, 25, 35, 45);
        Personaje villano = new Personaje("Villano", "Joker", "Joker", caracteristicasVillano);

        assertEquals(villano, Batalla.determinarGanador1v1(heroe, villano, "Fuerza"));
    }

    @Test
    public void testDeterminarGanador1v1Resistencia() {
        Caracteristicas caracteristicasHeroe = new Caracteristicas(10, 20, 30, 40);
        Personaje heroe = new Personaje("Heroe", "Bruce Wayne", "Batman", caracteristicasHeroe);

        Caracteristicas caracteristicasVillano = new Caracteristicas(15, 25, 35, 45);
        Personaje villano = new Personaje("Villano", "Joker", "Joker", caracteristicasVillano);
        
        Personaje ganador = Batalla.determinarGanador1v1(heroe, villano, "Resistencia");
        assertEquals("Joker",ganador.getNombreFicticio());
    }

    @Test
    public void testDeterminarGanador1v1Destreza() {
        Caracteristicas caracteristicasHeroe = new Caracteristicas(10, 20, 30, 40);
        Personaje heroe = new Personaje("Heroe", "Bruce Wayne", "Batman", caracteristicasHeroe);

        Caracteristicas caracteristicasVillano = new Caracteristicas(15, 25, 35, 35);
        Personaje villano = new Personaje("Villano", "Joker", "Joker", caracteristicasVillano);
        
        Personaje ganador = Batalla.determinarGanador1v1(heroe, villano, "Destreza");
        assertEquals("Batman",ganador.getNombreFicticio());
    }

    @Test
    public void testDeterminarGanador1v1Invalida() {
        Caracteristicas caracteristicasHeroe = new Caracteristicas(10, 20, 30, 40);
        Personaje heroe = new Personaje("Heroe", "Bruce Wayne", "Batman", caracteristicasHeroe);

        Caracteristicas caracteristicasVillano = new Caracteristicas(15, 25, 35, 45);
        Personaje villano = new Personaje("Villano", "Joker", "Joker", caracteristicasVillano);

        try {
            Batalla.determinarGanador1v1(heroe, villano, "CaracteristicaInvalida");
            fail("Se esperaba IllegalArgumentException");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testDeterminarGanador1v1Empate() {
        Caracteristicas caracteristicasHeroe = new Caracteristicas(10, 20, 30, 40);
        Personaje heroe = new Personaje("Heroe", "Bruce Wayne", "Batman", caracteristicasHeroe);

        Caracteristicas caracteristicasVillano = new Caracteristicas(10, 20, 30, 40);
        Personaje villano = new Personaje("Villano", "Joker", "Joker", caracteristicasVillano);

        assertNull(Batalla.determinarGanador1v1(heroe, villano, "Fuerza"));
    }
}
