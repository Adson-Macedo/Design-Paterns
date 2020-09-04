package domain.funcionarios;

import domain.Pessoa;

public class Diretor extends Cargo {
    public Diretor(Pessoa pessoa) {
        super(pessoa);
    }

    @Override
    public String getFuncao() {
        return "Diretor";
    }
}
