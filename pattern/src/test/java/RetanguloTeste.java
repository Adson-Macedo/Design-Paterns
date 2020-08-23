import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.Retangulo;
import utils.Messages;

public class RetanguloTeste {

    @Test
    public void verificarCriacaoRetangulo() throws Exception {
        Retangulo r = new Retangulo(100, 90);
        assertEquals(r.getAltura(), 100);
        assertEquals(r.getLargura(), 90);
    }

    @Test
    public void verificarCriacaoRetanguloInvalido() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            new Retangulo(0, 0);
        });
        assertEquals(Messages.MSG_ALTURA_INVALIDA, exception.getMessage());
    }

    @Test
    public void verificarCriacaoRetanguloComAlturaNegativa() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            new Retangulo(-2, 10);
        });
        assertEquals(Messages.MSG_ALTURA_INVALIDA, exception.getMessage());
    }

    @Test
    public void verificarCriacaoRetanguloComLarguraNegativa() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            new Retangulo(5, -1);
        });
        assertEquals(Messages.MSG_LARGURA_INVALIDA, exception.getMessage());
    }

    @Test
    public void verificarPerimetroDoRetangulo() throws Exception {
        Retangulo r = new Retangulo(2, 5);
        assertEquals(r.getPerimetro(), 14);
    }

    @Test
    public void verificarAreaDoRetangulo() throws Exception {
        Retangulo r = new Retangulo(110, 28);
        assertEquals(r.getArea(), 3080);
    }

    @Test
    public void verificarToString() throws Exception {
        Retangulo r = new Retangulo(110, 28);
        String msg = "O retângulo criado tem altura de tamanho: 110 e largura de tamanho: 28";
        assertEquals(r.toString(), msg);
    }
}