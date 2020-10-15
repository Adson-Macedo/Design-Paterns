import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import domain.SemTomate;
import domain.Tomate;
import domain.TomateIF;

public class TomateTest {
    @Test
    public void verificaSemTomate(){
        TomateIF semTomate = new SemTomate();
        assertEquals("Sem Tomate", semTomate.getTipoTomate());
    }

    @Test
    public void verificaTomate(){
        TomateIF tomate = new Tomate();
        assertEquals("Tomate", tomate.getTipoTomate());
    }
}
