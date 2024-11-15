/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller_investidor;

import DAO.ExtratoDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import model.Investidor;
import view_investidor.Consultar_extrato;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author xblak
 */
public class ControllerExtrato_Investidor {
    private Consultar_extrato view;
    ArrayList<String> Extrato = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public ControllerExtrato_Investidor(Consultar_extrato view) {
        this.view = view;
    }
    
    public void consultarExtrato(){
        Investidor investidor = new Investidor(null, null, view.getTxtSenha().getText());
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            ExtratoDAO dao = new ExtratoDAO(conn);
            ResultSet res = dao.consultar(investidor);
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

        }catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexão", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
