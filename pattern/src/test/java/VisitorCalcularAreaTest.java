import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import domain.Circulo;
import domain.Retangulo;
import domain.Trapezio;
import domain.Triangulo;
import domain.VisitorCalcularArea;

public class VisitorCalcularAreaTest {
    @Test
    public void verificaCalcularArea(){
        Circulo circulo = new Circulo(12);
        Retangulo retangulo = new Retangulo(15, 25);
        Trapezio trapezio = new Trapezio(10, 15, 25);
        Triangulo triangulo = new Triangulo(12, 6);
        VisitorCalcularArea area = new VisitorCalcularArea();

        assertEquals((Double) circulo.aceitaVisita(area), 452.389, 0.01);
        assertEquals((Double) retangulo.aceitaVisita(area), 375.0, 0.01);
        assertEquals((Double) trapezio.aceitaVisita(area), 200.0, 0.01);
        assertEquals((Double) triangulo.aceitaVisita(area), 36.0, 0.01);
    }
}
