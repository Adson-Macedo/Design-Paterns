package domain;

import sistemas.SistemaAdministrativo;

public class Sig {
    private SistemaAdministrativo sistemaAdministrativo;
    // private SistemaAlmoxarifado sistemaAlmoxarifado;
    // private SistemaControleAcademico sistemaControleAcademico;
    // private SistemaFinanceiro sistemaFinanceiro;
    // private SistemaInfraEstrutura sistemaInfraEstrutura;

    public Sig(){
        this.sistemaAdministrativo = new SistemaAdministrativo();
        // this.sistemaAlmoxarifado = new SistemaAlmoxarifado();
        // this.sistemaControleAcademico = new SistemaControleAcademico();
        // this.sistemaFinanceiro = new SistemaFinanceiro();
        // this.sistemaInfraEstrutura = new SistemaInfraEstrutura();
    }

    public String agendarReuniaoComDiretoria(String matricula, String horario){
        return sistemaAdministrativo.addReuniao(matricula, horario);
    }

    public String obterAgendaDeReunioes(){
        return sistemaAdministrativo.obterAgendaDeReunioes();
    }

    public String agendarEntrevista(String nomeDoEntrevistado, String horario){
        return sistemaAdministrativo.addReuniao(nomeDoEntrevistado, horario);
    }

    public String obterAgendaDeEntrevistas(){
        return sistemaAdministrativo.obterAgendaDeEntrevistas();
    }
}