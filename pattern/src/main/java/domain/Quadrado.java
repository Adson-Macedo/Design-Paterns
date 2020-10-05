package domain;

public class Quadrado implements FiguraGeometrica {

    private double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) throws Exception {
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
        return "Quadrado de Lado: " + lado;
    }

    @Override
    public boolean equals(Object obj) {
        if (this != obj || !(obj instanceof Quadrado))
            return false;

        return ((Quadrado) obj).getLado() == this.getLado();
    }
}