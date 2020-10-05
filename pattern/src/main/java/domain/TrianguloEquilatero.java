package domain;

/**
 * TrianguloEquilatero
 */
public class TrianguloEquilatero extends Triangulo {

    public TrianguloEquilatero(double lado) {
        super(lado);
    }

    public double getLado() {
        return this.getBase();
    }

    @Override
    public double getPerimetro() {
        return 3 * this.getBase();
    }

    @Override
    public double getAltura() {
        return this.getBase() * Math.sqrt(3) / 2;
    }

    @Override
    public String toString() {
        return "Triangulo Equilatero de lado: " + this.getBase();
    }

    @Override
    public boolean equals(Object obj) {
        if (this != obj || !(obj instanceof TrianguloEquilatero))
            return false;

        return ((TrianguloEquilatero) obj).getBase() == this.getBase();
    }
}