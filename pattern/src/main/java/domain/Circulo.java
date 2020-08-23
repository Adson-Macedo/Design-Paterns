package domain;

import utils.Validation;
import utils.Utils;

public class Circulo extends FiguraGeometrica{
    private double raio;

    public Circulo(double raio) throws Exception{
        Validation.validarRaio(raio);
        this.raio = raio;
        this.figName = "círculo";
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) throws Exception{
        Validation.validarRaio(raio);
        this.raio = raio;
    }

    @Override
    public double getArea() {
        return Utils.PI * raio * raio;
    }

    @Override
    public double getPerimetro() {
        return 2 * Utils.PI * raio;
    }

    @Override
    public String toString() {
        return "O círculo criado tem raio de tamanho: "
            .concat(Double.toString(this.raio));
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Circulo)){
            return false;
        }
            
        return ((Circulo) obj).raio == this.raio;
    }
}