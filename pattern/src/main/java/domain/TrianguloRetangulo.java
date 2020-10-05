package domain;

/**
 * TrianguloRetangulo
 */
public class TrianguloRetangulo extends Triangulo {

    private double altura;

    public TrianguloRetangulo(double base, double altura) {
        super(base);
        this.altura = altura;
    }

    @Override
    public double getPerimetro() {
        return this.getBase() + this.getAltura() + this.getHipotenusa();
    }

    public double getHipotenusa() {
        return Math.sqrt(Math.pow(this.getBase(), 2) + Math.pow(this.getAltura(), 2));
    }

    @Override
    public double getAltura() {
        return altura;
    }

    @Override
    public String toString() {
        return "Triangulo Retangulo de lados: " + this.getBase() + ", " + this.getAltura() + " e Hipotenusa: " + this.getHipotenusa();
    }

    @Override
    public boolean equals(Object obj) {
        if (this != obj || !(obj instanceof TrianguloRetangulo))
            return false;
        
        TrianguloRetangulo t1 = (TrianguloRetangulo) obj;

        return  t1.getBase() == this.getBase() && t1.getAltura() == this.getAltura();
    }
}