package domain;

public class Circulo implements FiguraIF {
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
    public Object aceitaVisita(VisitorIF visitor) {
        return visitor.visitarCirculo(this);
    }
}
