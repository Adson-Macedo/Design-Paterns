import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import domain.MistoQuente;
import domain.PaoIntegral;
import domain.PresuntoDeFrango;
import domain.PaoIF;
import domain.QueijoMussarela;
import domain.Recheio;

public class MistoQuenteTest {
    @Test
    public void verificaMontaRecheio(){
        MistoQuente mistoQuente = new MistoQuente();

        Recheio recheio = mistoQuente.montaRecheio();
        Recheio outroRecheio = new Recheio();

        outroRecheio.setQueijo(new QueijoMussarela());
        outroRecheio.setPresunto(new PresuntoDeFrango());

        assertEquals(recheio, outroRecheio);
    }

    @Test
    public void verificaCriaFatiaDePao(){
        MistoQuente mistoQuente = new MistoQuente();

        PaoIF pao = mistoQuente.criaFatiaDePao();
        PaoIF outroPao = new PaoIntegral();

        assertEquals(pao, outroPao);
    }
}
