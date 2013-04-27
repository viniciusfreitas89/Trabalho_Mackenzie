/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.caixaeletronico.model.conta;


/**
 *
 * @author 71306552
 */
public class Conta {
    private Cartao cartao;
    private String numero;
    private float saldo;
    
    public Conta(String numero) throws Exception{
        if (numero.length() < 5){
            throw new Exception("O número da conta deve ter no mínimo 5 dígitos!");
        }
        this.numero = numero;
        this.saldo = 0;
        this.cartao = null;
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
}
