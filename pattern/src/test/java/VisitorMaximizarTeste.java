import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import domain.Circulo;
import domain.Retangulo;
import domain.Trapezio;
import domain.Triangulo;
import domain.VisitorMaximizarFigura;

public class VisitorMaximizarTeste {
    Circulo circulo = new Circulo(10);
    Retangulo retangulo = new Retangulo(10, 30);
    Triangulo triangulo = new Triangulo(3, 4);
    Trapezio trapezio = new Trapezio(10, 10, 30);

    VisitorMaximizarFigura visitor = new VisitorMaximizarFigura();

    @Test
    public void verificarMaximizarFigura() {
        assertTrue((Boolean) circulo.aceitaVisita(visitor));
        assertEquals(circulo.getRaio(), 20);

        assertTrue((Boolean) retangulo.aceitaVisita(visitor));
        assertEquals(retangulo.getAltura(), 20);
        assertEquals(retangulo.getLargura(), 60);

        assertTrue((Boolean) triangulo.aceitaVisita(visitor));
        assertEquals(triangulo.getBase(), 6.0);
        assertEquals(triangulo.getAltura(), 8.0);

        assertTrue((Boolean) trapezio.aceitaVisita(visitor));
        assertEquals(trapezio.getAltura(), 20);
        assertEquals(trapezio.getBaseMenor(), 20);
        assertEquals(trapezio.getBaseMaior(), 60);
    }
}
