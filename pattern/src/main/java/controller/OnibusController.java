package controller;

import java.util.ArrayList;
import java.util.List;

import model.Onibus;
import model.Passageiro;

/**
 * OnibusController
 */
public class OnibusController {
    //  Repository
    private List<Onibus> frota;

    OnibusController() {
        this.frota = new ArrayList<>();
    }

    public void adicionarOnibus(Onibus onibus) throws Exception {
        this.frota.add(onibus);
    }

    public void reservarPassagem(Onibus onibus, int numeroAcento, Passageiro passageiro) throws Exception {
        onibus.reservarAcento(numeroAcento, passageiro);
    }

    public void comprarPassagem(Onibus onibus, int numeroAcento, Passageiro passageiro) throws Exception {
        onibus.comprarAcento(numeroAcento, passageiro);
    }

    protected Onibus getOnibusById(int idOnibus) throws Exception {
        for (Onibus onibus : frota) {
            if (onibus.getId() == idOnibus) {
                return onibus;
            }
        }
        return null;
    }
}