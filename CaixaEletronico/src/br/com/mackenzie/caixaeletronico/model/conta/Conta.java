/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.caixaeletronico.model.conta;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author 71306552
 */
public class Conta {
    private Cliente cliente;
    private Cartao cartao;
    private long numero;
    private float saldo;
    private List<Historico> listaHistorico;
    
    public Conta(long numero, Cliente cliente){
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = 0;
        this.cartao = null;
        
        listaHistorico = new ArrayList<Historico>();
    }
    
    @Override
    public boolean equals(Object o){
        if (o!=null && o instanceof Conta){
            Conta c = (Conta) o;
            if (c.getNumero() == this.getNumero()){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString(){
        return String.valueOf(this.numero);
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public long getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Historico> getListaHistorico() {
        return listaHistorico;
    }

    public void setListaHistorico(List<Historico> listaHistorico) {
        this.listaHistorico = listaHistorico;
    }
}
