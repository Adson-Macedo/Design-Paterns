import org.junit.jupiter.api.Test;

import sistemas.SistemaFinanceiro;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SistemaFinanceiroTeste {
    @Test
    public void voidVerificarCadastrarDespesa() {
        SistemaFinanceiro sistemaFinanceiro = new SistemaFinanceiro();

        String resposta = new String("{data: '01/01/2020', valor: 'R$ 1000.00'}");
        assertEquals(resposta, sistemaFinanceiro.cadastrarDespesa("01/01/2020", 1000));
    }

    @Test
    public void voidVerificarCadastrarReceita() {
        SistemaFinanceiro sistemaFinanceiro = new SistemaFinanceiro();

        String resposta = new String("{data: '10/01/2020', valor: 'R$ 1500.00'}");
        assertEquals(resposta, sistemaFinanceiro.cadastrarDespesa("10/01/2020", 1500));
    }
    
}