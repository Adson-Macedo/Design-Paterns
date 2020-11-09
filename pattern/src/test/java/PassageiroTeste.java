import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import model.Passageiro;

public class PassageiroTeste {

    @Test
    public void verificarConstrutor() {
        Passageiro passageiro = new Passageiro("Thairam", "111.222.333-44");
        assertTrue(passageiro.getId() > 0);
        assertEquals(passageiro.getNome(), "Thairam");
        assertEquals(passageiro.getCpf(), "111.222.333-44");
    }

    @Test
    public void verificarEquals() {
        Passageiro passageiro = new Passageiro("Thairam", "111.222.333-44");
        Passageiro passageiro2 = new Passageiro("Adson", "444.555.666-77");

        assertTrue(passageiro.equals(passageiro));
        assertFalse(passageiro.equals(passageiro2));
    }
}
