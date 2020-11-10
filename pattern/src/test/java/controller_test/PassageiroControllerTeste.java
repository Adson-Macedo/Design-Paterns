package controller_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import controller.PassageiroController;
import model.Passageiro;

public class PassageiroControllerTeste {

    PassageiroController controller = new PassageiroController();
    Passageiro passageiro = new Passageiro("Thairam", "111.222.333-44");

    @Test
    public void verificarAdicionarPassageiro() throws Exception {
        assertTrue(controller.adicionarPassageiro(passageiro));
    }

    @Test
    public void verificarAdicionarPassageiroDuplicado() throws Exception {
        assertTrue(controller.adicionarPassageiro(passageiro));
        
        Exception exception = assertThrows(Exception.class, () -> {
            controller.adicionarPassageiro(passageiro);
        });

        assertEquals("CPF já cadastrado", exception.getMessage());
    }

    @Test
    public void verificarGetPassageiroByCPF() throws Exception {
        controller.adicionarPassageiro(passageiro);
        assertEquals(controller.getPassageiroByCPF("111.222.333-44").getNome(), "Thairam");
        
        assertEquals(controller.getPassageiroByCPF("000.000.000-00"), null);
    }
}
