package controller_test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import controller.Rodoviaria;

public class RodoviaraControllerTeste {

    Rodoviaria rodoviaria = Rodoviaria.getInstace();

    @Test
    public void verificarAdicionarOnibus() throws Exception {
        assertTrue(rodoviaria.adicionarOnibus(60, "CENTRO -> UFCG"));
    }

    @Test
    public void verificarAdicionarPassageiro() throws Exception {
        assertTrue(rodoviaria.adicionarPassageiro("Thairam", "111.222.333-44"));
    }

    @Test
    public void verificarAdicionaQuiosque() throws Exception {
        assertTrue(rodoviaria.adicionarQuiosque());
    }

    @Test
    public void verificarAdicionaPainel() throws Exception {
        assertTrue(rodoviaria.adicionarPainel());
    }

    @Test
    public void verificarReservarPassagem() throws Exception {
        rodoviaria.adicionarOnibus(10, "LS -> CG");
        rodoviaria.adicionarPassageiro("Adson", "555.666.777-88");
        assertTrue(rodoviaria.reservarPassagem(1, 1, "555.666.777-88"));
    }

    @Test
    public void verificarComprarPassagem() throws Exception {
        rodoviaria.adicionarOnibus(20, "CENTRO -> UEPB");
        rodoviaria.adicionarPassageiro("Ramon", "012.345.678-90");

        assertTrue(rodoviaria.comprarPassagem(1, 17, "012.345.678-90"));
    }
}