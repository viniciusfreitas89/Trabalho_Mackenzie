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
    
    private static SacarValor sacarValorInstance;
    private static DepositarValor depositarValorInstance;
    private static TransferirValor transferirValorInstance;
    
    static {
        sacarValorInstance = new SacarValor();
        depositarValorInstance = new DepositarValor();
        transferirValorInstance = new TransferirValor();
    }
    
    public TransacaoFactory criarTransacao(TransacaoEnum tipo) throws Exception{
        
        if (TransacaoEnum.SAQUE == tipo){
            System.out.println("saque");
            return sacarValorInstance;
        }else if (TransacaoEnum.DEPOSITO == tipo){
            System.out.println("deposito");
            return depositarValorInstance;
        }else if (TransacaoEnum.TRANSFERENCIA == tipo){
            System.out.println("transferencia");
            return transferirValorInstance;
        }
        
        throw new Exception("Tipo '"+tipo+"'.\nTipo de transação desconhecida");
    }
}
