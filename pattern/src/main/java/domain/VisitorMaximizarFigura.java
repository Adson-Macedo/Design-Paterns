package domain;

public class VisitorMaximizarFigura implements VisitorIF {

    private final int FATOR = 2;

    @Override
    public Object visitarRetangulo(Retangulo retangulo) {
        retangulo.setAltura(FATOR * retangulo.getAltura());
        retangulo.setLargura(FATOR * retangulo.getLargura());

        return true;
    }

    @Override
    public Object visitarTriangulo(Triangulo triangulo) {
        triangulo.setBase(FATOR * triangulo.getBase());
        triangulo.setAltura(FATOR * triangulo.getAltura());

        return true;
    }

    @Override
    public Object visitarCirculo(Circulo circulo) {
        circulo.setRaio(FATOR * circulo.getRaio());
        return true;
    }

    @Override
    public Object visitarTrapezio(Trapezio trapezio) {
        trapezio.setAltura(FATOR * trapezio.getAltura());
        trapezio.setBaseMenor(FATOR * trapezio.getBaseMenor());
        trapezio.setBaseMaior(FATOR * trapezio.getBaseMaior());

        return true;
    }
}