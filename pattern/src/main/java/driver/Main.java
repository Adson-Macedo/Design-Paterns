package driver;

import domain.Sig;

public class Main {
    public static void main(String[] args) {
        Sig sig = new Sig();

        System.out.println(sig.obterAgendaDeReunioes() + '\n');
        System.out.println(sig.obterAgendaDeEntrevistas() + '\n');

        System.out.println(sig.obterBalanco(1, 2020) + '\n');
        System.out.println(sig.obterFolhaDePagamento() + '\n');

        System.out.println(sig.obterDisciplinasDoProfessor("123456789") + '\n');
        System.out.println(sig.obterTempoDeCasaDoProfessor("123456789") + '\n');
        
        
        System.out.println(sig.obterHistoricoDoAluno("123456789") + '\n');
        System.out.println(sig.obterRdmDoAluno("123456789") + '\n');
        
        System.out.println(sig.obterEstoqueAlmoxarifado() + '\n');
        System.out.println(sig.obterPedidoDeCompra(457) + '\n');
        System.out.println(sig.obterListaDePedidosAlmoxarifado() + '\n');
        
        System.out.println(sig.obterAlocacaoDaSala(25) + '\n');


    }
}