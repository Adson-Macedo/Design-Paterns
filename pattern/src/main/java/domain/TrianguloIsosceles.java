package domain;

/**
 * TrianguloIsosceles
 */
public class TrianguloIsosceles extends Triangulo {
    private double lado;

    public TrianguloIsosceles(double base, double lado) {
        super(base);
        this.lado = lado;
    }

    public double getLado() {
        return this.lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    @Override
    public double getPerimetro() {
        return 2 * this.getLado() + this.getBase();
    }

    @Override
    public double getAltura() {
        return Math.sqrt(Math.pow(this.getLado(), 2) - Math.pow(this.getBase() / 2, 2));
    }

    @Override
    public String toString() {
        return "Triangulo Isosceles de lado: " + this.getLado() + " e base: " + this.getBase();
    }

    @Override
    public boolean equals(Object obj) {
        if (this != obj || !(obj instanceof TrianguloIsosceles))
            return false;

        TrianguloIsosceles t1 = (TrianguloIsosceles) obj;

        return t1.getBase() == this.getBase() && t1.getAltura() == this.getAltura();
    }

}