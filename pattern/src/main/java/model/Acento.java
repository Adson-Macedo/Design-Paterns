package model;

public class Acento {
    public static final int DISPONIVEL = 0;
    public static final int RESERVADO = 1;
    public static final int VENDIDO = 2;

    private static int contador = 0;
    private int id;
    private Passageiro passageiro;
    private int status;

    public Acento() {
        this.id = ++contador;
        this.status = DISPONIVEL;
        this.passageiro = null;
    }

    public int getId() {
        return id;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public int getStatus() {
        return status;
    }

    private void setStatus(int status) {
        this.status = status;
    }

    public void reservar(Passageiro passageiro) throws Exception{
        if (this.getStatus() != DISPONIVEL)
            throw new Exception("Não foi possível realizar a reserva: acento já reservado ou vendido!");
        
        this.setPassageiro(passageiro);
        this.setStatus(RESERVADO);
    }

    public void comprar(Passageiro passageiro) throws Exception{
        if (this.getStatus() == VENDIDO || (this.getStatus() == RESERVADO && !this.passageiro.equals(passageiro)))
            throw new Exception("Não foi possível realizar a venda: acento reservado/vendido para outro passageiro!");

        this.setPassageiro(passageiro);
        this.setStatus(VENDIDO);
    }

    public void cancelarReserva() throws Exception{
        if (this.getStatus() != RESERVADO)
            throw new Exception("Não foi possível cancelar a reserva: acento não reservado ou vendido");

        this.passageiro = null;
        this.setStatus(DISPONIVEL);
    }
}
