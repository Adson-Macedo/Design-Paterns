import org.junit.jupiter.api.Test;

import sistemas.SistemaFinanceiro;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SistemaFinanceiroTeste {
    SistemaFinanceiro sistemaFinanceiro = new SistemaFinanceiro();

    @Test
    public void voidVerificarCadastrarDespesa() {
        String resultadoEsperado = new String("{data: '01/01/2020', valor: 'R$ 1000.00'}");
        assertEquals(resultadoEsperado, sistemaFinanceiro.cadastrarDespesa("01/01/2020", 1000));
    }

    @Test
    public void voidVerificarCadastrarReceita() {
        String resultadoEsperado = new String("{data: '10/01/2020', valor: 'R$ 1500.00'}");
        assertEquals(resultadoEsperado, sistemaFinanceiro.cadastrarDespesa("10/01/2020", 1500));
    }

    @Test
    public void voidObterFolhaDePagamento() {
        String resultadoEsperado = new String(
                "[{nome: 'professor1', salario: 'R$ 8.382.85'}, {nome: 'professor2', salario: 'R$ 3.000.00'}]");
        assertEquals(resultadoEsperado, sistemaFinanceiro.obterFolhaDePagamento());
    }

    @Test
    public void voidObterBalanco() {
        int mes = 9;
        int ano = 2020;

        String resultadoEsperado = new String("{ mes: '" + mes + "', ano: '" + ano + "', dados: [...] }");
        assertEquals(resultadoEsperado, sistemaFinanceiro.obterBalanco(mes, ano));
    }
}