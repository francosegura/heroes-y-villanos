package personajes;

import static org.junit.Assert.*;
import org.junit.Test;

import utils.Tipos;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparadorDePersonajePorCaracteristicaTest {

    @Test
    public void testCompararPorVelocidad() {
        Personaje p1 = new Personaje(Tipos.HEROE, "Bruce Wayne", "Batman", new Caracteristicas(10, 20, 30, 40));
        Personaje p2 = new Personaje(Tipos.HEROE, "Clark Kent", "Superman", new Caracteristicas(15, 25, 35, 45));

        ComparadorDePersonajePorCaracteristica comparador = new ComparadorDePersonajePorCaracteristica("velocidad");
        int resultado = comparador.compare(p1, p2);

        assertTrue(resultado > 0);
    }

    @Test
    public void testCompararPorFuerza() {
        Personaje p1 = new Personaje(Tipos.HEROE, "Bruce Wayne", "Batman", new Caracteristicas(10, 20, 30, 40));
        Personaje p2 = new Personaje(Tipos.HEROE, "Clark Kent", "Superman", new Caracteristicas(15, 25, 35, 45));

        ComparadorDePersonajePorCaracteristica comparador = new ComparadorDePersonajePorCaracteristica("fuerza");
        int resultado = comparador.compare(p1, p2);

        assertTrue(resultado > 0);
    }

    @Test
    public void testCompararPorResistencia() {
        Personaje p1 = new Personaje(Tipos.HEROE, "Bruce Wayne", "Batman", new Caracteristicas(10, 20, 30, 40));
        Personaje p2 = new Personaje(Tipos.HEROE, "Clark Kent", "Superman", new Caracteristicas(15, 25, 35, 45));

        ComparadorDePersonajePorCaracteristica comparador = new ComparadorDePersonajePorCaracteristica("resistencia");
        int resultado = comparador.compare(p2, p1);

        assertTrue(resultado < 0);
    }

    @Test
    public void testCompararPorDestreza() {
        Personaje p1 = new Personaje(Tipos.HEROE, "Bruce Wayne", "Batman", new Caracteristicas(10, 20, 30, 40));
        Personaje p2 = new Personaje(Tipos.HEROE, "Clark Kent", "Superman", new Caracteristicas(15, 25, 35, 45));

        ComparadorDePersonajePorCaracteristica comparador = new ComparadorDePersonajePorCaracteristica("destreza");
        int resultado = comparador.compare(p1, p2);

        assertTrue(resultado > 0);
    }

    @Test
    public void testCompararPorVariasCaracteristicas() {
        Personaje p1 = new Personaje(Tipos.HEROE, "Bruce Wayne", "Batman", new Caracteristicas(10, 20, 30, 40));
        Personaje p2 = new Personaje(Tipos.HEROE, "Clark Kent", "Superman", new Caracteristicas(15, 25, 35, 45));

        ComparadorDePersonajePorCaracteristica comparador = new ComparadorDePersonajePorCaracteristica("velocidad", "fuerza", "resistencia");
        int resultado = comparador.compare(p1, p2);

        assertTrue(resultado > 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCompararConCaracteristicaInvalida() {
        Personaje p1 = new Personaje(Tipos.HEROE, "Bruce Wayne", "Batman", new Caracteristicas(10, 20, 30, 40));
        Personaje p2 = new Personaje(Tipos.HEROE, "Clark Kent", "Superman", new Caracteristicas(15, 25, 35, 45));

        ComparadorDePersonajePorCaracteristica comparador = new ComparadorDePersonajePorCaracteristica("poderEspecial");
        comparador.compare(p1, p2);
    }

    @Test
    public void testOrdenarListaDePersonajes() {
        Personaje p1 = new Personaje(Tipos.HEROE, "Bruce Wayne", "Batman", new Caracteristicas(10, 20, 30, 40));
        Personaje p2 = new Personaje(Tipos.HEROE, "Clark Kent", "Superman", new Caracteristicas(15, 25, 35, 45));
        Personaje p3 = new Personaje(Tipos.HEROE, "Diana Prince", "Wonder Woman", new Caracteristicas(12, 22, 32, 42));

        List<Personaje> listaPersonajes = Arrays.asList(p1, p2, p3);
        Collections.sort(listaPersonajes, new ComparadorDePersonajePorCaracteristica("velocidad", "fuerza", "resistencia"));

        assertEquals(p2.getNombreFicticio(), listaPersonajes.get(0).getNombreFicticio());
        assertEquals(p3.getNombreReal(), listaPersonajes.get(1).getNombreReal());
    }
}

