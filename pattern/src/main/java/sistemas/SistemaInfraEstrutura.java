package sistemas;

public class SistemaInfraEstrutura {
    public SistemaInfraEstrutura() {
    }

    public String criarSala() {
        return "{id: '0235', numero: '0125', andar: '10'}";
    }

    public String alocarAtividadeParaSala(int idSala, String atividade, String horario, String diaDaSemana) {
        return "{sala: '" + idSala + "', numero: '0057', andar: '4', " + "atividade: '" + atividade + "', horário: '"
                + horario + "', dia: '" + diaDaSemana + "'}";
    }

    public String obterHorariosDaSala(int idSala) {
        return "{idSala: '" + idSala + "', numero: '0024', andar: '1', horarios: [...]}";
    }

    public String obterSalasComHorarioDisponivel() {
        return "[{ sala: '0011', andar: '1', horarios: [...] }, { sala: '0055', andar: '3', horarios: [...] }]";
    }
}
