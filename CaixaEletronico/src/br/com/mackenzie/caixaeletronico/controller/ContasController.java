/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.caixaeletronico.controller;
import br.com.mackenzie.caixaeletronico.model.conta.*;
/**
 *
 * @author Antonio
 */
public class ContasController {
    
    private Cartao cartao;
    private Conta dadosConta;
    
    public void construct(Cartao cartao, String senha){
        
    }
     public boolean validarConta(Cartao cartao){
           return false;
     }
     
     public void consultarExtrato(Cartao cartao, String dtInicio, String dtFim){
         
     }
     public void transferirValor(Cartao cartao, float valor, int agencia, int conta){
         
     }
     public void depositarValor(Cartao cartao, float valor, char tipoDeposito){
         
     }
     public Conta consultarSaldo(Cartao cartao){
       return dadosConta;
     }
}
