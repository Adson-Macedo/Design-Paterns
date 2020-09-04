package domain.funcionarios;

import domain.Pessoa;

public class Ator extends Cargo {
    public Ator(Pessoa pessoa) {
        super(pessoa);
    }

    @Override
    public String getFuncao() {
        return "Ator";
    }
}
