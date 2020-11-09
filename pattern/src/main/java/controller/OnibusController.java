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

    public boolean adicionarOnibus(Onibus onibus) throws Exception {
        // if (...)
        this.frota.add(onibus);
        return true;
    }

    public boolean reservarPassagem(Onibus onibus, int numeroAcento, Passageiro passageiro) throws Exception {
        return onibus.reservarAcento(numeroAcento, passageiro);
    }

    public boolean comprarPassagem(Onibus onibus, int numeroAcento, Passageiro passageiro) throws Exception {
        return onibus.comprarAcento(numeroAcento, passageiro);
    }

    // cancelar reserva

    protected Onibus getOnibusById(int idOnibus) throws Exception {
        for (Onibus onibus : frota) {
            if (onibus.getId() == idOnibus) {
                return onibus;
            }
        }
        return null;
    }
}