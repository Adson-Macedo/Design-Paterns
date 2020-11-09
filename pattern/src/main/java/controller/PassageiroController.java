package controller;

import java.util.HashMap;
import java.util.Map;

import model.Passageiro;

/**
 * PassageiroController
 */
public class PassageiroController {
    //  Repository
    private Map<String, Passageiro> passageiros;

    public PassageiroController() {
        this.passageiros = new HashMap<>();
    }

    public Passageiro getPassageiroByCPF(String cpf) {
        return this.passageiros.get(cpf);
    }

    public void adicionarPassageiro(Passageiro passageiro) throws Exception {
        if (this.passageiros.get(passageiro.getCpf()) != null)
            throw new Exception("CPF já cadastrado");
        this.passageiros.put(passageiro.getCpf(), passageiro);
    }
}