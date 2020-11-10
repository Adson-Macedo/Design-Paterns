package controller_test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.OnibusController;
import model.Onibus;
import model.Passageiro;

public class OnibusControllerTeste {
    public OnibusController controller;
    
    @BeforeEach
    public void setup() {
        try{
            this.controller = new OnibusController();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    @Test
    public void verificaAdicionarOnibus()  throws Exception{
        Onibus onibus = new Onibus(10, "Campina Grande - Lagoa Seca");
        assertTrue(controller.adicionarOnibus(onibus));
    }
    
    
    @Test
    public void verificarReservarPassagem() throws Exception{
        Onibus onibus = new Onibus(10, "Campina Grande - Lagoa Seca");
        Passageiro passageiro = new Passageiro("12345678910", "Joaozinho");
        
        assertTrue(controller.reservarPassagem(onibus, 10, passageiro));
        assertThrows(Exception.class, () -> controller.reservarPassagem(onibus, 10, passageiro));
    }
    
    @Test
    public void verificarComprarPassagem()  throws Exception{
        Onibus onibus = new Onibus(10, "Campina Grande - Lagoa Seca");
        Passageiro passageiro = new Passageiro("12345678910", "Joaozinho");
        
        assertTrue(controller.comprarPassagem(onibus, 10, passageiro));
        assertThrows(Exception.class, () -> controller.comprarPassagem(onibus, 10, passageiro));
    }
    
    @Test
    public void verificarCancelarReserva()  throws Exception{
        Onibus onibus = new Onibus(10, "Campina Grande - Lagoa Seca");
        Passageiro passageiro = new Passageiro("12345678910", "Joaozinho");
        
        controller.reservarPassagem(onibus, 8, passageiro);
        controller.comprarPassagem(onibus, 7, passageiro);
        assertTrue(controller.cancelarReserva(onibus, 8));
        assertThrows(Exception.class,  () -> controller.cancelarReserva(onibus, 8));
        assertThrows(Exception.class,  () -> controller.cancelarReserva(onibus, 7));
    }


}
