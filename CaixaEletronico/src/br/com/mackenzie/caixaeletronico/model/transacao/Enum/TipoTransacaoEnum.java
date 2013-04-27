/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.caixaeletronico.model.transacao.Enum;

/**
 *
 * @author Vinicius
 */
public enum TipoTransacaoEnum {
    DEPOSITO(1, "Depositar"),
    SAQUE(2, "Saque"),
    TRANSFERENCIA(3, "Transferencia"),
    EXTRATO(4, "Extrato");

    private int tipoTransacao;
    private String extrato;
    
    private TipoTransacaoEnum(int tipoTransacao, String extrato) {
        this.tipoTransacao = tipoTransacao;
        this.extrato = extrato;
    }
    
    public int toInteger(){
        return this.tipoTransacao;
    }
    
    @Override
    public String toString(){
        return this.extrato;
    }
}
