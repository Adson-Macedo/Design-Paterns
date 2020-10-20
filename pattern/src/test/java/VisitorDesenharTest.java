import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import domain.Circulo;
import domain.Retangulo;
import domain.Trapezio;
import domain.Triangulo;
import domain.VisitorDesenhar;

public class VisitorDesenharTest {
    @Test
    public void verificaDesenhar(){
        Circulo circulo = new Circulo(12);
        Retangulo retangulo = new Retangulo(15, 25);
        Trapezio trapezio = new Trapezio(10, 15, 25);
        Triangulo triangulo = new Triangulo(12, 6);
        VisitorDesenhar desenhar = new VisitorDesenhar();

        assertEquals((String) circulo.aceitaVisita(desenhar), "Desenhando círculo...");
        assertEquals((String) retangulo.aceitaVisita(desenhar), "Desenhando retângulo...");
        assertEquals((String) trapezio.aceitaVisita(desenhar), "Desenhando trapézio...");
        assertEquals((String) triangulo.aceitaVisita(desenhar), "Desenhando triângulo...");
    }
}
