/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller_administrador;

import DAO.CarteiraDAO;
import DAO.Conexao;
import DAO.ExtratoDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Investidor;
import view_administrador.ExtratoDoInvestidor;

/**
 *
 * @author xblak
 */
public class ControllerExtrato {
    private ExtratoDoInvestidor view;
    ArrayList<String> Extrato = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public ControllerExtrato(ExtratoDoInvestidor view) {
        this.view = view;
    }
    
    public void consultarExtrato(){
        Investidor investidor = new Investidor(null, view.getTxtCpf().getText(), null);
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            CarteiraDAO dao = new CarteiraDAO(conn);
            ResultSet res = dao.consultarcpf(investidor);
            if(res.next()){
                conn = conexao.getConnection();
                ExtratoDAO dao2 = new ExtratoDAO(conn);
                String senha = res.getString("Senha");
                investidor = new Investidor(null, null, senha);
                res = dao2.consultar(investidor);
                while(res.next()){
                    String tipo = res.getString("Tipo");
                    Double valor = res.getDouble("Valor");
                    String moeda = res.getString("Moeda");
                    Double cotacao = res.getDouble("Cotacao");
                    Double taxa = res.getDouble("Taxa");
                    Extrato.add(tipo + " " + valor + " " + moeda + " CT: " + cotacao + " TX: " + taxa + "\n");
                }
                for(String extrato: Extrato){
                    sb.append(extrato);
                }
                String extrato = sb.toString();
                view.getTxtExtrato().setText(extrato);
            }
            else{
                JOptionPane.showMessageDialog(view, "Nenhuma conta vinculada a esse cpf foi encontrada", "Erro", JOptionPane.ERROR_MESSAGE);
            }

        }catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexão", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
