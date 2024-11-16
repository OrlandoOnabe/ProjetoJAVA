package model;

import javax.swing.JOptionPane;



public class Investidor extends Pessoa{
    public Investidor() {
    }

    public Investidor(String nome, String CPF, String senha) {
        super(CPF, nome, senha);
    }
    
    public void testeCPF(String CPF){
        if(CPF.contains("-") || CPF.contains(".")){
            JOptionPane.showMessageDialog(null, "CPF inválido", "Erro", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Não pode o uso de caracteres especiais (hífen e/ou ponto)");
        }
    }
    
    public void testeSENHA(String SENHA){
        if(SENHA.matches("\\d{6}")){
            
        }
        else{
            JOptionPane.showMessageDialog(null, "SENHA inválido", "Erro", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Senha inválida, precisa ser númerica e com 6 digitos");
        }
    }
}
