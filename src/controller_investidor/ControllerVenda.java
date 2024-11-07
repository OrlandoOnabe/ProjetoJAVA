/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller_investidor;

import DAO.CarteiraDAO;
import DAO.Conexao;
import DAO.ExtratoDAO;
import DAO.MoedasDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import model.Bitcoin;
import model.Ethereum;
import model.Investidor;
import model.Moedas;
import model.Ripple;
import view_investidor.VendaCriptomoedas;

/**
 *
 * @author xblak
 */
public class ControllerVenda {
    private VendaCriptomoedas view;
    private Double saldo_real, saldo_ripple, saldo_bitcoin, saldo_ethereum;

    public ControllerVenda(VendaCriptomoedas view) {
        this.view = view;
    }
    
    public void validarSenha(){
        Investidor investidor = new Investidor(null, null, view.getTxtSenha().getText());
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            CarteiraDAO dao = new CarteiraDAO(conn);
            ResultSet res = dao.consultar(investidor);
            if(res.next()){
                saldo_real = res.getDouble("Real");
                saldo_ripple = res.getDouble("Ripple");
                saldo_bitcoin = res.getDouble("Bitcoin");
                saldo_ethereum = res.getDouble("Ethereum");
                conn = conexao.getConnection();
                MoedasDAO dao2 = new MoedasDAO(conn);
                Moedas moedasripple = new Moedas(0,0, "Ripple");
                res = dao2.consultarmoeda(moedasripple);
                if(res.next()){
                    double cotacao = res.getDouble("Cotacao");
                    moedasripple = new Moedas(0, cotacao, null);
                }
                Moedas moedasbitcoin = new Moedas(0,0, "Bitcoin");
                res = dao2.consultarmoeda(moedasbitcoin);
                if(res.next()){
                    double cotacao = res.getDouble("Cotacao");
                    moedasbitcoin = new Moedas(0, cotacao, null);
                }
                Moedas moedasethereum = new Moedas(0,0, "Ethereum");
                res = dao2.consultarmoeda(moedasethereum);
                if(res.next()){
                    double cotacao = res.getDouble("Cotacao");
                    moedasethereum = new Moedas(0, cotacao, null);
                }
                view.getTxtCotacao().setText("1 Bitcoin - " + moedasbitcoin.getCotacao() + "R$\n" + "1 Ethereum - " + moedasethereum.getCotacao() + "R$\n" + "1 Ripple - " + moedasripple.getCotacao() + "R$");
            }
            else{
                JOptionPane.showMessageDialog(view, "Senha inválida", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexão", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void venderMoedas(){
        Moedas moedas = new Moedas(0,0, null);
        Investidor investidor = new Investidor(null, null, view.getTxtSenha().getText());
        Conexao conexao = new Conexao();
        JRadioButton ripple = view.getBtRipple();
        JRadioButton bitcoin = view.getBtBitcoin();
        JRadioButton ethereum = view.getBtEthereum();
        if(ripple.isSelected()){
            moedas = new Moedas(saldo_real, 0, "Ripple");
        }
        else if(bitcoin.isSelected()){
            moedas = new Moedas(saldo_real, 0, "Bitcoin");
        }
        else if(ethereum.isSelected()){
            moedas = new Moedas(saldo_real, 0, "Ethereum");
        }

        try{
            Connection conn = conexao.getConnection();
            MoedasDAO dao = new MoedasDAO(conn);
            ResultSet res = dao.consultarmoeda(moedas);
            if(res.next()){
                double cotacao = res.getDouble("Cotacao");
                if(moedas.getTipo().equals("Ripple")){
                    double valorvenda = Double.parseDouble(view.getTxtValor().getText());
                    Ripple ripple1 = new Ripple(saldo_ripple, saldo_real, cotacao, null);
                    ripple1.venda(valorvenda);
                    double novo_saldoreal = ripple1.saldo;
                    double novo_saldoripple = ripple1.saldoRipple;
                    moedas = new Moedas(novo_saldoreal, 0, null);
                    System.out.println(novo_saldoreal);
                    System.out.println(novo_saldoripple);
                    CarteiraDAO dao2 = new CarteiraDAO(conn);
                    dao2.atualizarRipple(ripple1, investidor);
                    dao2.atualizar(moedas, investidor);
                    conn = conexao.getConnection();
                    ExtratoDAO dao3 = new ExtratoDAO(conn);
                    dao3.inserir(investidor.getSenha(), "-", valorvenda, "Ripple", cotacao, ripple1.taxaVenda);
                    JOptionPane.showMessageDialog(view, "Compra efetuada com sucesso", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(moedas.getTipo().equals("Bitcoin")){
                    double valorvenda = Double.parseDouble(view.getTxtValor().getText());
                    Bitcoin bitcoin1 = new Bitcoin(saldo_bitcoin, saldo_real, cotacao, null);
                    bitcoin1.venda(valorvenda);
                    double novo_saldoreal = bitcoin1.saldo;
                    double novo_saldoripple = bitcoin1.saldoBitcoin;
                    moedas = new Moedas(novo_saldoreal, 0, null);
                    System.out.println(novo_saldoreal);
                    System.out.println(novo_saldoripple);
                    CarteiraDAO dao2 = new CarteiraDAO(conn);
                    dao2.atualizarBitcoin(bitcoin1, investidor);
                    dao2.atualizar(moedas, investidor);
                    conn = conexao.getConnection();
                    ExtratoDAO dao3 = new ExtratoDAO(conn);
                    dao3.inserir(investidor.getSenha(), "-", valorvenda, "Bitcoin", cotacao, bitcoin1.taxaVenda);
                    JOptionPane.showMessageDialog(view, "Compra efetuada com sucesso", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(moedas.getTipo().equals("Ethereum")){
                    double valorvenda = Double.parseDouble(view.getTxtValor().getText());
                    Ethereum ethereum1 = new Ethereum(saldo_ethereum, saldo_real, cotacao, null);
                    ethereum1.venda(valorvenda);
                    double novo_saldoreal = ethereum1.saldo;
                    double novo_saldoripple = ethereum1.saldoEthereum;
                    moedas = new Moedas(novo_saldoreal, 0, null);
                    System.out.println(novo_saldoreal);
                    System.out.println(novo_saldoripple);
                    CarteiraDAO dao2 = new CarteiraDAO(conn);
                    dao2.atualizarEthereum(ethereum1, investidor);
                    dao2.atualizar(moedas, investidor);
                    conn = conexao.getConnection();
                    ExtratoDAO dao3 = new ExtratoDAO(conn);
                    dao3.inserir(investidor.getSenha(), "-", valorvenda, "Ethereum", cotacao, ethereum1.taxaVenda);
                    JOptionPane.showMessageDialog(view, "Compra efetuada com sucesso", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(view, "Escolha uma moeda", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexão", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
