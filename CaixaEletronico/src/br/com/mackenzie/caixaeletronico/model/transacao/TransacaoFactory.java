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
    
    /*
     * Se optar pela classe ser singleton, será dessa maneira.
     */
    
    private static SacarValor sacarValorInstance;
    private static DepositarValor depositarValorInstance;
    private static TransferirValor transferirValorInstance;
    
    static {
        sacarValorInstance = new SacarValor();
        depositarValorInstance = new DepositarValor();
        transferirValorInstance = new TransferirValor();
    }
    
    public static SacarValor getSacarValorInstance(){
        return sacarValorInstance;
    }
    
    public static DepositarValor getDepositarValorInstance(){
        return depositarValorInstance;
    }
    
    public static TransferirValor getTransferirValorInstance(){
        return transferirValorInstance;
    }
    
    /*
     * Se opter por não ser singleton será dessa maneira.
     */
    
    public static SacarValor createSacarValor(){
        return new SacarValor();
    }
    
    public static DepositarValor createDepositarValor(){
        return new DepositarValor();
    }
    
    public static TransferirValor createTransferirValor(){
        return new TransferirValor();
    }
}
