package domain;

import sistemas.*;

public class Sig {
    private SistemaAdministrativo sistemaAdministrativo;
    private SistemaAlmoxarifado sistemaAlmoxarifado;
    private SistemaControleAcademico sistemaControleAcademico;
    private SistemaFinanceiro sistemaFinanceiro;
    private SistemaInfraEstrutura sistemaInfraEstrutura;

    public Sig(){
        this.sistemaAdministrativo = new SistemaAdministrativo();
        this.sistemaAlmoxarifado = new SistemaAlmoxarifado();
        this.sistemaControleAcademico = new SistemaControleAcademico();
        this.sistemaFinanceiro = new SistemaFinanceiro();
        this.sistemaInfraEstrutura = new SistemaInfraEstrutura();
    }

    public String obterAgendaDeReunioes(){
        return "Agenda de Reuniões:\n" + sistemaAdministrativo.obterAgendaDeReunioes();
    }

    public String obterAgendaDeEntrevistas(){
        return "Agenda de Entrevistas:\n" + sistemaAdministrativo.obterAgendaDeEntrevistas();
    }

    public String obterBalanco(int mes, int ano) {
        return "Balanco financeiro:\n" + sistemaFinanceiro.obterBalanco(mes, ano);
    }
    
    public String obterFolhaDePagamento(){
        return "Folha de Pagamento: \n" + sistemaFinanceiro.obterFolhaDePagamento();
    }

    public String obterEstoqueAlmoxarifado(){
        return "Estoque Almoxarifado: \n" + sistemaAlmoxarifado.obterEstoqueGeral();
    }

    public String obterListaDePedidosAlmoxarifado() {
        return "Pedidos de compra para o Almoxarifado: \n" + sistemaAlmoxarifado.obterListaDePedidos();
    }

    public String obterPedidoDeCompra(int idPedido) {
        return "Pedido de compra: \n" + sistemaAlmoxarifado.obterPedido(idPedido);
    }

    public String obterAlocacaoDaSala(int idSala) {
        return "Alocação da sala: \n" + sistemaInfraEstrutura.obterHorariosDaSala(idSala);
    }

    public String obterTempoDeCasaDoProfessor(String matriculaProfessor){
        return "Tempo de casa do professor: " + sistemaControleAcademico.obterTempoDeCasaDoProfessor(matriculaProfessor);
    }

    public String obterDisciplinasDoProfessor(String matriculaProfessor){
        return "Disciplinas do professor: " + sistemaControleAcademico.obterDisciplinasDoProfessor(matriculaProfessor);
    }

    public String obterRdmDoAluno(String matriculaAluno){
        return "RDM do Aluno: " + sistemaControleAcademico.obterRdmDoAluno(matriculaAluno);
    }

    public String obterHistoricoDoAluno(String matriculaAluno){
        return "Historico do Aluno: " + sistemaControleAcademico.obterHistoricoDoAluno(matriculaAluno);
    }
}