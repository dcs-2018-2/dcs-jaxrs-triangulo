package br.pro.ramon.dcs.jaxrs.triangulo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class Triangulo {

    private double l1, l2, l3;

    public Triangulo(double l1, double l2, double l3) {
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
    }

    public boolean isTriangulo() {
        throw new UnsupportedOperationException("Você precisa implementar o método isTriangulo.");
    }

    public String getTipo() {
        throw new UnsupportedOperationException("Você precisa implementar o método getTipo.");
    }

}
