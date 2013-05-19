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
    private boolean retido;
    private int tentativasSenha = 0;
    
    public Cartao(Conta conta, String senha){
        this.conta = conta;
        this.senha = Criptografia.criptografar(senha);
        this.numeroCartao = conta.getNumero();
        this.retido = false;
    }
    
    public Cartao(Conta conta){
        this.conta = conta;
        this.senha = "";
        this.numeroCartao = conta.getNumero();
        this.retido = false;
    }
    
    public Cartao(long numeroCartao){
        this.conta = null;
        this.senha = "";
        this.numeroCartao = numeroCartao;
        this.retido = false;
    }
    
    public Cartao(){
        this.conta = null;
        this.senha = "";
        this.numeroCartao = 0;
        this.retido = false;
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
    
    @Override
    public String toString(){
        return String.valueOf(this.numeroCartao);
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

    public boolean isRetido() {
        return retido;
    }

    public void setRetido(boolean retido) {
        this.retido = retido;
    }

    public int getTentativasSenha() {
        return tentativasSenha;
    }

    public void setTentativasSenha(int tentativasSenha) {
        this.tentativasSenha = tentativasSenha;
    }
}
