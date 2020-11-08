package view;

import controller.listener.OnibusListener;
import model.Onibus;
import model.OnibusEvent;
import utils.Colors;

public class Painel implements OnibusListener, Display {
    private static int contador = 100000;
    private int id;

    public Painel() {
        this.id = ++contador;
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
        for (int i = 1; i <= onibus.getNumeroAcentos(); i += 2) {
            primeiraFila += Colors.getStatusColor(onibus.getStatusAcento(i)).concat(String.format("%02d ", i));
        }
        primeiraFila = primeiraFila.concat(Colors.ANSI_RESET).concat("|\n");

        String segundaFila = "|M |";
        for (int i = 2; i <= onibus.getNumeroAcentos(); i += 2) {
            segundaFila += Colors.getStatusColor(onibus.getStatusAcento(i)).concat(String.format("%02d ", i));
        }
        segundaFila = segundaFila.concat(Colors.ANSI_RESET).concat("|\n");

        return descricao.concat(lateral).concat(primeiraFila).concat(segundaFila).concat(lateral);
    }

    @Override
    public void reservaCancelada(OnibusEvent e) {
        System.out.println(gerarStringOnibus((Onibus) e.getSource()));
    }

    @Override
    public void passagemReservada(OnibusEvent e) {
        System.out.println(gerarStringOnibus((Onibus) e.getSource()));
    }

    @Override
    public void passagemComprada(OnibusEvent e) {
        System.out.println(gerarStringOnibus((Onibus) e.getSource()));
    }

    @Override
    public int getId() {
        return this.id;
    }
}