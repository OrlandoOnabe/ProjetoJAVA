package model;

public class Investidor extends Pessoa {
    private Carteira carteira;
    
    public Investidor() {
    }

    public Investidor(String nome, String CPF, double senha, Carteira carteira) {
        super(CPF, nome, senha);
        this.carteira = carteira;
    }

    public Carteira getCarteira() {
        return carteira;
    }

    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }
}
