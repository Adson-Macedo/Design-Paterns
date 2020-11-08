package controller;

import java.util.ArrayList;
import java.util.List;

import model.Passageiro;

/**
 * PassageiroController
 */
public class PassageiroController {
    private List<Passageiro> passageiros;

    public PassageiroController() {
        this.passageiros = new ArrayList<>();
    }

    public Passageiro getPassageiroByCPF(String cpf) throws Exception {
        for (Passageiro passageiro : passageiros) {
            if (passageiro.getCpf().equals(cpf)) {
                return passageiro;
            }
        }

        return null;
    }

    public void adicionarPassageiro(Passageiro passageiro) throws Exception {
        this.passageiros.add(passageiro);
    }
}