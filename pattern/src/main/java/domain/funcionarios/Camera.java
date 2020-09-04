package domain.funcionarios;

import domain.Pessoa;

public class Camera extends Cargo {
    public Camera(Pessoa pessoa) {
        super(pessoa);
    }

    @Override
    public String getFuncao() {
        return "Camera";
    }
}
