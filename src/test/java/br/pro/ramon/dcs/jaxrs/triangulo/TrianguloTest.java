package br.pro.ramon.dcs.jaxrs.triangulo;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class TrianguloTest {

    @Test
    public void testNaoEhTrianguloPeloLado1() {
        double l1 = 100;
        double l2 = 20;
        double l3 = 30;

        Triangulo t = new Triangulo(l1, l2, l3);

        assertThat(t.isTriangulo(), is(false));
        assertThat(t.getTipo(), is(""));
    }

    @Test
    public void testNaoEhTrianguloPeloLado2() {
        double l1 = 10;
        double l2 = 200;
        double l3 = 30;

        Triangulo t = new Triangulo(l1, l2, l3);

        assertThat(t.isTriangulo(), is(false));
        assertThat(t.getTipo(), is(""));
    }

    @Test
    public void testNaoEhTrianguloPeloLado3() {
        double l1 = 10;
        double l2 = 20;
        double l3 = 300;

        Triangulo t = new Triangulo(l1, l2, l3);

        assertThat(t.isTriangulo(), is(false));
        assertThat(t.getTipo(), is(""));
    }

    @Test
    public void testTrianguloEquilatero() {
        double l1 = 10;
        double l2 = 10;
        double l3 = 10;

        Triangulo t = new Triangulo(l1, l2, l3);

        assertThat(t.isTriangulo(), is(true));
        assertThat(t.getTipo(), is("equilátero"));
    }

    @Test
    public void testTrianguloEscaleno() {
        double l1 = 30;
        double l2 = 40;
        double l3 = 50;

        Triangulo t = new Triangulo(l1, l2, l3);

        assertThat(t.isTriangulo(), is(true));
        assertThat(t.getTipo(), is("escaleno"));
    }

    @Test
    public void testTrianguloIsoscelesPeloLado1() {
        double l1 = 10;
        double l2 = 20;
        double l3 = 20;

        Triangulo t = new Triangulo(l1, l2, l3);

        assertThat(t.isTriangulo(), is(true));
        assertThat(t.getTipo(), is("isósceles"));
    }

    @Test
    public void testTrianguloIsoscelesPeloLado2() {
        double l1 = 20;
        double l2 = 10;
        double l3 = 20;

        Triangulo t = new Triangulo(l1, l2, l3);

        assertThat(t.isTriangulo(), is(true));
        assertThat(t.getTipo(), is("isósceles"));
    }

    @Test
    public void testTrianguloIsoscelesPeloLado3() {
        double l1 = 20;
        double l2 = 20;
        double l3 = 10;

        Triangulo t = new Triangulo(l1, l2, l3);

        assertThat(t.isTriangulo(), is(true));
        assertThat(t.getTipo(), is("isósceles"));
    }

}
