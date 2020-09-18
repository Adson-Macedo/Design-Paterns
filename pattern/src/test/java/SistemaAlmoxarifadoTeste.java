import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import sistemas.SistemaAlmoxarifado;

public class SistemaAlmoxarifadoTeste {

    SistemaAlmoxarifado sistema = new SistemaAlmoxarifado();

    @Test
    public void validarCriarPedido() {
        String resultadoEsperado = new String("{id: 1457, data: '01/01/2020', itens: [], finalizado: false}");
        assertEquals(sistema.criarPedido(), resultadoEsperado);
    }

    @Test
    public void validarCriarProduto() {
        String resultadoEsperado = new String("{id: 0001, descricao: 'PC Gamer', estoque: 200}");
        assertEquals(sistema.criarProduto("PC Gamer", 200), resultadoEsperado);
    }

    @Test
    public void validaradicionarItemAoPedido() {
        String resultadoEsperado = new String("{id: 22, data: '01/01/2020', itens: [{idProduto: 77, quantidade: 8}]}");
        assertEquals(sistema.adicionarItemAoPedido(22, 77, 8), resultadoEsperado);
    }

    @Test
    public void validarFinalizarPedido() {
        String resultadoEsperado = new String("{id: 75, data: '01/01/2020', itens: [...], finalizado: true}");
        assertEquals(sistema.finalizarPedido(75), resultadoEsperado);
    }

    @Test
    public void validarObterEstoqueGeral() {
        String resultadoEsperado = new String("[{id: 0001, descricao: 'Produto1', estoque: 3}, {id: 0002, descricao: 'Produto2', estoque: 5}]");
        assertEquals(sistema.obterEstoqueGeral(), resultadoEsperado);
    }

    @Test
    public void validarObterPedido() {
        String resultadoEsperado = new String("{id: 66, data: '01/01/2020', itens: [...], finalizado: true}");
        assertEquals(sistema.obterPedido(66), resultadoEsperado);
    }

    @Test
    public void validarListaDePedidos() {
        String resultadoEsperado = new String("[{id: 1457, data: '01/01/2020', itens: [...], finalizado: true}, {id: 1459, data: '15/10/2020', itens: [...], finalizado: true}]");
        assertEquals(sistema.obterListaDePedidos(), resultadoEsperado);
    }
}
