import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import domain.Figuras;

public class FigurasTeste {

    @Test
    public void verificarAdicionarQuadrado() throws Exception{
        Figuras figuras = new Figuras();
        figuras.adicionarQuadrado(10);
    }

    @Test
    public void verificarAdicionarRetangulo() throws Exception {
        Figuras figuras = new Figuras();
        figuras.adicionarRetangulo(5, 25);
    }

    @Test
    public void verificarAdicionarCirculo() throws Exception{
        Figuras figuras = new Figuras();
        figuras.adicionarCirculo(15);
    }

    @Test
    public void verificarGetFiguras() throws Exception{
        Figuras figuras = new Figuras();
     
        figuras.adicionarQuadrado(10);
        figuras.adicionarCirculo(15);
        figuras.adicionarRetangulo(5, 25);
        
        String[] nomeFiguras = {"quadrado", "círculo", "retângulo"};
        
        for (int i = 0; i < nomeFiguras.length; i++) {
            assertEquals(figuras.get(i).getFigName(), nomeFiguras[i]);
        }
    }
}