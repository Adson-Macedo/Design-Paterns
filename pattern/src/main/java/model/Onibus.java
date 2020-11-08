package model;

import java.util.ArrayList;
import java.util.List;

import controller.listener.OnibusListener;

public class Onibus {
    private static int contador = 0;
    private int id;
    private String rota;
    private Acento acentos[];

    private List<OnibusListener> listeners;

    public Onibus(int qtdAcentos, String rota) throws Exception {
        if (qtdAcentos % 2 == 1)
            throw new Exception("Número de acentos precisa ser par");
        if (qtdAcentos < 1 || qtdAcentos > 98)
            throw new Exception("Número de acentos precisa estar entre 2 e 98");

        this.id = ++contador;
        this.rota = rota;
        this.acentos = new Acento[qtdAcentos];

        for (int i = 0; i < qtdAcentos; i++)
            acentos[i] = new Acento();

        this.listeners = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRota() {
        return rota;
    }

    public void setRota(String rota) {
        this.rota = rota;
    }

    public Acento[] getAcentos() {
        return acentos;
    }

    private synchronized void notifyEvent() {
        List<OnibusListener> listenersClone;
        synchronized (this) {
            listenersClone = (List) ((ArrayList) this.listeners).clone();
        }

        OnibusEvent event = new OnibusEvent(this);
        for (OnibusListener listener : listenersClone) {
            listener.passagemReservada(event);
        }
    }

    public synchronized void reservarAcento(int numAcento, Passageiro passageiro) throws Exception {
        this.acentos[numAcento - 1].reservar(passageiro);
        notifyEvent();
    }

    public synchronized void comprarAcento(int numAcento, Passageiro passageiro) throws Exception {
        this.acentos[numAcento - 1].comprar(passageiro);
        notifyEvent();
    }

    public synchronized void cancelarReserva(int numAcento) throws Exception {
        this.acentos[numAcento - 1].cancelarReserva();
        notifyEvent();
    }

    public int getNumeroAcentos() {
        return this.acentos.length;
    }

    public int getStatusAcento(int numeroAcento) {
        return this.acentos[numeroAcento - 1].getStatus();
    }

    public String getStatusAcentoTexto(int numeroAcento) {
        String status[] = { "Disponível", "Reservado", "Vendido" };
        return status[this.acentos[numeroAcento - 1].getStatus()];
    }

    public synchronized void addListener(OnibusListener listener) {
        if (!this.listeners.contains(listener))
            this.listeners.add(listener);
    }

}
