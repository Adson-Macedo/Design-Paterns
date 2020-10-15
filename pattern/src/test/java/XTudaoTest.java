import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import domain.QueijoPrato;
import domain.XTudao;
import domain.OvoDeCapoeira;
import domain.PaoBola;
import domain.PaoIF;
import domain.PresuntoDePeru;
import domain.Recheio;
import domain.Tomate;

public class XTudaoTest {
    @Test
    public void verificaMontaRecheio(){
        XTudao xTudao = new XTudao();

        Recheio recheio = xTudao.montaRecheio();
        Recheio outroRecheio = new Recheio();

        outroRecheio.setQueijo(new QueijoPrato());
        outroRecheio.setPresunto(new PresuntoDePeru());
        outroRecheio.setOvo(new OvoDeCapoeira());
        outroRecheio.setTomate(new Tomate());

        assertEquals(recheio, outroRecheio);
    }

    @Test
    public void verificaCriaFatiaDePao(){
        XTudao xTudao = new XTudao();

        PaoIF pao = xTudao.criaFatiaDePao();
        PaoIF outroPao = new PaoBola();

        assertEquals(pao, outroPao);
    }
}
