package domain;

public interface VisitorIF {
    public Object visitarRetangulo(Retangulo retangulo);
    public Object visitarTriangulo(Triangulo triangulo);
    public Object visitarCirculo(Circulo circulo);
    public Object visitarTrapezio(Trapezio trapezio);
}
