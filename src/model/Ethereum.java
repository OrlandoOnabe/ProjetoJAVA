package model;


public class Ethereum extends Moedas{

    public Ethereum() {
    }

    
    public void exibirInformacoes(){
        System.out.println("-----INFORMACOES SOBRE A MOEDA-----");
        System.out.println("Taxa de Compra : 1%");
        System.out.println("Taxa de Venda : 2%");
        
        System.out.println("----VALOR DA MOEDA----");
        System.out.println("1 BRL (Real brasileiro = 0,000070 ETH (Ethereum)");
        
        //Seria bom adicionar uma função aqui para receber o valor da moeda atualizada
        //tipo:
        
        /*public Conversao(){
            ValorConvertido = Real * 0.000070;
        }    
        */
    }
    
}
