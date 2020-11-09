package controller;

import java.util.HashMap;
import java.util.Map;

import model.Onibus;
import model.Passageiro;

/**
 * OnibusController
 */
public class OnibusController {
    //  Repository
    private Map<Integer, Onibus> frota;

    public OnibusController() {
        this.frota = new HashMap<>();
    }

    public boolean adicionarOnibus(Onibus onibus) throws Exception {
        if (frota.get(onibus.getId()) != null)
            throw new Exception("Onibus já cadastrado");
        
        this.frota.put(onibus.getId(), onibus);
        
        return true;
    }

    public boolean reservarPassagem(Onibus onibus, int numeroAcento, Passageiro passageiro) throws Exception {
        return onibus.reservarAcento(numeroAcento, passageiro);
    }

    public boolean comprarPassagem(Onibus onibus, int numeroAcento, Passageiro passageiro) throws Exception {
        return onibus.comprarAcento(numeroAcento, passageiro);
    }

    public boolean cancelarReserva(Onibus onibus, int numeroAcento) throws Exception {
        return onibus.cancelarReserva(numeroAcento);
    }

    protected Onibus getOnibusById(int idOnibus) throws Exception {
        return frota.get(idOnibus);
    }
}