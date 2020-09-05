import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import domain.Filme;
import domain.Pessoa;
import domain.Atuacao;
import domain.funcionarios.Ator;
import domain.funcionarios.Diretor;

public class FilmeTeste {

    @Test
    public void verificarCriacaoDoFilme() {
        Filme filme = new Filme("Darkest Hour", 2018);
        assertEquals(filme.getNome(), "Darkest Hour");
        assertEquals(filme.getAno(), 2018);
        assertEquals(filme.getElenco(), new ArrayList<>());
        assertEquals(filme.getTrilhaSonora(), new ArrayList<>());
    }

    @Test
    public void verificarAdicionarTrilha() {
        Filme filme = new Filme("Darkest Hour", 2018);

        filme.addTrilha("primeira canção");
        filme.addTrilha("segunda canção");
        filme.addTrilha("terceira canção");

        assertEquals(filme.getTrilhaSonora().size(), 3);
        assertEquals(filme.getTrilhaSonora(), Arrays.asList("primeira canção", "segunda canção", "terceira canção"));
    }

    @Test
    public void verificarGetElenco() {
        Pessoa pessoa = new Pessoa("Thairam Michel");
        Filme filme = new Filme("Darkest Hour", 2018);

        new Atuacao(new Ator(pessoa), filme);
        new Atuacao(new Diretor(pessoa), filme);

        assertEquals(filme.getElenco().size(), 2);

        assertEquals(filme.getElenco().get(0).getNome(), "Thairam Michel");
        assertEquals(filme.getElenco().get(0).getFuncao(), "Ator");

        assertEquals(filme.getElenco().get(1).getNome(), "Thairam Michel");
        assertEquals(filme.getElenco().get(1).getFuncao(), "Diretor");
    }
}
