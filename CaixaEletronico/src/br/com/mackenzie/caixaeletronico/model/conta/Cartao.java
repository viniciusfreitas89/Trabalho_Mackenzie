/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.caixaeletronico.model.conta;

/**
 *
 * @author Antonio
 */
public class Cartao {
    private int numeroCartao;
    private String senha;
    
    public Cartao(int numero){
        this.numeroCartao = numero;
        this.senha = null;
    }
    
    public int getNumeroCartao() {
        return numeroCartao;
    }
    public void setNumeroCartao(int numero) {
        this.numeroCartao = numero;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
