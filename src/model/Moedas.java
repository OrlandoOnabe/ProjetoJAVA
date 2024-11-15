package model;


public class Moedas{
    public double saldo, cotacao, taxacompra, taxavenda;
    public String tipo;
    
    public Moedas() {
    }

    public Moedas(double saldo, double cotacao, String tipo, double taxacompra, double taxavenda) {
        this.saldo = saldo;
        this.cotacao = cotacao;
        this.taxacompra = taxacompra;
        this.taxavenda = taxavenda;
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

    public double getTaxacompra() {
        return taxacompra;
    }

    public void setTaxacompra(double taxacompra) {
        this.taxacompra = taxacompra;
    }

    public double getTaxavenda() {
        return taxavenda;
    }

    public void setTaxavenda(double taxavenda) {
        this.taxavenda = taxavenda;
    }
    
    
}
