package view;

import java.util.ArrayList;
import java.util.List;

import controller.listener.OnibusListener;
import model.Onibus;
import model.OnibusEvent;
import utils.Colors;

public class Quiosque implements OnibusListener, Display {
    public static int contador = 200000;
    private List<String> log;
    private int id;

    @Override
    public String gerarStringOnibus(Onibus onibus) {
        String lista = String.format("Onibus %03d - %s (Quiosque: %d)\n", onibus.getId(), onibus.getRota(), this.id);

        try {
            for (int i = 1; i <= onibus.getAcentos().length; i++) {
                lista += String.format("%sAcento %03d - %s\n", Colors.getStatusColor(onibus.getStatusAcento(i)),
                        onibus.getAcentos()[i - 1].getId(), onibus.getStatusAcentoTexto(i));
            }
            lista += Colors.ANSI_RESET;
        } catch (Exception e) {

        }
        return lista;
    }

    public Quiosque() {
        this.id = ++contador;
        this.log = new ArrayList<>();
    }

    @Override
    public void reservaCancelada(OnibusEvent e) {
        Onibus onibus = (Onibus) e.getSource();
        
        this.log.add(String.format("reserva cancelada no onibus %03d", onibus.getId()));
        System.out.println("Evento: Reserva Cancelada");
        System.out.println(gerarStringOnibus(onibus));
    }
    
    @Override
    public void passagemReservada(OnibusEvent e) {
        Onibus onibus = (Onibus) e.getSource();
        
        this.log.add(String.format("passagem reservada no onibus %03d", onibus.getId()));
        System.out.println("Evento: Passagem Reservada");
        System.out.println(gerarStringOnibus(onibus));
    }
    
    @Override
    public void passagemComprada(OnibusEvent e) {
        Onibus onibus = (Onibus) e.getSource();
        
        this.log.add(String.format("passagem comprada no onibus %03d", onibus.getId()));
        System.out.println("Evento: Passagem Comprada");
        System.out.println(gerarStringOnibus(onibus));
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public List<String> getLog() {
        return this.log;
    }
}
