package controller_investidor;

import DAO.Conexao;
import DAO.InvestidorDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
import view_investidor.Login_Investidor;
import view_investidor.Menu_Investidor;

public class ControllerLogin_Investidor {
    private Login_Investidor view;

    public ControllerLogin_Investidor(Login_Investidor view) {
        this.view = view;
    }
    
    public void loginInvestidor(){
        Investidor investidor = new Investidor(null, view.getTxtCPF().getText(), view.getTxtSenha().getText());
        System.out.println("4");
        Conexao conexao = new Conexao();
        System.out.println("5");
        try{
            Connection conn = conexao.getConnection();
            System.out.println("1");
            InvestidorDAO dao = new InvestidorDAO(conn);
            System.out.println("2");
            ResultSet res = dao.consultar(investidor);
            System.out.println("3");
            if(res.next()){
                JOptionPane.showMessageDialog(view, "Login feito", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                Menu_Investidor mn = new Menu_Investidor();
                String senha = investidor.getSenha();
                ControllerDeposito.setSENHA(senha);
                ControllerSaque.setSENHA(senha);
                view.setVisible(false);
                mn.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(view, "Login não foi efetuado", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexão", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
