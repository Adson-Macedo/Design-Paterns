package utils;

public abstract class Validation {
    public static void validarAltura(int altura) throws Exception{
        if (altura <= 0) throw new Exception(Messages.MSG_ALTURA_INVALIDA);
    }

    public static void validarLargura(int largura) throws Exception{
        if (largura <= 0) throw new Exception(Messages.MSG_LARGURA_INVALIDA);
    }

    public static void validarRaio(double raio) throws Exception{
        if (raio <= 0) throw new Exception(Messages.MSG_RAIO_INVALIDO);
    }

    public static void validarLado(int lado) throws Exception{
        if (lado <= 0) throw new Exception(Messages.MSG_LADO_INVALIDO);
    }

    public static void validarIndex(int index, int size) throws Exception{
        if (index < 0 || index >= size) throw new Exception(Messages.MSG_INDEX_INVALIDO);
    }
}