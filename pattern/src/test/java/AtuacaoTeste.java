import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import domain.Atuacao;
import domain.Pessoa;
import domain.Filme;

import domain.funcionarios.Camera;

public class AtuacaoTeste {

    Pessoa pessoa = new Pessoa("Thairam Michel");
    Filme filme = new Filme("Sem limites", 2011);

    @Test
    public void verificarCriacaoDaAtuacao() {
        Atuacao atuacao = new Atuacao(new Camera(pessoa), filme);

        assertEquals(atuacao.getFilme().getNome(), "Sem limites");
        assertEquals(atuacao.getCargo().getNome(), "Thairam Michel");
        assertEquals(atuacao.getCargo().getFuncao(), "Camera");
    }

    @Test
    public void verificarAtuacaoToString() {
        Atuacao atuacao = new Atuacao(new Camera(pessoa), filme);
        assertEquals(atuacao.toString(), "Filme: Sem limites\nCargo: Camera");
    }
}
