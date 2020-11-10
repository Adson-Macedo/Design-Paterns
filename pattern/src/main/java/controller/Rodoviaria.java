package controller;

import java.util.ArrayList;
import java.util.List;

import controller.listener.OnibusListener;
import model.Onibus;
import model.Passageiro;
import view.Display;
import view.Painel;
import view.Quiosque;

public class Rodoviaria {
    private static Rodoviaria rodoviaria = null;

    private List<Display> displays;
    private OnibusController onibusController;
    private PassageiroController passageiroController;

    private Rodoviaria() {
        this.onibusController = new OnibusController();
        this.passageiroController = new PassageiroController();

        this.displays = new ArrayList<>();
    }

    public static Rodoviaria getInstace() {
        if (rodoviaria == null) {
            rodoviaria = new Rodoviaria();
        }
        return rodoviaria;
    }

    public boolean adicionarOnibus(int acentos, String rota) throws Exception {
        this.onibusController.adicionarOnibus(new Onibus(acentos, rota));
        return true;
    }

    public boolean adicionarPassageiro(String nome, String cpf) throws Exception {
        if (passageiroController.getPassageiroByCPF(cpf) != null)
            throw new Exception("Passageiro já cadastrado!");

        this.passageiroController.adicionarPassageiro(new Passageiro(nome, cpf));

        return true;
    }

    public boolean adicionarQuiosque() {
        this.displays.add(new Quiosque());
        return true;
    }

    public boolean adicionarPainel() {
        this.displays.add(new Painel());
        return true;
    }

    public boolean reservarPassagem(int idOnibus, int numeroAcento, String cpfPassageiro) throws Exception {
        Onibus onibus = onibusController.getOnibusById(idOnibus);
        if (onibus == null)
            throw new Exception("Onibus não encontrado!");

        Passageiro passageiro = passageiroController.getPassageiroByCPF(cpfPassageiro);
        if (passageiro == null)
            throw new Exception("Passageiro não encontrado!");

        this.onibusController.reservarPassagem(onibus, numeroAcento, passageiro);

        return true;
    }

    public boolean comprarPassagem(int idOnibus, int numeroAcento, String cpfPassageiro) throws Exception {
        Onibus onibus = onibusController.getOnibusById(idOnibus);
        if (onibus == null)
            throw new Exception("Onibus não encontrado!");

        Passageiro passageiro = passageiroController.getPassageiroByCPF(cpfPassageiro);
        if (passageiro == null)
            throw new Exception("Passageiro não encontrado!");

        this.onibusController.comprarPassagem(onibus, numeroAcento, passageiro);

        return true;
    }

    private Display getListenerById(int idDisplay) {
        for (Display display : displays) {
            if (display.getId() == idDisplay)
                return display;
        }

        return null;
    }

    public boolean addListenerTo(int idListener, int idOnibus) throws Exception {
        Onibus onibus = onibusController.getOnibusById(idOnibus);
        OnibusListener listener = (OnibusListener) getListenerById(idListener);

        if (onibus == null)
            throw new Exception("Onibus não encontrado");
        if (listener == null)
            throw new Exception("Listener não encontrado");

        onibus.addListener(listener);

        return true;
    }
}