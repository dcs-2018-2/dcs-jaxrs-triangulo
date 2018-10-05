package br.pro.ramon.dcs.jaxrs.triangulo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    br.pro.ramon.dcs.jaxrs.triangulo.TrianguloTest.class,
    br.pro.ramon.dcs.jaxrs.triangulo.TrianguloResourceTest.class,
    br.pro.ramon.dcs.jaxrs.triangulo.TrianguloFormTest.class
})
public class AllTests {
}
