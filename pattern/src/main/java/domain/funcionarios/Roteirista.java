package domain.funcionarios;

import domain.Pessoa;

public class Roteirista extends Cargo {
    public Roteirista(Pessoa pessoa) {
        super(pessoa);
    }

    @Override
    public String getFuncao() {
        return "Roteirista";
    }
}
