import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import domain.PaoBola;
import domain.PaoFrances;
import domain.PaoIF;
import domain.PaoIntegral;

public class PaoTest {
    @Test
    public void verificaPaoFrances(){
        PaoIF paoFrances = new PaoFrances();
        assertEquals("Fatia de Pao Frances", paoFrances.getTipoPao());
    }

    @Test
    public void verificaPaoBola(){
        PaoIF paoBola = new PaoBola();
        assertEquals("Fatia de Pao Bola", paoBola.getTipoPao());
    }

    @Test
    public void verificaPaoIntegral(){
        PaoIF paoIntegral = new PaoIntegral();
        assertEquals("Fatia de Pao Integral", paoIntegral.getTipoPao());
    }
}
