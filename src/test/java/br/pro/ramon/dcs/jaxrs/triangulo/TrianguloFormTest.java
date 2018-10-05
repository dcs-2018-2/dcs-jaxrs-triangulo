package br.pro.ramon.dcs.jaxrs.triangulo;

import com.machinepublishers.jbrowserdriver.JBrowserDriver;
import java.io.IOException;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebElement;

public class TrianguloFormTest {

    @Test
    public void testNaoEhTrianguloPeloLado1() throws IOException {
        String l1 = "100";
        String l2 = "20";
        String l3 = "30";

        RespostaTriangulo resposta = usaFormQueFazChamadaAjax(l1, l2, l3);

        assertThat(resposta.triangulo, is("Não"));
        assertThat(resposta.tipo, is(""));
    }

    @Test
    public void testNaoEhTrianguloPeloLado2() throws IOException {
        String l1 = "10";
        String l2 = "200";
        String l3 = "30";

        RespostaTriangulo resposta = usaFormQueFazChamadaAjax(l1, l2, l3);

        assertThat(resposta.triangulo, is("Não"));
        assertThat(resposta.tipo, is(""));
    }

    @Test
    public void testNaoEhTrianguloPeloLado3() throws IOException {
        String l1 = "10";
        String l2 = "20";
        String l3 = "300";

        RespostaTriangulo resposta = usaFormQueFazChamadaAjax(l1, l2, l3);

        assertThat(resposta.triangulo, is("Não"));
        assertThat(resposta.tipo, is(""));
    }

    @Test
    public void testTrianguloEquilatero() throws IOException {
        String l1 = "10";
        String l2 = "10";
        String l3 = "10";

        RespostaTriangulo resposta = usaFormQueFazChamadaAjax(l1, l2, l3);

        assertThat(resposta.triangulo, is("Sim"));
        assertThat(resposta.tipo, is("equilátero"));
    }

    @Test
    public void testTrianguloEscaleno() throws IOException {
        String l1 = "30";
        String l2 = "40";
        String l3 = "50";

        RespostaTriangulo resposta = usaFormQueFazChamadaAjax(l1, l2, l3);

        assertThat(resposta.triangulo, is("Sim"));
        assertThat(resposta.tipo, is("escaleno"));
    }

    @Test
    public void testTrianguloIsoscelesPeloLado1() throws IOException {
        String l1 = "10";
        String l2 = "20";
        String l3 = "20";

        RespostaTriangulo resposta = usaFormQueFazChamadaAjax(l1, l2, l3);

        assertThat(resposta.triangulo, is("Sim"));
        assertThat(resposta.tipo, is("isósceles"));
    }

    @Test
    public void testTrianguloIsoscelesPeloLado2() throws IOException {
        String l1 = "20";
        String l2 = "10";
        String l3 = "20";

        RespostaTriangulo resposta = usaFormQueFazChamadaAjax(l1, l2, l3);

        assertThat(resposta.triangulo, is("Sim"));
        assertThat(resposta.tipo, is("isósceles"));
    }

    @Test
    public void testTrianguloIsoscelesPeloLado3() throws IOException {
        String l1 = "20";
        String l2 = "20";
        String l3 = "10";

        RespostaTriangulo resposta = usaFormQueFazChamadaAjax(l1, l2, l3);

        assertThat(resposta.triangulo, is("Sim"));
        assertThat(resposta.tipo, is("isósceles"));
    }

    private RespostaTriangulo usaFormQueFazChamadaAjax(String l1, String l2, String l3) {
        JBrowserDriver driver = new JBrowserDriver();
        driver.get("http://localhost:8084/dcs-jaxrs-triangulo");

        WebElement l1Input = driver.findElementById("lado1");
        l1Input.sendKeys(l1);

        WebElement l2Input = driver.findElementById("lado2");
        l2Input.sendKeys(l2);

        WebElement l3Input = driver.findElementById("lado3");
        l3Input.sendKeys(l3);

        WebElement verificarButton = driver.findElementById("verificar");
        verificarButton.click();

        WebElement trianguloInput = driver.findElementById("triangulo");
        String triangulo = trianguloInput.getAttribute("value");

        WebElement tipoInput = driver.findElementById("tipo");
        String tipo = tipoInput.getAttribute("value");

        return new RespostaTriangulo(triangulo, tipo);
    }
}

class RespostaTriangulo {

    public String triangulo;
    public String tipo;

    public RespostaTriangulo(String triangulo, String tipo) {
        this.triangulo = triangulo;
        this.tipo = tipo == null ? "" : tipo;
    }

}
