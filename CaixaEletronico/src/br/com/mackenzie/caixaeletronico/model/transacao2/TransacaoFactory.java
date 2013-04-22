/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.caixaeletronico.model.transacao2;

/**
 *
 * @author Vinicius
 */
public  class TransacaoFactory {
    
    public TransacaoFactory criarTransacao(TransacaoEnum tipo) throws Exception{
        
        if (TransacaoEnum.SAQUE == tipo){
            System.out.println("saque");
            return new SacarValor();
        }else if (TransacaoEnum.DEPOSITO == tipo){
            return new DepositarValor();
        }else if (TransacaoEnum.TRANSFERENCIA == tipo){
            return new TransferirValor();
        }
        
        throw new Exception("Tipo '"+tipo+"'.\nTipo de transação desconhecida");
    }
}
