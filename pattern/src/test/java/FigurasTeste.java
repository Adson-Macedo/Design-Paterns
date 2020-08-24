import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import domain.Figuras;
import utils.Messages;
import utils.Utils;

public class FigurasTeste {

    @Test
    public void verificarAdicionarQuadrado() throws Exception {
        Figuras figuras = new Figuras();
        figuras.adicionarQuadrado(10);

        assertEquals(figuras.getFiguras().size(), 1);

        figuras.getFiguras().forEach(figura -> {
            assertEquals(figura.getFigName(), "quadrado");
        });
    }

    @Test
    public void verificarAdicionarRetangulo() throws Exception {
        Figuras figuras = new Figuras();
        figuras.adicionarRetangulo(5, 25);

        assertEquals(figuras.getFiguras().size(), 1);

        figuras.getFiguras().forEach(figura -> {
            assertEquals(figura.getFigName(), "retângulo");
        });
    }

    @Test
    public void verificarAdicionarCirculo() throws Exception {
        Figuras figuras = new Figuras();
        figuras.adicionarCirculo(1.2);

        assertEquals(figuras.getFiguras().size(), 1);

        figuras.getFiguras().forEach(figura -> {
            assertEquals(figura.getFigName(), "círculo");
        });
    }

    @Test
    public void verificarGetFiguras() throws Exception {
        Figuras figuras = new Figuras();

        figuras.adicionarQuadrado(10);
        figuras.adicionarCirculo(15);
        figuras.adicionarRetangulo(5, 25);

        String[] nomeFiguras = { "quadrado", "círculo", "retângulo" };

        for (int i = 0; i < nomeFiguras.length; i++) {
            assertEquals(figuras.get(i).getFigName(), nomeFiguras[i]);
        }
    }

    @Test
    public void verificarGetPerimetroQuandoIndexInvalido() throws Exception {
        Figuras figuras = new Figuras();

        figuras.adicionarQuadrado(10);
        figuras.adicionarCirculo(15);

        Exception exception = assertThrows(Exception.class, () -> {
            figuras.getPerimetro(-1);
        });

        assertEquals(Messages.MSG_INDEX_INVALIDO, exception.getMessage());
    }

    @Test
    public void verificarGetAreaQuandoIndexInvalido() throws Exception {
        Figuras figuras = new Figuras();

        figuras.adicionarQuadrado(10);
        figuras.adicionarCirculo(15);

        Exception exception = assertThrows(Exception.class, () -> {
            figuras.getArea(2);
        });

        assertEquals(Messages.MSG_INDEX_INVALIDO, exception.getMessage());
    }

    @Test
    public void verificarGetDescricaoQuandoIndexInvalido() throws Exception {
        Figuras figuras = new Figuras();

        figuras.adicionarQuadrado(10);
        figuras.adicionarCirculo(15);

        Exception exception = assertThrows(Exception.class, () -> {
            figuras.getDescricao(-1);
        });

        assertEquals(Messages.MSG_INDEX_INVALIDO, exception.getMessage());
    }

    @Test
    public void verificarGetPerimetroDeTodasFiguras() throws Exception {
        Figuras figuras = new Figuras();

        figuras.adicionarQuadrado(2);
        figuras.adicionarRetangulo(4, 2);
        figuras.adicionarCirculo(10.5);

        List<String> perimetros = new ArrayList<>();
        perimetros.add("Tipo da figura: quadrado; Perímetro: 8.0");
        perimetros.add("Tipo da figura: retângulo; Perímetro: 12.0");
        perimetros.add("Tipo da figura: círculo; Perímetro: " + (2 * Utils.PI * 10.5));

        assertEquals(figuras.getPerimetroDeTodasFiguras(), perimetros);
    }

    @Test
    public void verificarGetAreaDeTodasFiguras() throws Exception {
        Figuras figuras = new Figuras();

        figuras.adicionarQuadrado(1);
        figuras.adicionarRetangulo(5, 9);
        figuras.adicionarCirculo(0.1);

        List<String> perimetros = new ArrayList<>();
        perimetros.add("Tipo da figura: quadrado; Área: 1.0");
        perimetros.add("Tipo da figura: retângulo; Área: 45.0");
        perimetros.add("Tipo da figura: círculo; Área: " + (Utils.PI * 0.1 * 0.1));

        assertEquals(figuras.getAreaDeTodasFiguras(), perimetros);
    }
}