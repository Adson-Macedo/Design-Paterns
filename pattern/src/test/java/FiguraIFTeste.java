import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import domain.Circulo;
import domain.Retangulo;
import domain.Trapezio;
import domain.Triangulo;
import domain.VisitorCalcularArea;
import domain.VisitorCalcularPerimetro;
import domain.VisitorDesenhar;
import domain.VisitorMaximizarFigura;

public class FiguraIFTeste {

    @Test
    public void deveVisitarCirculo() {
        Circulo circulo = new Circulo(10);
        assertEquals((Double) circulo.aceitaVisita(new VisitorCalcularArea()), 314.15, 0.01);
        assertEquals((Double) circulo.aceitaVisita(new VisitorCalcularPerimetro()), 62.83, 0.1);
        assertEquals(circulo.aceitaVisita(new VisitorDesenhar()), "Desenhando círculo...");
        assertTrue((Boolean) circulo.aceitaVisita(new VisitorMaximizarFigura()));

        assertEquals(circulo.getRaio(), 20);
    }

    @Test
    public void deveVisitarRetangulo() {
        Retangulo retangulo = new Retangulo(10, 30);

        assertEquals((Double) retangulo.aceitaVisita(new VisitorCalcularArea()), 300, 0.01);
        assertEquals((Double) retangulo.aceitaVisita(new VisitorCalcularPerimetro()), 80, 0.01);
        assertEquals((String) retangulo.aceitaVisita(new VisitorDesenhar()), "Desenhando retângulo...");
        assertTrue((Boolean) retangulo.aceitaVisita(new VisitorMaximizarFigura()));

        assertEquals(retangulo.getAltura(), 20);
        assertEquals(retangulo.getLargura(), 60);
    }

    @Test
    public void deveVisitarTriangulo() {
        Triangulo triangulo = new Triangulo(3, 4);

        assertEquals((Double) triangulo.aceitaVisita(new VisitorCalcularArea()), 6.0, 0.01);
        assertEquals((Double) triangulo.aceitaVisita(new VisitorCalcularPerimetro()), 12.0, 0.01);
        assertEquals((String) triangulo.aceitaVisita(new VisitorDesenhar()), "Desenhando triângulo...");
        assertTrue((Boolean) triangulo.aceitaVisita(new VisitorMaximizarFigura()));

        assertEquals(triangulo.getBase(), 6.0);
        assertEquals(triangulo.getAltura(), 8.0);
    }

    @Test
    public void deveVisitarTrapezio() {
        Trapezio trapezio = new Trapezio(10, 10, 30);

        assertEquals((Double) trapezio.aceitaVisita(new VisitorCalcularArea()), 200, 0.01);
        assertEquals((Double) trapezio.aceitaVisita(new VisitorCalcularPerimetro()), 68.28, 0.01);
        assertEquals((String) trapezio.aceitaVisita(new VisitorDesenhar()), "Desenhando trapézio...");
        assertTrue((Boolean) trapezio.aceitaVisita(new VisitorMaximizarFigura()));

        assertEquals(trapezio.getAltura(), 20);
        assertEquals(trapezio.getBaseMenor(), 20);
        assertEquals(trapezio.getBaseMaior(), 60);
    }
}
