import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import sistemas.SistemaAlmoxarifado;

public class SistemaAlmoxarifadoTeste {

    SistemaAlmoxarifado sistema = new SistemaAlmoxarifado();

    @Test
    public void validarCriarPedido() {
        String resultadoEsperado = "{id: 1457, data: '01/01/2020', itens: [], finalizado: false}";
        assertEquals(sistema.criarPedido(), resultadoEsperado);
    }

    @Test
    public void validarCriarProduto() {
        String descricao = "asas";
        int estoqueInicial = 157;

        String produto = sistema.criarProduto(descricao, estoqueInicial);
        assertEquals(produto, "{id: 0001, descricao: '" + descricao + "', estoque: " + estoqueInicial + "}");
    }

    @Test
    public void validaradicionarItemAoPedido() {
        int idPedido = 0014;
        int idProduto = 0125;
        int quantidade = 5;

        String pedido = sistema.adicionarItemAoPedido(idPedido, idProduto, quantidade);

        String resultadoEsperado = "{id: " + idPedido + ", data: '01/01/2020', itens: [{idProduto: " + idProduto
                + ", quantidade: " + quantidade + "}]}";
        assertEquals(pedido, resultadoEsperado);
    }

    @Test
    public void validarFinalizarPedido() {
        int idPedido = 0014;

        String pedido = sistema.finalizarPedido(idPedido);

        String resultadoEsperado = "{id: " + idPedido + ", data: '01/01/2020', itens: [...], finalizado: true}";
        assertEquals(pedido, resultadoEsperado);
    }

    @Test
    public void validarObterEstoqueGeral() {
        String resultadoEsperado = "[{id: 0001, descricao: 'Produto1', estoque: 3}, {id: 0002, descricao: 'Produto2', estoque: 5}]";
        assertEquals(sistema.obterEstoqueGeral(), resultadoEsperado);
    }

    @Test
    public void validarObterPedido() {
        int idPedido = 0014;

        String pedido = sistema.obterPedido(idPedido);

        String resultadoEsperado = "{id: " + idPedido + ", data: '01/01/2020', itens: [...], finalizado: true}";
        assertEquals(pedido, resultadoEsperado);
    }

    @Test
    public void validarListaDePedidos() {
        String resultadoEsperado = "[{id: 1457, data: '01/01/2020', itens: [...], finalizado: true}, {id: 1459, data: '15/10/2020', itens: [...], finalizado: true}]";
        assertEquals(sistema.obterListaDePedidos(), resultadoEsperado);
    }
}
