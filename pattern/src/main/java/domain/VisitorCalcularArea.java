package domain;

public class VisitorCalcularArea implements VisitorIF {
    @Override
    public Object visitarRetangulo(Retangulo r) {
        Double area = r.getAltura() * r.getLargura();
        return area;
    }
    
    @Override
    public Object visitarTriangulo(Triangulo t) {
        Double area = t.getBase() * t.getAltura() / 2;
        return area;
    }
    
    @Override
    public Object visitarCirculo(Circulo c) {
        Double area = Math.pow(c.getRaio(), 2) * Math.PI;
        return area;
    }
    
    @Override
    public Object visitarTrapezio(Trapezio t) {
        Double area = t.getAltura() * (t.getBaseMaior() + t.getBaseMenor()) / 2.0;
        return area;
    }
}
