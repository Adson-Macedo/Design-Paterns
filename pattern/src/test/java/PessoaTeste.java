import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import domain.funcionarios.*;
import domain.Pessoa;

public class PessoaTeste {

    Pessoa pessoa = new Pessoa("Thairam Michel");

    @Test
    public void verificarCriacaoAtor() {
        Ator ator = new Ator(pessoa);
        assertEquals(ator.getNome(), "Thairam Michel");
        assertEquals(ator.getFuncao(), "Ator");
    }

    @Test
    public void verificarCriacaoCamera() {
        Camera camera = new Camera(pessoa);
        assertEquals(camera.getNome(), "Thairam Michel");
        assertEquals(camera.getFuncao(), "Camera");
    }

    @Test
    public void verificarCriacaoCinegrafista() {
        Cinegrafista cinegrafista = new Cinegrafista(pessoa);
        assertEquals(cinegrafista.getNome(), "Thairam Michel");
        assertEquals(cinegrafista.getFuncao(), "Cinegrafista");
    }

    @Test
    public void verificarCriacaoDiretor() {
        Diretor diretor = new Diretor(pessoa);
        assertEquals(diretor.getNome(), "Thairam Michel");
        assertEquals(diretor.getFuncao(), "Diretor");
    }

    @Test
    public void verificarCriacaoRoteirista() {
        Roteirista roteirista = new Roteirista(pessoa);
        assertEquals(roteirista.getNome(), "Thairam Michel");
        assertEquals(roteirista.getFuncao(), "Roteirista");
    }
}
