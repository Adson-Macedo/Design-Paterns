package domain;

/**
 * Circulo
 */
public class Circulo implements FiguraGeometrica {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    @Override
    public double getArea() {
        return Math.PI * raio * raio;
    }

    @Override
    public double getPerimetro() {
        return 2 * Math.PI * raio;
    }

    @Override
    public String toString() {
        return "Circulo de raio: " + raio;
    }

    @Override
    public boolean equals(Object obj) {
        if (this != obj || !(obj instanceof Circulo))
            return false;

        return ((Circulo) obj).getRaio() == this.getRaio();
    }

}