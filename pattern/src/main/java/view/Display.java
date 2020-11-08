package view;

import model.Onibus;
/**
 * Display
 */
public interface Display {
    public int getId();
    public String gerarStringOnibus(Onibus onibus);
}