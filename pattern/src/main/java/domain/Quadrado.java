package domain;

import utils.Validation;

public class Quadrado extends FiguraGeometrica{
    private int lado;

    public Quadrado(int lado) throws Exception{
        Validation.validarLado(lado);
        this.lado = lado;
        this.figName = "quadrado";
    }
    
    public int getLado() {
        return lado;
    }
    
    public void setLado(int lado) throws Exception{
        Validation.validarLado(lado);
        this.lado = lado;
    }

    @Override
    public double getArea() {
        return lado * lado;
    }

    @Override
    public double getPerimetro() {
        return 4 * lado;
    }

    @Override
    public String toString() {
        return "O quadrado criado tem lados de tamanho: "
            .concat(Integer.toString(this.lado));
    }

    @Override
    public String areaToString() {
        return "A área deste retângulo é: "
            .concat(Double.toString(getArea()));
    }

    @Override
    public String perimetroToString() {
        return "O perímetro do quadrado é: "
            .concat(Double.toString(getPerimetro()));
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Quadrado)){
            return false;
        }
            
        return ((Quadrado) obj).lado == this.lado;
    }

}