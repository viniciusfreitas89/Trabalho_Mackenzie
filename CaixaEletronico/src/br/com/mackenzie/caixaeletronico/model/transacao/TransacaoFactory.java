/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.caixaeletronico.model.transacao;

/**
 *
 * @author Vinicius
 */
public abstract class TransacaoFactory {
        
    public static SacarValor criarSacarValor(){
        return new SacarValor();
    }
    
    public static DepositarValor criarDepositarValor(){
        return new DepositarValor();
    }
    
    public static TransferirValor criarTransferirValor(){
        return new TransferirValor();
    }
    
    public static Extrato criarExtrato(){
        return new Extrato();
    }
}
