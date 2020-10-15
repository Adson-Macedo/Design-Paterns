import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import domain.OvoDeGranja;
import domain.PaoFrances;
import domain.PaoIF;
import domain.Recheio;
import domain.Sanduiche;

public class SanduicheTest {
    @Test
    public void verificaMontaRecheio(){
        Sanduiche sanduiche = new Sanduiche();

        Recheio recheio = sanduiche.montaRecheio();
        Recheio outroRecheio = new Recheio();

        outroRecheio.setOvo(new OvoDeGranja());

        assertEquals(recheio, outroRecheio);
    }

    @Test
    public void verificaCriaFatiaDePao(){
        Sanduiche sanduiche = new Sanduiche();

        PaoIF pao = sanduiche.criaFatiaDePao();
        PaoIF outroPao = new PaoFrances();

        assertEquals(pao, outroPao);
    }

    
}
