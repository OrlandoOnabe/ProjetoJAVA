package model;



public class Investidor extends Pessoa{
    public Investidor() {
    }

    public Investidor(String nome, String CPF, String senha) {
        super(CPF, nome, senha);
    }
    
}
