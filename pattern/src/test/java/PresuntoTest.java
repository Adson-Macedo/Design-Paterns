import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import domain.PresuntoDeFrango;
import domain.PresuntoDePeru;
import domain.PresuntoIF;
import domain.SemPresunto;

public class PresuntoTest {
    @Test
    public void verificaSemPresunto() {
        PresuntoIF semPresunto = new SemPresunto();
        assertEquals("Sem Presunto", semPresunto.getTipoPresunto());
    }

    @Test
    public void verificaPresuntoDeFrango(){
        PresuntoIF presuntoDeFrango = new PresuntoDeFrango();
        assertEquals("Presunto de Frango", presuntoDeFrango.getTipoPresunto());
    }

    @Test
    public void verificaPresuntoDePeru(){
        PresuntoIF presuntoDePeru = new PresuntoDePeru();
        assertEquals("Presunto de Peru", presuntoDePeru.getTipoPresunto());
    }

}
