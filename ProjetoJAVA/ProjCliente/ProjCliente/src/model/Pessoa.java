/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author xblak
 */
public class Pessoa {
    private String CPF, nome;
    private double senha;

    public Pessoa() {
    }

    public Pessoa(String CPF, String nome, double senha) {
        this.CPF = CPF;
        this.nome = nome;
        this.senha = senha;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF; //String.valueOf(logar.getTxtCPF());
    }

    public void setCPF(String CPF) {
        this.CPF =  CPF;///String.valueOf(logar.getTxtCPF());
    }

    public double getSenha() {
        return senha; //Double.parseDouble(String.valueOf(logar.getTxtSenha()));
    }

    public void setSenha(double senha) {
        this.senha = senha;//ble.parseDouble(String.valueOf(logar.getTxtSenha()));
    }
}
