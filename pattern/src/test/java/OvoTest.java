import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import domain.OvoDeCapoeira;
import domain.OvoDeGranja;
import domain.OvoIF;
import domain.SemOvo;

public class OvoTest {
    @Test
    public void verificaSemOvo(){
        OvoIF semOvo = new SemOvo();
        assertEquals("Sem Ovo", semOvo.getTipoOvo());
    }

    @Test
    public void verificaOvoDeGranja(){
        OvoIF ovoDeGranja = new OvoDeGranja();
        assertEquals("Ovo de Granja", ovoDeGranja.getTipoOvo());
    }

    @Test
    public void verificaOvoDeCapoeira(){
        OvoIF ovoDeCapoeira = new OvoDeCapoeira();
        assertEquals("Ovo de Capoeira", ovoDeCapoeira.getTipoOvo());
    }

}
