/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.caixaeletronico.controller;
import br.com.mackenzie.caixaeletronico.model.conta.*;
import br.com.mackenzie.caixaeletronico.model.transacao.*;
import br.com.mackenzie.caixaeletronico.util.BaseDados;
import java.util.Date;
/**
 *
 * @author Antonio
 */
public class ContasController {
    
    public Cartao validarCartao(long numCartao){
       Cartao c = new Cartao(numCartao);
       int index = BaseDados.cartaoExiste(c);
         
       if(index == -1){
        return null;
       }else{
        return BaseDados.getCartoes().get(index);
       }
    }
    
    public Conta validarConta(long numConta){
       Conta c = new Conta(numConta);
       int index = BaseDados.contaExiste(c);
         
       if(index == -1){
        return null;
       }else{
        return BaseDados.getContas().get(index);
       }
       
    }
    
    public Status validarSenha(Cartao cartao){
        int index = BaseDados.cartaoExiste(cartao);
            
        if(index > -1){
            if(BaseDados.cartaoSenhaConfere(BaseDados.getCartoes().get(index), cartao.getSenha())){
                return new Status(0, "Senha válida", BaseDados.getCartoes().get(index).getConta());
            }else{
                return new Status(-2, "Senha inválida", null);
            }
        }
        return new Status(-1, "Cartão inválido", null);
     }
    
     public String consultarExtrato(Conta conta, Date dtInicio, Date dtFim){
         return TransacaoFactory.criarExtrato().consultarExtrato(conta, dtInicio, dtFim);
     }
     public boolean transferirValor(Conta contaOrigem, float valor, Conta contaDestino){
        return TransacaoFactory.criarTransferirValor().transferir(contaOrigem, contaDestino, valor);                 
     }
     public boolean depositarValor(Conta conta, float valor, char tipoDeposito){
        return TransacaoFactory.criarDepositarValor().depositar(conta, valor, true);          
     }
     public boolean sacarValor(Conta conta, float valor){
        return TransacaoFactory.criarSacarValor().sacar(conta, valor, true);        
     }     
     public void consultarSaldo(Conta conta){
         conta.getSaldo();
     }
}
