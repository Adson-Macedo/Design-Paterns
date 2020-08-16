package domain;

import utils.Utils;
import utils.Messages;

public class Aula implements Comparable<Aula> {
    private String horarioAula;
    private String diaDaSemana;
    private Disciplina disciplina;

    public Aula(String horarioAula, String diaDaSemana, Disciplina disciplina) throws Exception {
        if (!horarioAula.matches(Utils.REGEX_HORA)) {
            throw new Exception(Messages.MSG_FORMATO_DE_HORARIO_INVALIDO_EXCEPTION);
        }

        this.horarioAula = horarioAula;
        this.diaDaSemana = diaDaSemana;

        if (Utils.getNumeroDia(diaDaSemana) == -1) {
            throw new Exception(Messages.MSG_DIA_DA_SEMANA_INVALIDO_EXCEPTION);
        }

        this.disciplina = disciplina;
    }

    public void setHorarioAula(String horarioAula) {
        this.horarioAula = horarioAula;
    }

    public String getHorarioAula() {
        return horarioAula;
    }

    public void setDiaDaSemana(String diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public String getDiaDaSemana() {
        return diaDaSemana;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }
    
    public String toString(){
        return diaDaSemana + "\t" + horarioAula + "\t" + disciplina.getDescricao();
    }

    @Override
    public int compareTo(Aula aula) {
        int numDia1 = Utils.getNumeroDia(this.diaDaSemana);
        int numDia2 = Utils.getNumeroDia(aula.diaDaSemana);

        if (numDia1 < numDia2) return -1;
        if (numDia1 > numDia2) return  1;

        return this.horarioAula.compareTo(aula.horarioAula);
    }

}