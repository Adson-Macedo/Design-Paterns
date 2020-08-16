package utils;

public class Utils {
    public static final String REGEX_HORA = "^(([0-1]+[0-9])|([2]+[0-3]))+:[0-5]+[0-9]+$";

    private static final String[] DIAS = new String[] { "Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta",
            "Sábado" };

    public static int getNumeroDia(String dia) {
        for (int i = 0; i < DIAS.length; i++) {
            if (dia.equals(DIAS[i]))
                return i;
        }

        return -1;
    }
}