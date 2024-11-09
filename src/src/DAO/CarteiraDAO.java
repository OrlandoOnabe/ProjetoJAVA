/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Bitcoin;
import model.Ethereum;
import model.Investidor;
import model.Moedas;
import model.Ripple;

/**
 *
 * @author xblak
 */
public class CarteiraDAO {
    private Connection conn;

    public CarteiraDAO(Connection conn) {
        this.conn = conn;
    }
    public ResultSet consultar(Investidor carteira) throws SQLException{
        String sql = "select * from carteira where \"Senha\" = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, carteira.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado; 
    }
    
    public void atualizar(Moedas saldo, Investidor senha) throws SQLException{
        String sql = "update carteira set \"Real\" = ? where \"Senha\" = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, saldo.getSaldo());
        statement.setString(2, senha.getSenha());
        statement.execute();
        conn.close();
    }
    
    public void atualizarRipple(Ripple saldo, Investidor senha) throws SQLException{
        String sql = "update carteira set \"Ripple\" = ? where \"Senha\" = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, saldo.getSaldoRipple());
        statement.setString(2, senha.getSenha());
        statement.execute();
    }
    
    public void atualizarBitcoin(Bitcoin saldo, Investidor senha) throws SQLException{
        String sql = "update carteira set \"Ripple\" = ? where \"Senha\" = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, saldo.getSaldoBitcoin());
        statement.setString(2, senha.getSenha());
        statement.execute();
    }
    
    public void atualizarEthereum(Ethereum saldo, Investidor senha) throws SQLException{
        String sql = "update carteira set \"Ripple\" = ? where \"Senha\" = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, saldo.getSaldoEthereum());
        statement.setString(2, senha.getSenha());
        statement.execute();
    }
    
    public void inserir(Investidor investidor, Moedas saldo) throws SQLException{
        String sql = "insert into carteira(\"Cpf\", \"Senha\", \"Real\", \"Ethereum\", \"Ripple\", \"Bitcoin\") values('"+
                investidor.getCPF()     + "', '" +
                investidor.getSenha()  + "', '" +
                saldo.getSaldo() +"', '" + saldo.getSaldo() + "', '" + saldo.getSaldo() + "', '" + saldo.getSaldo() + "')";
        System.out.println(sql);
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
}
