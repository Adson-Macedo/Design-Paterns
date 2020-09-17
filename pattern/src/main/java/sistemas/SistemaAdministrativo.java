package sistemas;

public class SistemaAdministrativo {


    public SistemaAdministrativo() {
    }

    public String adicionarReuniao(String matricula, String horario) {
        return "{matricula: '" + matricula + "', horario: '" + horario + "'"+ "}";
    }

    public String adicionarEntrevista(String nomeEntrevistado, String horario) {
        return "{nomeEntrevistado: '" + nomeEntrevistado + "', horario: '" + horario + "'"+ "}";
    }

    public String obterAgendaDeReunioes() {
        return "[{matricula: '12345678', horario: '00:00'},\n{matricula: '87654321', horario: '10:00'}]";
    }

    public String obterAgendaDeEntrevistas() {
        return "[{nomeEntrevistado: 'Fulano de Tal', horario: '00:00'},\n{nomeEntrevistado: 'Tal de Fulano', horario: '10:00'}]";
    }
}
