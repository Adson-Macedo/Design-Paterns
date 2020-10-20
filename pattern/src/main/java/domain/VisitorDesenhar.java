package domain;

public class VisitorDesenhar implements VisitorIF {

    @Override
    public Object visitarRetangulo(Retangulo retangulo) {
        return new String("Desenhando retângulo...");
    }

    @Override
    public Object visitarTriangulo(Triangulo triangulo) {
        return new String("Desenhando triângulo...");
    }

    @Override
    public Object visitarCirculo(Circulo circulo) {
        return new String("Desenhando círculo...");
    }

    @Override
    public Object visitarTrapezio(Trapezio trapezio) {
        return new String("Desenhando trapézio...");
    }
}
