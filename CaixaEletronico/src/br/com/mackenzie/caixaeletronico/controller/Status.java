/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.caixaeletronico.controller;

import br.com.mackenzie.caixaeletronico.model.conta.Conta;

/**
 *
 * @author Antonio
 */
public class Status {
   private int status;
   private String mensagem;
   private Conta conta;
   
   public Status(int status, String msg, Conta conta ){
       this.status = status;
       this.mensagem = msg;
       this.conta = conta;
   }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    } 
   
   
}
