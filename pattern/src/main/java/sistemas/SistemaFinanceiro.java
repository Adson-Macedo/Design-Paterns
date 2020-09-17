package sistemas;

public class SistemaFinanceiro {
    public SistemaFinanceiro() {

    }

    public String cadastrarDespesa(String data, double valor) {
        return "{data: '" + data + "', valor: '" + String.format("R$ %.2f", valor) + "'}";
    }

    public String cadastrarReceita(String data, double valor) {
        return "{data: '" + data + "', valor: '" + String.format("R$ %.2f", valor) + "'}";
    }

    public String obterFolhaDePagamento() {
        return "[{nome: 'professor1', salario: 'R$ 8.382.85'}, {nome: 'professor2', salario: 'R$ 3.000.00'}]";
    }

    public String obterBalanco(int mes, int ano) {
        return "{ mes: '" + mes + "', ano: '" + ano + "', dados: [...] }";
    }
}
