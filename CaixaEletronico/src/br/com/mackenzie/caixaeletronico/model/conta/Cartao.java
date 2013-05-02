/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.caixaeletronico.model.conta;

import br.com.mackenzie.caixaeletronico.util.Criptografia;

/**
 *
 * @author Antonio
 */
public class Cartao {
    private Conta conta;
    private long numeroCartao;
    private String senha;
    
    public Cartao(Conta conta, String senha){
        this.conta = conta;
        this.senha = Criptografia.criptografar(senha);
        this.numeroCartao = conta.getNumero();
    }
    
    public Cartao(Conta conta){
        this.conta = conta;
        this.senha = "";
        this.numeroCartao = conta.getNumero();
    }
    
    public Cartao(long numeroCartao){
        this.conta = null;
        this.senha = "";
        this.numeroCartao = numeroCartao;
    }
    
    public Cartao(){
        this.conta = null;
        this.senha = "";
        this.numeroCartao = 0;
    }
    
    @Override
    public boolean equals(Object o){
        if (o!=null && o instanceof Cartao){
            Cartao c = (Cartao) o;
            if (c.getNumeroCartao() == this.getNumeroCartao()){
                return true;
            }
        }
        return false;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
    
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = Criptografia.criptografar(senha);
    }

    public long getNumeroCartao() {
        return numeroCartao;
    }
}
