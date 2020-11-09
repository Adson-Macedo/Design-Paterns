package controller_test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import controller.OnibusController;
import model.Onibus;

public class OnibusControllerTeste {
    public OnibusController controller;

    @BeforeAll
    public void setup(){
        this.controller = new OnibusController();
    }

    @Test
    public void verificaAdicionarOnibus(){
        try{
            Onibus onibus = new Onibus(10, "Campina Grande - Lagoa Seca");
            assertTrue(controller.adicionarOnibus(onibus));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
