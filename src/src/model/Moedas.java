package model;


public class Moedas{
    public double saldo, cotacao;
    public String tipo;
    
    public Moedas() {
    }

    public Moedas(double saldo, double cotacao, String tipo) {
        this.saldo = saldo;
        this.cotacao = cotacao;
        this.tipo = tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getCotacao() {
        return cotacao;
    }

    public void setCotacao(double cotacao) {
        this.cotacao = cotacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
