package view;

import controller.listener.OnibusListener;
import model.Onibus;
import model.OnibusEvent;
import utils.Colors;

public class Quiosque implements OnibusListener, Display {
    public static int contador = 200000;
    private int id;

    @Override
    public String gerarStringOnibus(Onibus onibus) {
        String lista = String.format("Onibus %03d - %s (Quiosque: %d)\n", onibus.getId(), onibus.getRota(), this.id);

        for (int i = 1; i <= onibus.getAcentos().length; i++) {
            lista += String.format("%sAcento %03d - %s\n", 
                Colors.getStatusColor(onibus.getStatusAcento(i)),
                    onibus.getAcentos()[i-1].getId(), onibus.getStatusAcentoTexto(i));
        }
        lista += Colors.ANSI_RESET;

        return lista;
    }

    public Quiosque() {
        this.id = ++contador;
    }

    @Override
    public int getId() {
        return this.id;
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
}
