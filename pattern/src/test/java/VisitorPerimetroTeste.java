import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import domain.Circulo;
import domain.Retangulo;
import domain.Trapezio;
import domain.Triangulo;
import domain.VisitorCalcularPerimetro;

public class VisitorPerimetroTeste {
    Circulo circulo = new Circulo(10);
    Retangulo retangulo = new Retangulo(10, 30);
    Triangulo triangulo = new Triangulo(3, 4);
    Trapezio trapezio = new Trapezio(10, 10, 30);

    VisitorCalcularPerimetro visitor = new VisitorCalcularPerimetro();

    @Test
    public void verificarCalcularPerimetro() {
        assertEquals((Double) circulo.aceitaVisita(visitor), 62.83, 0.1);
        assertEquals((Double) retangulo.aceitaVisita(visitor), 80, 0.01);
        assertEquals((Double) triangulo.aceitaVisita(visitor), 12.0, 0.01);
        assertEquals((Double) trapezio.aceitaVisita(visitor), 68.28, 0.01);
    }
}
