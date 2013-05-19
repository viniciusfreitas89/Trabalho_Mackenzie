/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.caixaeletronico.controller;


/**
 *
 * @author Antonio
 */
public class Status {
   private int status;
   private String mensagem;
   private Object object;
   
   public Status(int status, String msg, Object object ){
       this.status = status;
       this.mensagem = msg;
       this.object = object;
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

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
