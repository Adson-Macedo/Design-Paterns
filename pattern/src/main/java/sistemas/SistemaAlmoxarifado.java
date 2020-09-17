package sistemas;

public class SistemaAlmoxarifado {
    public SistemaAlmoxarifado() {
    }

    public String criarPedido() {
        return "{id: 1457, data: '01/01/2020', itens: [], finalizado: false}";
    }

    public String criarProduto(String descricao, int estoqueInicial) {
        return "{id: 0001, descricao: '" + descricao + "', estoque: " + estoqueInicial + "}";
    }

    public String adicionarItemAoPedido(int idPedido, int idProduto, int quantidade) {
        return "{id: " + idPedido + ", data: '01/01/2020', itens: [{idProduto: " +  idProduto + ", quantidade: " + quantidade + "}]}";
    }

    public String finalizarPedido(int idPedido) {
        return "{id: " + idPedido + ", data: '01/01/2020', itens: [...], finalizado: true}";
    }

    public String obterEstoqueGeral() {
        return "[{id: 0001, descricao: 'Produto1', estoque: 3}, {id: 0002, descricao: 'Produto2', estoque: 5}]";
    }

    public String obterPedido(int idPedido) {
        return "{id: " + idPedido + ", data: '01/01/2020', itens: [...], finalizado: true}";
    }

    public String obterListaDePedidos() {
        return "[{id: 1457, data: '01/01/2020', itens: [...], finalizado: true}, {id: 1459, data: '15/10/2020', itens: [...], finalizado: true}]";
    }

}