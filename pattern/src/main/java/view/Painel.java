package view;

import java.util.ArrayList;
import java.util.List;

import controller.listener.OnibusListener;
import model.Onibus;
import model.OnibusEvent;
import utils.Colors;

public class Painel implements OnibusListener, Display {
    private static int contador = 100000;
    private List<String> log;
    private int id;

    public Painel() {
        this.id = ++contador;
        this.log = new ArrayList<>();
    }

    @Override
    public String gerarStringOnibus(Onibus onibus) {
        String descricao = String.format("Onibus %03d - %s (Painel: %d)\n", onibus.getId(), onibus.getRota(), this.id);
        String lateral = "+";
        int size = onibus.getNumeroAcentos() / 2 * 3 + 3;
        for (int i = 0; i < size; i++) {
            lateral += "-";
        }
        lateral += "+\n";

        String primeiraFila = "|  |";
        String segundaFila = "|M |";
        
        try{
            for (int i = 1; i <= onibus.getNumeroAcentos(); i += 2) {
                primeiraFila += Colors.getStatusColor(onibus.getStatusAcento(i)).concat(String.format("%02d ", i));
            }
            primeiraFila = primeiraFila.concat(Colors.ANSI_RESET).concat("|\n");

            for (int i = 2; i <= onibus.getNumeroAcentos(); i += 2) {
                segundaFila += Colors.getStatusColor(onibus.getStatusAcento(i)).concat(String.format("%02d ", i));
            }
            segundaFila = segundaFila.concat(Colors.ANSI_RESET).concat("|\n");
        } catch (Exception e) {

        }
        return descricao.concat(lateral).concat(primeiraFila).concat(segundaFila).concat(lateral);
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