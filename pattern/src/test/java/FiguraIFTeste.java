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

    VisitorCalcularArea visitorCA = new VisitorCalcularArea();
    VisitorCalcularPerimetro visitorCP = new VisitorCalcularPerimetro();
    VisitorDesenhar visitorD = new VisitorDesenhar();
    VisitorMaximizarFigura visitorMF = new VisitorMaximizarFigura();

    @Test
    public void deveVisitarCirculo() {
        Circulo circulo = new Circulo(10);
        assertEquals((Double) circulo.aceitaVisita(visitorCA), 314.15, 0.01);
        assertEquals((Double) circulo.aceitaVisita(visitorCP), 62.83, 0.1);
        assertEquals(circulo.aceitaVisita(visitorD), "Desenhando círculo...");
        assertTrue((Boolean) circulo.aceitaVisita(visitorMF));

        assertEquals(circulo.getRaio(), 20);
    }

    @Test
    public void deveVisitarRetangulo() {
        Retangulo retangulo = new Retangulo(10, 30);

        assertEquals((Double) retangulo.aceitaVisita(visitorCA), 300, 0.01);
        assertEquals((Double) retangulo.aceitaVisita(visitorCP), 80, 0.01);
        assertEquals((String) retangulo.aceitaVisita(visitorD), "Desenhando retângulo...");
        assertTrue((Boolean) retangulo.aceitaVisita(visitorMF));

        assertEquals(retangulo.getAltura(), 20);
        assertEquals(retangulo.getLargura(), 60);
    }

    @Test
    public void deveVisitarTriangulo() {
        Triangulo triangulo = new Triangulo(3, 4);

        assertEquals((Double) triangulo.aceitaVisita(visitorCA), 6.0, 0.01);
        assertEquals((Double) triangulo.aceitaVisita(visitorCP), 12.0, 0.01);
        assertEquals((String) triangulo.aceitaVisita(visitorD), "Desenhando triângulo...");
        assertTrue((Boolean) triangulo.aceitaVisita(visitorMF));

        assertEquals(triangulo.getBase(), 6.0);
        assertEquals(triangulo.getAltura(), 8.0);
    }

    @Test
    public void deveVisitarTrapezio() {
        Trapezio trapezio = new Trapezio(10, 10, 30);

        assertEquals((Double) trapezio.aceitaVisita(visitorCA), 200, 0.01);
        assertEquals((Double) trapezio.aceitaVisita(visitorCP), 68.28, 0.01);
        assertEquals((String) trapezio.aceitaVisita(visitorD), "Desenhando trapézio...");
        assertTrue((Boolean) trapezio.aceitaVisita(visitorMF));

        assertEquals(trapezio.getAltura(), 20);
        assertEquals(trapezio.getBaseMenor(), 20);
        assertEquals(trapezio.getBaseMaior(), 60);
    }
}
