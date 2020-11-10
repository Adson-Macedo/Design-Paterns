package view;

import java.util.List;

import model.Onibus;
/**
 * Display
 */
public interface Display {
    public int getId();
    public String gerarStringOnibus(Onibus onibus);
    public List<String> getLog();
}