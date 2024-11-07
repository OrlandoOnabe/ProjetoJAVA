/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller_investidor;

import DAO.CarteiraDAO;
import DAO.Conexao;
import DAO.ExtratoDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
import model.Moedas;
import model.Real;
import view_investidor.Saque;

/**
 *
 * @author xblak
 */
public class ControllerSaque {
    private Saque view;
    private static String senhaLocal;

    public ControllerSaque(Saque view) {
        this.view = view;
    }

    public static String getSenhaLocal() {
        return senhaLocal;
    }

    public static void setSenhaLocal(String senhaLocal) {
        ControllerSaque.senhaLocal = senhaLocal;
    }
    
    public void saqueReal(){
        Investidor investidor = new Investidor(null, null, senhaLocal);
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            CarteiraDAO dao = new CarteiraDAO(conn);
            ResultSet res = dao.consultar(investidor);
            if(res.next()){
                double saldo = res.getDouble("Real");
                Real real = new Real(saldo, 0, null);
                double saque = Double.parseDouble(view.getTxtSacar().getText());
                real.sacar(saque);
                double novo_saldo = real.saldo;
                System.out.println(novo_saldo);
                view.getTxtSaldo().setText(String.valueOf(novo_saldo));
                Moedas moedas = new Moedas(novo_saldo, 0, null);
                dao.atualizar(moedas, investidor);
                conn = conexao.getConnection();
                ExtratoDAO dao2 = new ExtratoDAO(conn);
                dao2.inserir(senhaLocal, "-", saque, "Real", 0, 0);
                JOptionPane.showMessageDialog(view, "Saque feito", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexão", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
