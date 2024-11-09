/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller_investidor;

import DAO.Conexao;
import DAO.MoedasDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import model.Cotacao;
import model.Moedas;
import view_investidor.AtualizarCotacao;

/**
 *
 * @author xblak
 */
public class ControllerCotacao {
    private AtualizarCotacao view;

    public ControllerCotacao(AtualizarCotacao view) {
        this.view = view;
    }
    
    public void atualizaCotacao(){
        Moedas moedas = new Moedas(0,0, null);
        Conexao conexao = new Conexao();
        Cotacao cotacao = new Cotacao();
        JRadioButton ripple = view.getBtRipple();
        JRadioButton bitcoin = view.getBtBitcoin();
        JRadioButton ethereum = view.getBtEthereum();
        if(ripple.isSelected()){
            moedas = new Moedas(0, 0, "Ripple");
        }
        else if(bitcoin.isSelected()){
            moedas = new Moedas(0, 0, "Bitcoin");
        }
        else if(ethereum.isSelected()){
            moedas = new Moedas(0, 0, "Ethereum");
        }
        try{
            Connection conn = conexao.getConnection();
            MoedasDAO dao = new MoedasDAO(conn);
            ResultSet res = dao.consultarmoeda(moedas);
            if(res.next()){
                Double cotacaomoeda = res.getDouble("Cotacao");
                if(moedas.tipo.equals("Ripple")){
                    cotacao = new Cotacao(0, cotacaomoeda, "Ripple");
                    cotacao.atualizarCotacao(cotacaomoeda);
                    Double novo_cotacao = cotacao.nova_cotacao;
                    moedas = new Moedas(0, novo_cotacao, "Ripple");
                    dao.atualizarCotacao(moedas);
                }
                else if(moedas.tipo.equals("Bitcoin")){
                    cotacao = new Cotacao(0, cotacaomoeda, "Bitcoin");
                    cotacao.atualizarCotacao(cotacaomoeda);
                    Double novo_cotacao = cotacao.nova_cotacao;
                    moedas = new Moedas(0, novo_cotacao, "Bitcoin");
                    dao.atualizarCotacao(moedas);
                }
                else if(moedas.tipo.equals("Ethereum")){
                    cotacao = new Cotacao(0, cotacaomoeda, "Ethereum");
                    cotacao.atualizarCotacao(cotacaomoeda);
                    Double novo_cotacao = cotacao.nova_cotacao;
                    moedas = new Moedas(0, novo_cotacao, "Ethereum");
                    dao.atualizarCotacao(moedas);
                }
            }
            JOptionPane.showMessageDialog(view, "Cotação atualizada", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexão", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
