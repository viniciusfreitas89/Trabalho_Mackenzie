/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.caixaeletronico.model.transacao2;

/**
 *
 * @author Vinicius
 */
public enum TransacaoEnum {
    SAQUE(1, "Saque"),
    DEPOSITO(2, "Depósito"),
    TRANSFERENCIA(3, "Transfência");
    
    private Integer tipo;
    private String descricao;
    
    TransacaoEnum(Integer tipo, String descricao){
        this.tipo = tipo;
        this.descricao = descricao;
    }
        
    public String getDescricao(){
        return descricao;
    }
    
    public Integer toInteger(){
        return tipo;
    }
}
