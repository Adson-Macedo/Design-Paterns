package model;

import java.util.ArrayList;
import java.util.List;

import controller.listener.OnibusListener;

public class Onibus {
    private static int contador = 0;
    private int id;
    private String rota;
    private Acento acentos[];
    
    public static final String STATUS[] = { "Disponível", "Reservado", "Vendido" };

    private List<OnibusListener> listeners; // map

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
            listenersClone = new ArrayList<>(this.listeners);
        }

        OnibusEvent event = new OnibusEvent(this);
        for (OnibusListener listener : listenersClone) {
            listener.passagemReservada(event);
        }
    }

    public synchronized boolean reservarAcento(int numeroAcento, Passageiro passageiro) throws Exception {
        validarNumeroAcento(numeroAcento);
        
        this.acentos[numeroAcento - 1].reservar(passageiro);
        notifyEvent();

        return true;
    }

    public synchronized boolean comprarAcento(int numeroAcento, Passageiro passageiro) throws Exception {
        validarNumeroAcento(numeroAcento);
        
        this.acentos[numeroAcento - 1].comprar(passageiro);
        notifyEvent();
        
        return true;
    }

    public synchronized boolean cancelarReserva(int numeroAcento) throws Exception {
        validarNumeroAcento(numeroAcento);
        
        this.acentos[numeroAcento - 1].cancelarReserva();
        notifyEvent();
        
        return true;
    }

    public int getNumeroAcentos() {
        return this.acentos.length;
    }

    public int getStatusAcento(int numeroAcento) throws Exception {
        validarNumeroAcento(numeroAcento);
        return this.acentos[numeroAcento - 1].getStatus();
    }

    public String getStatusAcentoTexto(int numeroAcento) throws Exception{
        validarNumeroAcento(numeroAcento);
        
        return STATUS[this.acentos[numeroAcento - 1].getStatus()];
    }

    public synchronized void addListener(OnibusListener listener) {
        if (!this.listeners.contains(listener))
            this.listeners.add(listener);
    }

    private void validarNumeroAcento(int numeroAcento) throws Exception{
        if (numeroAcento < 1 || numeroAcento > getNumeroAcentos())
            throw new Exception("Número de acento inválido");
    }

}
