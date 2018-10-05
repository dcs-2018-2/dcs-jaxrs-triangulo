package br.pro.ramon.dcs.jaxrs.triangulo;

import java.io.IOException;
import static org.hamcrest.CoreMatchers.is;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.junit.Test;
import static org.junit.Assert.*;

public class TrianguloResourceTest {

    @Test
    public void testNaoEhTrianguloPeloLado1() throws IOException {
        double l1 = 100;
        double l2 = 20;
        double l3 = 30;

        RespostaWs resposta = acessaWebService(l1, l2, l3);

        assertThat(resposta.tipo, is("application/json;charset=UTF-8"));
        assertThat(resposta.saida, is("{\"tipo\":\"\",\"triangulo\":false}"));
        assertThat(resposta.statusCode, is(404));
    }

    @Test
    public void testNaoEhTrianguloPeloLado2() throws IOException {
        double l1 = 10;
        double l2 = 200;
        double l3 = 30;

        RespostaWs resposta = acessaWebService(l1, l2, l3);

        assertThat(resposta.tipo, is("application/json;charset=UTF-8"));
        assertThat(resposta.saida, is("{\"tipo\":\"\",\"triangulo\":false}"));
        assertThat(resposta.statusCode, is(404));
    }

    @Test
    public void testNaoEhTrianguloPeloLado3() throws IOException {
        double l1 = 10;
        double l2 = 20;
        double l3 = 300;

        RespostaWs resposta = acessaWebService(l1, l2, l3);

        assertThat(resposta.tipo, is("application/json;charset=UTF-8"));
        assertThat(resposta.saida, is("{\"tipo\":\"\",\"triangulo\":false}"));
        assertThat(resposta.statusCode, is(404));
    }

    @Test
    public void testTrianguloEquilatero() throws IOException {
        double l1 = 10;
        double l2 = 10;
        double l3 = 10;

        RespostaWs resposta = acessaWebService(l1, l2, l3);

        assertThat(resposta.tipo, is("application/json;charset=UTF-8"));
        assertThat(resposta.saida, is("{\"tipo\":\"equilátero\",\"triangulo\":true}"));
        assertThat(resposta.statusCode, is(200));
    }

    @Test
    public void testTrianguloEscaleno() throws IOException {
        double l1 = 30;
        double l2 = 40;
        double l3 = 50;

        RespostaWs resposta = acessaWebService(l1, l2, l3);

        assertThat(resposta.tipo, is("application/json;charset=UTF-8"));
        assertThat(resposta.saida, is("{\"tipo\":\"escaleno\",\"triangulo\":true}"));
        assertThat(resposta.statusCode, is(200));
    }

    @Test
    public void testTrianguloIsoscelesPeloLado1() throws IOException {
        double l1 = 10;
        double l2 = 20;
        double l3 = 20;

        RespostaWs resposta = acessaWebService(l1, l2, l3);

        assertThat(resposta.tipo, is("application/json;charset=UTF-8"));
        assertThat(resposta.saida, is("{\"tipo\":\"isósceles\",\"triangulo\":true}"));
        assertThat(resposta.statusCode, is(200));
    }

    @Test
    public void testTrianguloIsoscelesPeloLado2() throws IOException {
        double l1 = 20;
        double l2 = 10;
        double l3 = 20;

        RespostaWs resposta = acessaWebService(l1, l2, l3);

        assertThat(resposta.tipo, is("application/json;charset=UTF-8"));
        assertThat(resposta.saida, is("{\"tipo\":\"isósceles\",\"triangulo\":true}"));
        assertThat(resposta.statusCode, is(200));
    }

    @Test
    public void testTrianguloIsoscelesPeloLado3() throws IOException {
        double l1 = 20;
        double l2 = 20;
        double l3 = 10;

        RespostaWs resposta = acessaWebService(l1, l2, l3);

        assertThat(resposta.tipo, is("application/json;charset=UTF-8"));
        assertThat(resposta.saida, is("{\"tipo\":\"isósceles\",\"triangulo\":true}"));
        assertThat(resposta.statusCode, is(200));
    }

    private RespostaWs acessaWebService(double l1, double l2, double l3) throws IOException {
        Response response = Jsoup.connect("http://localhost:8084/dcs-jaxrs-triangulo/webresources/triangulo/" + l1 + "/" + l2 + "/" + l3)
                .method(Method.GET)
                .ignoreContentType(true)
                .ignoreHttpErrors(true)
                .execute();

        String tipo = response.contentType();
        String saida = response.body();
        int statusCode = response.statusCode();

        return new RespostaWs(tipo, saida, statusCode);
    }

}

class RespostaWs {

    public String tipo;
    public String saida;
    public int statusCode;

    public RespostaWs(String tipo, String saida, int statusCode) {
        this.tipo = tipo;
        this.saida = saida;
        this.statusCode = statusCode;
    }

}
