package view_test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import controller.listener.OnibusListener;
import model.Onibus;
import model.Passageiro;
import view.Painel;
import view.Quiosque;
import view.Display;

public class DisplayTeste {
    private static Onibus o1;
    private static Onibus o2;

    @BeforeAll
    public static void setup() throws Exception{
        o1 = new Onibus(10, "Campina - Lagoa Seca");
        o2 = new Onibus(10, "Lagoa Seca - Campina");
    }

    @Test
    public void verificaPainel() throws Exception{
        OnibusListener painel = new Painel();
        Passageiro passageiro = new Passageiro("Joaozinho", "12345678910");
        
        o1.addListener(painel);
        o2.addListener(painel);

        o1.reservarAcento(5, passageiro);
        o2.comprarAcento(8, passageiro);
        o1.cancelarReserva(5);

        String [] expectedLogs = new String[]{
            "passagem reservada no onibus 001",
            "passagem comprada no onibus 002",
            "reserva cancelada no onibus 001"
        };

        assertArrayEquals(expectedLogs, ((Display) painel).getLog().toArray());

    }

    @Test
    public void verificaQuiosque() throws Exception{
        OnibusListener quiosque = new Quiosque();
        Passageiro passageiro = new Passageiro("Joaozinho", "12345678910");
        
        o1.addListener(quiosque);
        o2.addListener(quiosque);

        o1.reservarAcento(4, passageiro);
        o2.comprarAcento(7, passageiro);
        o1.cancelarReserva(4);

        String [] expectedLogs = new String[]{
            "passagem reservada no onibus 001",
            "passagem comprada no onibus 002",
            "reserva cancelada no onibus 001"
        };

        assertArrayEquals(expectedLogs, ((Display) quiosque).getLog().toArray());
    }
    
}
