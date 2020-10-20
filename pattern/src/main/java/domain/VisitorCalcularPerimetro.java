package domain;

public class VisitorCalcularPerimetro implements VisitorIF {
    @Override
    public Object visitarRetangulo(Retangulo r) {
        Double perimetro = (r.getAltura() + r.getLargura()) * 2.0;
        return perimetro;
    }

    @Override
    public Object visitarTriangulo(Triangulo t) {
        Double a = t.getBase();
        Double b = t.getAltura();
        Double c = Math.sqrt(a * a + b * b);

        Double perimetro = a + b + c;
        return perimetro;
    }

    @Override
    public Object visitarCirculo(Circulo c) {
        Double perimetro = 2.0 * Math.PI * c.getRaio();
        return perimetro;
    }

    @Override
    public Object visitarTrapezio(Trapezio t) {
        Double m = t.getBaseMenor();
        Double M = t.getBaseMaior();
        Double h = t.getAltura();
        Double d = Math.sqrt(Math.pow((M - m) / 2.0, 2.0) + h * h);
        
        Double perimetro = m + M + 2 * d;
        return perimetro;
    }
}