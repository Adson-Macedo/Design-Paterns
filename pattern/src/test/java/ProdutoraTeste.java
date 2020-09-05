import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import domain.*;
import domain.funcionarios.*;

public class ProdutoraTeste {
    @Test
    public void testeCriarFilme(){
        Produtora prod = new Produtora();

        prod.criarFilme("Um filme", 2020);

        Filme filme = prod.buscarFilmePeloId(0);

        assertEquals(filme.getNome(), "Um filme");
        assertEquals(filme.getAno(), 2020);
    }

    @Test
    public void testeCriarPessoa(){
        Produtora prod = new Produtora();

        prod.criarPessoa("Uma pessoa");

        Pessoa pessoa = prod.buscarPessoaPeloId(0);

        assertEquals(pessoa.getNome(), "Uma pessoa");
    }

    @Test
    public void testeAdicionarAtorAoFilme(){
        Produtora prod = new Produtora();

        prod.criarPessoa("Uma pessoa");
        prod.criarFilme("Um filme", 2020);
        prod.adicionarAtorAoFilme(0, 0);

        assertEquals(prod.buscarFilmePeloId(0).getElenco().get(0).getClass(), Ator.class);
        assertEquals(prod.buscarFilmePeloId(0).getElenco().get(0).getNome(), "Uma pessoa");
    }

    @Test
    public void testeAdicionarDiretorAoFilme(){
        Produtora prod = new Produtora();

        prod.criarPessoa("Uma pessoa");
        prod.criarFilme("Um filme", 2020);
        prod.adicionarDiretorAoFilme(0, 0);

        assertEquals(prod.buscarFilmePeloId(0).getElenco().get(0).getClass(), Diretor.class);
        assertEquals(prod.buscarFilmePeloId(0).getElenco().get(0).getNome(), "Uma pessoa");
    }

    @Test
    public void testeAdicionarCameraAoFilme(){
        Produtora prod = new Produtora();

        prod.criarPessoa("Uma pessoa");
        prod.criarFilme("Um filme", 2020);
        prod.adicionarCameraAoFilme(0, 0);

        assertEquals(prod.buscarFilmePeloId(0).getElenco().get(0).getClass(), Camera.class);
        assertEquals(prod.buscarFilmePeloId(0).getElenco().get(0).getNome(), "Uma pessoa");
    }

    @Test
    public void testeAdicionarCinegrafistaAoFilme(){
        Produtora prod = new Produtora();

        prod.criarPessoa("Uma pessoa");
        prod.criarFilme("Um filme", 2020);
        prod.adicionarCinegrafistaAoFilme(0, 0);

        assertEquals(prod.buscarFilmePeloId(0).getElenco().get(0).getClass(), Cinegrafista.class);
        assertEquals(prod.buscarFilmePeloId(0).getElenco().get(0).getNome(), "Uma pessoa");
    }

    @Test
    public void testeAdicionarRoteiristaAoFilme(){
        Produtora prod = new Produtora();

        prod.criarPessoa("Uma pessoa");
        prod.criarFilme("Um filme", 2020);
        prod.adicionarRoteiristaAoFilme(0, 0);

        assertEquals(prod.buscarFilmePeloId(0).getElenco().get(0).getClass(), Roteirista.class);
        assertEquals(prod.buscarFilmePeloId(0).getElenco().get(0).getNome(), "Uma pessoa");
    }

    @Test
    public void testeAdicionarTrilhaSonoraAoFilme(){
        Produtora prod = new Produtora();

        prod.criarFilme("Um filme", 2020);
        prod.adicionarTrilhaSonoraAoFilme(0, "Uma musica");

        assertEquals(prod.buscarFilmePeloId(0).getTrilhaSonora().get(0), "Uma musica");
    }
}
