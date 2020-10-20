package domain;

public class Trapezio implements FiguraIF {
    private double altura;
    private double baseMenor;
    private double baseMaior;

    public Trapezio(double altura, double baseMenor, double baseMaior) {
        this.altura = altura;
        this.baseMenor = baseMenor;
        this.baseMaior = baseMaior;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getBaseMenor() {
        return baseMenor;
    }

    public void setBaseMenor(double baseMenor) {
        this.baseMenor = baseMenor;
    }

    public double getBaseMaior() {
        return baseMaior;
    }

    public void setBaseMaior(double baseMaior) {
        this.baseMaior = baseMaior;
    }
    
    @Override
    public Object aceitaVisita(VisitorIF visitor) {
        return visitor.visitarTrapezio(this);
    }
}
