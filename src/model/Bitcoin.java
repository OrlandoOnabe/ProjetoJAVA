package model;


public class Bitcoin extends Moedas{

    public Bitcoin() {
    }
    
    
    public void exibirInformacoes(){
        System.out.println("-----INFORMACOES SOBRE A MOEDA-----");
        System.out.println("Taxa de Compra : 2%");
        System.out.println("Taxa de Venda : 3%");
        
        System.out.println("----VALOR DA MOEDA----");
        System.out.println("1 BRL (Real brasileiro) = 0.0000026 BTC (Bitcoin)");
        
        //Seria bom adicionar uma função aqui para receber o valor da moeda atualizada
        //tipo:
        
        /*public Conversao(){
            ValorConvertido = Real * 0.0000026;
        }    
        */
    }
    
}
