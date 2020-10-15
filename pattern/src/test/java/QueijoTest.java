import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import domain.QueijoCheddar;
import domain.QueijoIF;
import domain.QueijoMussarela;
import domain.QueijoPrato;
import domain.SemQueijo;

public class QueijoTest {
    @Test
    public void verificaSemQueijo(){
        QueijoIF semQueijo = new SemQueijo();
        assertEquals("Sem Queijo", semQueijo.getTipoQueijo());
    }

    @Test
    public void verificaQueijoMussarela(){
        QueijoIF queijoMussarela = new QueijoMussarela();
        assertEquals("Queijo Mussarela", queijoMussarela.getTipoQueijo());
    }

    @Test
    public void verificaQueijoPrato(){
        QueijoIF queijoPrato = new QueijoPrato();
        assertEquals("Queijo Prato", queijoPrato.getTipoQueijo());
    }

    @Test
    public void verificaQueijoCheddar(){
        QueijoIF queijoCheddar = new QueijoCheddar();
        assertEquals("Queijo Cheddar", queijoCheddar.getTipoQueijo());
    }
}
