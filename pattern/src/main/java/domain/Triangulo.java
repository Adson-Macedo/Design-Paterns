package domain;

/**
 * Triangulo
 */
public abstract class Triangulo implements FiguraGeometrica {
    private double base;

    public Triangulo(double base) {
        this.base = base;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getArea() {
        return (this.getBase() * this.getAltura()) / 2;
    }

    public abstract double getAltura();
}